/*
 * The MIT License
 *
 * Copyright 2018 lboat.
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
package fastautils;

/**
 *
 * @author lboat
 */
public class Sequence {
    String sequence = "";
    
    public Sequence(String sequence){
        this.sequence = sequence;
    }// end construtor
    
    @Override
    public String toString(){
        return this.sequence;
    }// end toString method
    
    /**
     * Returns counts for nucleotides (or N/-) in a sequence in an integer array
     * Will count both lower or uppercase nucleotides
     * 
     * @return integer array with [A,C,G,T,N,-] counts
     */
    public int[] getNucleotideCount(){
        char[] string = this.sequence.toCharArray();
        int[] counts = new int[6];
        for (char nucleotide: string){
            if ((nucleotide == 'A') || (nucleotide == 'a')){
                counts[0] += 1;
            } else if ((nucleotide == 'C') || (nucleotide == 'c')){
                counts[1] += 1;
            } else if ((nucleotide == 'G') || (nucleotide == 'g')){
                counts[1] += 1;
            } else if ((nucleotide == 'T') || (nucleotide == 't')){
                counts[1] += 1;
            } else if ((nucleotide == 'N') || (nucleotide == 'n')){
                counts[1] += 1;
            } else if (nucleotide == '-'){
                counts[1] += 1;
            }// end if-else
        }// end for
        return counts;
    }// end getNucleotideCount method
    
    /**
     * Returns the percent GC of the sequence
     * @return double percent GC in sequence
     */
    public double getPercGC(){
        int[] nuc_count = this.getNucleotideCount();
        double total = 0;
        for (int count: nuc_count){
            total += count;
        }// end for
        return (nuc_count[1]+nuc_count[2])/total;
    }// end getPercGC method
    
    /**
     * 
     * @return int length of sequence
     */
    public int length(){
        return this.sequence.length();
    }
}// end class
