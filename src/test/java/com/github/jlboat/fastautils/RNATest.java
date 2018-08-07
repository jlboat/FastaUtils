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
    
}
