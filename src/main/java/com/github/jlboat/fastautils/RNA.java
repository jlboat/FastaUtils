/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jlboat.fastautils;

/**
 *
 * @author J. Lucas Boatwright
 */
public class RNA extends Sequence {
    RNA(String sequence){
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
}
