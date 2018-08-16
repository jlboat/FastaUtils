/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jlboat.fastautils;

import java.util.Arrays;
import java.util.LinkedHashMap;

/**
 *
 * @author J. Lucas Boatwright
 */
public class RNA extends Sequence {
    public RNA(String sequence){
        super(sequence);
    }
    
    @Override
    public boolean isAmbiguous(){
        return this.getNucleotideCount()[6] != 0;
    }// end isAmbiguous method
    
    /**
     * Returns counts for nucleotides (or N/-/other) in a sequence in an integer array
     * Will count both lower or uppercase nucleotides
     * 
     * @return integer array with [A,C,G,T,N,-,other] counts
     */
    public int[] getNucleotideCount(){
        char[] string = this.sequence.toCharArray();
        int[] counts = new int[7];
        for (char nucleotide: string){
            if ((nucleotide == 'A') || (nucleotide == 'a')){
                counts[0] += 1;
            } else if ((nucleotide == 'C') || (nucleotide == 'c')){
                counts[1] += 1;
            } else if ((nucleotide == 'G') || (nucleotide == 'g')){
                counts[2] += 1;
            } else if ((nucleotide == 'U') || (nucleotide == 'u')){
                counts[3] += 1;
            } else if ((nucleotide == 'N') || (nucleotide == 'n')){
                counts[4] += 1;
            } else if (nucleotide == '-'){
                counts[5] += 1;
            } else{
                counts[6] += 1;
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
     * @return String reverse complement of the sequence
     */
    public String reverseComplement(){
        char[] revComp = new char[this.sequence.length()];
        char[] string = this.sequence.toCharArray();
        for (int i = 0; i < string.length; i++) {
            revComp[string.length-(i+1)] = string[i];
        } 
        for (int i = 0; i < revComp.length; i++){
            char nucleotide = revComp[i];
            if ((nucleotide == 'A') || (nucleotide == 'a')){
                revComp[i] = 'U';
            } else if ((nucleotide == 'C') || (nucleotide == 'c')){
                revComp[i] = 'G';
            } else if ((nucleotide == 'G') || (nucleotide == 'g')){
                revComp[i] = 'C';
            } else if ((nucleotide == 'U') || (nucleotide == 'u')){
                revComp[i] = 'A';
            } else {
                revComp[i] = nucleotide;
            }
        }// end for
        return String.valueOf(revComp);
    }// end reverseComplement method
    
    public String rnaToProtein() {
        LinkedHashMap<String, String> lhm = new LinkedHashMap<>();
        lhm.put("UUU", "F");
        lhm.put("CUU", "L");
        lhm.put("AUU", "I");
        lhm.put("GUU", "V");
        lhm.put("UUC", "F");
        lhm.put("CUC", "L");
        lhm.put("AUC", "I");
        lhm.put("GUC", "V");
        lhm.put("UUA", "L");
        lhm.put("CUA", "L");
        lhm.put("AUA", "I");
        lhm.put("GUA", "V");
        lhm.put("UUG", "L");
        lhm.put("CUG", "L");
        lhm.put("AUG", "M");
        lhm.put("GUG", "V");
        lhm.put("UCU", "S");
        lhm.put("CCU", "P");
        lhm.put("ACU", "T");
        lhm.put("GCU", "A");
        lhm.put("UCC", "S");
        lhm.put("CCC", "P");
        lhm.put("ACC", "T");
        lhm.put("GCC", "A");
        lhm.put("UCA", "S");
        lhm.put("CCA", "P");
        lhm.put("ACA", "T");
        lhm.put("GCA", "A");
        lhm.put("UCG", "S");
        lhm.put("CCG", "P");
        lhm.put("ACG", "T");
        lhm.put("GCG", "A");
        lhm.put("UAU", "Y");
        lhm.put("CAU", "H");
        lhm.put("AAU", "N");
        lhm.put("GAU", "D");
        lhm.put("UAC", "Y");
        lhm.put("CAC", "H");
        lhm.put("AAC", "N");
        lhm.put("GAC", "D");
        lhm.put("UAA", "Stop");
        lhm.put("CAA", "Q");
        lhm.put("AAA", "K");
        lhm.put("GAA", "E");
        lhm.put("UAG", "Stop");
        lhm.put("CAG", "Q");
        lhm.put("AAG", "K");
        lhm.put("GAG", "E");
        lhm.put("UGU", "C");
        lhm.put("CGU", "R");
        lhm.put("AGU", "S");
        lhm.put("GGU", "G");
        lhm.put("UGC", "C");
        lhm.put("CGC", "R");
        lhm.put("AGC", "S");
        lhm.put("GGC", "G");
        lhm.put("UGA", "Stop");
        lhm.put("CGA", "R");
        lhm.put("AGA", "R");
        lhm.put("GGA", "G");
        lhm.put("UGG", "W");
        lhm.put("CGG", "R");
        lhm.put("AGG", "R");
        lhm.put("GGG", "G");
        char[] seq_array = this.sequence.toCharArray();
        StringBuilder protein = new StringBuilder();
        for (int i = 0; i < this.sequence.length(); i += 3) {
            char[] slice = Arrays.copyOfRange(seq_array, i, i + 3);
            String codon = String.valueOf(slice);
            if (codon != null) {
                protein.append(lhm.get(codon));
            }
        }
        return protein.toString();
    } // end rnaToProtein method
}
