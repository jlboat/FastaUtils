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
public class SequenceTest {
    
    public SequenceTest() {
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
     * Test of toString method, of class Sequence.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Sequence instance = new Sequence("AAAACCCGTT--N");
        String expResult = "AAAACCCGTT--N";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getNucleotideCount method, of class Sequence.
     */
    @Test
    public void testGetNucleotideCount() {
        System.out.println("getNucleotideCount");
        Sequence instance = new Sequence("AAAACCCGTT--N");
        int[] expResult = {4,3,1,2,1,2,0};
        int[] result = instance.getNucleotideCount();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getPercGC method, of class Sequence.
     */
    @Test
    public void testGetPercGC() {
        System.out.println("getPercGC");
        Sequence instance = new Sequence("ACAACCCGTTC-NG");
        double expResult = 0.5;
        double result = instance.getPercGC();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of length method, of class Sequence.
     */
    @Test
    public void testLength() {
        System.out.println("length");
        Sequence instance = new Sequence("ACAACCCGTTC-NG");
        int expResult = 14;
        int result = instance.length();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of isAmbiguous method, of class Sequence.
     */
    @Test
    public void testIsAmbiguous() {
        System.out.println("isAmbiguous");
        Sequence instance = new Sequence("AAAACCCGTT--N");
        boolean expResult = false;
        boolean result = instance.isAmbiguous();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of reverseComplement method, of class Sequence.
     */
    @Test
    public void testReverseComplement() {
        System.out.println("reverseComplement");
        Sequence instance = new Sequence("AAAACCCGTT--N");
        String expResult = "N--AACGGGTTTT";
        String result = instance.reverseComplement();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    
}
