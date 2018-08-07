/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jlboat.fastautils;

import java.io.IOException;
import java.util.Collection;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author J. Lucas Boatwright
 */
public class FastaTest {
    
    public FastaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of toString method, of class Fasta.
     * @throws java.io.IOException
     */
    @Test
    public void testToString() throws IOException {
        System.out.println("toString");
        Fasta instance = new Fasta("src/test/resources/com/github/" + 
                "jlboat/fastautils/DNA.fasta", "DNA");
        String expResult = "src/test/resources/com/github/"+
                "jlboat/fastautils/DNA.fasta contains 50 entries";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

//    /**
//     * Test of toFile method, of class Fasta.
//     * @throws java.io.IOException
//     */
//    @Test
//    public void testToFile() throws IOException {
//        System.out.println("toFile");
//        String outfile = "";
//        Fasta instance = new Fasta("src/test/resources/com/github/" + 
//                "jlboat/fastautils/DNA.fasta", "DNA");
//        instance.toFile(outfile);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getKeys method, of class Fasta.
//     * @throws java.io.IOException
//     */
//    @Test
//    public void testGetKeys() throws IOException {
//        System.out.println("getKeys");
//        Fasta instance = new Fasta("src/test/resources/com/github/" + 
//                "jlboat/fastautils/DNA.fasta", "DNA");
//        Set<String> expResult = null;
//        Set<String> result = instance.getKeys();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getValues method, of class Fasta.
//     * @throws java.io.IOException
//     */
//    @Test
//    public void testGetValues() throws IOException {
//        System.out.println("getValues");
//        Fasta instance = new Fasta("src/test/resources/com/github/" + 
//                "jlboat/fastautils/DNA.fasta", "DNA");
//        Collection<Sequence> expResult = null;
//        Collection<Sequence> result = instance.getValues();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of containsAmbiguous method, of class Fasta.
     * @throws java.io.IOException
     */
    @Test
    public void testContainsAmbiguous() throws IOException {
        System.out.println("containsAmbiguous");
        Fasta instance = new Fasta("src/test/resources/com/github/" + 
                "jlboat/fastautils/DNA.fasta", "DNA");
        boolean expResult = false;
        boolean result = instance.containsAmbiguous();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
