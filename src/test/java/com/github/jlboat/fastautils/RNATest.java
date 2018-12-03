/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jlboat.fastautils;

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
public class RNATest {
    
    public RNATest() {
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
     * Test of toString method, of class RNA.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        RNA instance = new RNA("AAAACCCGUU--N");
        String expResult = "AAAACCCGUU--N";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getKmers method, of class Sequence
     */
    @Test
    public void testGetKmers(){
        System.out.println("getKmers");
        DNA instance = new DNA("AAAACCCGUU--N");
        String[] expResult = new String[]{"AAA","AAA","AAC","ACC","CCC",
        "CCG","CGU","GUU","UU-","U--","--N"};
        String[] result = instance.getKmers(3);
        assertArrayEquals(expResult, result);
    }
    
    /**
     * Test of getNucleotideCount method, of class RNA.
     */
    @Test
    public void testGetNucleotideCount() {
        System.out.println("getNucleotideCount");
        RNA instance = new RNA("AAAACCCGUU--N");
        int[] expResult = {4,3,1,2,1,2,0};
        int[] result = instance.getNucleotideCount();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getPercGC method, of class RNA.
     */
    @Test
    public void testGetPercGC() {
        System.out.println("getPercGC");
        RNA instance = new RNA("ACAACCCGUUC-NG");
        double expResult = 0.5;
        double result = instance.getPercGC();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of length method, of class RNA.
     */
    @Test
    public void testLength() {
        System.out.println("length");
        RNA instance = new RNA("ACAACCCGUUC-NG");
        int expResult = 14;
        int result = instance.length();
        assertEquals(expResult, result);
    }

    /**
     * Test of isAmbiguous method, of class RNA.
     */
    @Test
    public void testIsAmbiguous() {
        System.out.println("isAmbiguous");
        RNA instance = new RNA("AAAACCCGUU--N");
        boolean expResult = false;
        boolean result = instance.isAmbiguous();
        assertEquals(expResult, result);
    }

    /**
     * Test of reverseComplement method, of class RNA.
     */
    @Test
    public void testReverseComplement() {
        System.out.println("reverseComplement");
        RNA instance = new RNA("AAAACCCGUU--N");
        String expResult = "N--AACGGGUUUU";
        String result = instance.reverseComplement();
        assertEquals(expResult, result);
    }
    
    /** 
     * Test of rnaToProtein method, of class RNA
     */
    @Test
    public void testRnaToProtein(){
        assertTrue("F".equals(new RNA("UUU").rnaToProtein()));
        assertTrue("L".equals(new RNA("CUU").rnaToProtein()));
        assertTrue("I".equals(new RNA("AUU").rnaToProtein()));
        assertTrue("V".equals(new RNA("GUU").rnaToProtein()));
        assertTrue("F".equals(new RNA("UUC").rnaToProtein()));
        assertTrue("L".equals(new RNA("CUC").rnaToProtein()));
        assertTrue("I".equals(new RNA("AUC").rnaToProtein()));
        assertTrue("V".equals(new RNA("GUC").rnaToProtein()));
        assertTrue("L".equals(new RNA("UUA").rnaToProtein()));
        assertTrue("L".equals(new RNA("CUA").rnaToProtein()));
        assertTrue("I".equals(new RNA("AUA").rnaToProtein()));
        assertTrue("V".equals(new RNA("GUA").rnaToProtein()));
        assertTrue("L".equals(new RNA("UUG").rnaToProtein()));
        assertTrue("L".equals(new RNA("CUG").rnaToProtein()));
        
//        lhm.put("AUG", "M");
//        lhm.put("GUG", "V");
//        lhm.put("UCU", "S");
//        lhm.put("CCU", "P");
//        lhm.put("ACU", "T");
//        lhm.put("GCU", "A");
//        lhm.put("UCC", "S");
//        lhm.put("CCC", "P");
//        lhm.put("ACC", "T");
//        lhm.put("GCC", "A");
//        lhm.put("UCA", "S");
//        lhm.put("CCA", "P");
//        lhm.put("ACA", "T");
//        lhm.put("GCA", "A");
//        lhm.put("UCG", "S");
//        lhm.put("CCG", "P");
//        lhm.put("ACG", "T");
//        lhm.put("GCG", "A");
//        lhm.put("UAU", "Y");
//        lhm.put("CAU", "H");
//        lhm.put("AAU", "N");
//        lhm.put("GAU", "D");
//        lhm.put("UAC", "Y");
//        lhm.put("CAC", "H");
//        lhm.put("AAC", "N");
//        lhm.put("GAC", "D");
//        lhm.put("UAA", "Stop");
//        lhm.put("CAA", "Q");
//        lhm.put("AAA", "K");
//        lhm.put("GAA", "E");
//        lhm.put("UAG", "Stop");
//        lhm.put("CAG", "Q");
//        lhm.put("AAG", "K");
//        lhm.put("GAG", "E");
//        lhm.put("UGU", "C");
//        lhm.put("CGU", "R");
//        lhm.put("AGU", "S");
//        lhm.put("GGU", "G");
//        lhm.put("UGC", "C");
//        lhm.put("CGC", "R");
//        lhm.put("AGC", "S");
//        lhm.put("GGC", "G");
//        lhm.put("UGA", "Stop");
//        lhm.put("CGA", "R");
//        lhm.put("AGA", "R");
//        lhm.put("GGA", "G");
//        lhm.put("UGG", "W");
//        lhm.put("CGG", "R");
//        lhm.put("AGG", "R");
//        lhm.put("GGG", "G");
    }
}
