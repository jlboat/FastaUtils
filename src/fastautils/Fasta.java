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

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Set;
/**
 *
 * @author lboat
 */
public class Fasta {
    String filename;
    LinkedHashMap<String, Sequence> lhm = new LinkedHashMap<>();
    
    public Fasta(String filename) throws IOException{
        if (Files.exists(Paths.get(filename))){
            this.filename = filename;
        }// end if
        this.parse();
    }// end constructor from filename
    
    public Fasta(LinkedHashMap lhm){
        this.lhm = lhm;     
    }// end constructor from header-sequence hash
    
    private void parse() throws IOException{
        Object[] file = Files.lines(Paths.get(this.filename)).toArray();
        String header = "";
        StringBuilder seq = new StringBuilder();
        for (Object obj: file){
            String line = String.valueOf(obj).trim();
            if (line.startsWith(">")){
                if (seq.length() == 0){
                    header = line;
                } else{
                    this.lhm.put(header, new Sequence(seq.toString()));
                    seq = new StringBuilder();
                    header = line;
                }// end if-else                
            } else {
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
    public Set getKeys(){
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
}// end Fasta class 
