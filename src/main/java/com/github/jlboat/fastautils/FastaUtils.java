/*
 * The MIT License
 *
 * Copyright 2018 J. Lucas Boatwright.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.github.jlboat.fastautils;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 *
 * @author lboat
 */
public class FastaUtils {
    public static LinkedHashMap<String, Number> stats(Fasta fasta){
        LinkedHashMap<String, Number> stats = new LinkedHashMap<>();
        stats.put("Count", seqCount(fasta));
        stats.put("Minimum", minLength(fasta));
        stats.put("Maximum", maxLength(fasta));
        stats.put("Median", medianLength(fasta));
        stats.put("Mean", meanLength(fasta));
        stats.put("N50", nX(fasta, 50));
        return stats;
    }
    
    public static int seqCount(Fasta fasta){
        Set<String> keys = fasta.getKeys();
        return keys.size();
    }
   
    public static int[] seqLengths(Fasta fasta){
        Sequence[] seqs = fasta.getValues().toArray(new Sequence[0]);
        int[] lengths = new int[seqs.length];
        for (int i = 0; i < seqs.length; i++) {
            lengths[i] = seqs[i].length();            
        }
        return lengths;
    }
    
    public static int nX(Fasta fasta, double x){
        if ((x>100)||(x<0)){
            System.err.printf("Invalid value for nX: %f:.2",x);
            System.err.println("Must be between 0 and 100");
            System.err.println("Typical values include N25, N50, N75");
            return -1;
        }
        int[] lengths = seqLengths(fasta);
        if(lengths.length == 1){
            System.err.printf("Only one sequence present. Cannot calculate N%f:.0",
                    x);
        }
        x = x/100;
        Arrays.sort(lengths);
        int[] cum_sum = baseCumulativeSum(fasta);
        int total_base_count = cum_sum[lengths.length-1];
        for (int i = 0; i < cum_sum.length; i++) {
            int index = cum_sum.length - (i+1);
            if (((total_base_count-cum_sum[index])/(double)total_base_count) > x){
                return lengths[index+1];
            }
        }
        // In the event the above code fails
        return -1;
    }
    
    public static int minLength(Fasta fasta){
        int[] lengths = seqLengths(fasta);
        Arrays.sort(lengths);
        return lengths[0];
    }
    
    public static int maxLength(Fasta fasta){
        int[] lengths = seqLengths(fasta);
        Arrays.sort(lengths);
        return lengths[lengths.length-1];
    }
    
    public static double medianLength(Fasta fasta){
        int[] lengths = seqLengths(fasta);
        Arrays.sort(lengths);
        int index = lengths.length/2;
        if(lengths.length % 2 == 1){ //odd num -- exact middle           
            return lengths[index];
        } else { // even number -- double
            double median = (lengths[index-1] + (double)lengths[index])/2;
            return median;
        }
    }
    
    public static double meanLength(Fasta fasta){
        int[] lengths = seqLengths(fasta);
        int total_length = baseCumulativeSum(fasta)[lengths.length-1];
        return total_length/(double)lengths.length;
    }
    
    public static int[] baseCumulativeSum(Fasta fasta){
        int[] lengths = seqLengths(fasta);
        Arrays.sort(lengths);
        int[] cum_sum = new int[lengths.length];
        cum_sum[0] = lengths[0];
        for (int i = 1; i < cum_sum.length; i++) {
            cum_sum[i] = cum_sum[i-1] + lengths[i];
        }
        return cum_sum;
    }
    
    public static Fasta randomFasta(int number_seqs, int seq_lengths){
        LinkedHashMap<String, Sequence> lhm = new LinkedHashMap<>();
        for (int i = 0; i < number_seqs; i++) {
            String key = ">sequence_" + i;
            DNA dna = SequenceUtils.randomDNA(seq_lengths);
            lhm.put(key, dna);
        }       
        return new Fasta(lhm);
    }
}
