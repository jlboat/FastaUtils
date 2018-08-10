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

import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.IllegalArgumentException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Set;
/**
 *
 * @author lboat
 */
public class Fasta {
    String filename;
    String seq_type;
    LinkedHashMap<String, Sequence> lhm = new LinkedHashMap<>();
    
    /**
     * A LinkedHashMap is parsed from a FASTA file
     * 
     * @param filename
     * @param seq_type Type of sequence data in FASTA
     * @throws IOException 
     */
    public Fasta(String filename, String seq_type) throws IOException{
        if (Files.exists(Paths.get(filename))){
            this.filename = filename;
        }// end if
        if (("DNA".equals(seq_type.toUpperCase())) || 
                ("RNA".equals(seq_type.toUpperCase()))){
            this.seq_type = seq_type.toUpperCase();
        } else {
            throw new IllegalArgumentException("Incompatible sequence type");
        }
        this.parse();
    }// end constructor from filename
    
    /**
     * A FASTA object is generated from a LinkedHashMap
     * @param lhm 
     */
    public Fasta(LinkedHashMap<String, Sequence> lhm){
        this.lhm = lhm;     
    }// end constructor from header-sequence hash
    
    @Override
    public String toString(){
        String seq = this.filename + " contains " + this.lhm.size() + " entries";
        return seq;
    }
    
    private void parse() throws IOException{
        Object[] file = Files.lines(Paths.get(this.filename)).toArray();
        String header = "";
        StringBuilder seq = new StringBuilder();
        for (int i = 0; i < file.length; i++){
            String line = String.valueOf(file[i]).trim();
            if (line.startsWith(">")){
                if (seq.length() == 0){
                    header = line;
                } else{
                    if ("RNA".equals(this.seq_type)){
                        this.lhm.put(header, new RNA(seq.toString()));
                    } else if ("DNA".equals(this.seq_type)){
                        this.lhm.put(header, new DNA(seq.toString()));
                    }
                    seq = new StringBuilder();
                    header = line;
                }// end if-else                
            } else if (i == file.length-1){
                seq.append(line);
                if ("RNA".equals(this.seq_type)){
                    this.lhm.put(header, new RNA(seq.toString()));
                } else if ("DNA".equals(this.seq_type)){
                    this.lhm.put(header, new DNA(seq.toString()));
                }
            }else {
                seq.append(line);
            }// end if-else
        }// end for
    }// end parse method
    
    /**
     * Writes a FASTA object to the file specified in the argument outfile.
     * 
     * @param outfile   name of the FASTA output file  
     */
    public void toFile(String outfile){
        Path path = Paths.get(outfile);
        try (BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"))){
            for (String key: this.lhm.keySet()){
                writer.write(String.format("%s%n",key));
                writer.write(String.format("%s%n",this.lhm.get(key)));
            }// end for
        } catch (IOException ex){
            System.err.printf("Error writing file %s",ex);
        }

    }// end toFile method
    
    /**
     * Returns all of the FASTA headers as a set
     * 
     * @return  A set of the FASTA headers
     */
    public Set<String> getKeys(){
        return this.lhm.keySet();
    }// end getKeys method
    
    /**
     * Returns all of the FASTA sequences as a Collection.
     * 
     * @return Collection of FASTA sequences
     */
    public Collection<Sequence> getValues(){
        return this.lhm.values();
    }// end getValues method
    
    /**
     * Check to see if any FASTA sequences contain non [ACTGN-] characters
     * 
     * @return boolean true/false
     */
    public boolean containsAmbiguous(){
        int[] nucleotides = new int[7];
        this.lhm.values().forEach((seq) -> {
            if ("RNA".equals(seq_type)){
                Arrays.setAll(nucleotides, i -> nucleotides[i] + ((RNA)seq).getNucleotideCount()[i]);
            } else if ("DNA".equals(seq_type)){
                Arrays.setAll(nucleotides, i -> nucleotides[i] + ((DNA)seq).getNucleotideCount()[i]);
            }
        }); // end for
        return nucleotides[6] != 0;
    }// end containsAmbiguous method
}// end Fasta class 
