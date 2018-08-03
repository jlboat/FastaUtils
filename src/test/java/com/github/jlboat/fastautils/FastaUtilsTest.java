/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jlboat.fastautils;

import java.io.IOException;
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
public class FastaUtilsTest {
    
    public FastaUtilsTest() {
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
     * Test of getSeqCount method, of class FastaUtils.
     * @throws java.io.IOException
     */
    @Test
    public void testGetSeqCount() throws IOException {
        System.out.println("getSeqCount");
        Fasta fasta = new Fasta("src/test/resources/com/github/" + 
                "jlboat/fastautils/DNA.fasta", "DNA");
        int expResult = 50;
        int result = FastaUtils.getSeqCount(fasta);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

//    /**
//     * Test of getLengths method, of class FastaUtils.
//     */
//    @Test
//    public void testGetLengths() {
//        System.out.println("getLengths");
//        Fasta fasta = null;
//        int[] expResult = null;
//        int[] result = FastaUtils.getLengths(fasta);
//        assertArrayEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of nX method, of class FastaUtils.
     */
    @Test
    public void testNX() {
        System.out.println("nX");
        Fasta fasta = null;
        double x = 0.0;
        int expResult = 0;
        int result = FastaUtils.nX(fasta, x);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of minLength method, of class FastaUtils.
     */
    @Test
    public void testMinLength() {
        System.out.println("minLength");
        Fasta fasta = null;
        int expResult = 0;
        int result = FastaUtils.minLength(fasta);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of maxLength method, of class FastaUtils.
     */
    @Test
    public void testMaxLength() {
        System.out.println("maxLength");
        Fasta fasta = null;
        int expResult = 0;
        int result = FastaUtils.maxLength(fasta);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of medianLength method, of class FastaUtils.
     */
    @Test
    public void testMedianLength() {
        System.out.println("medianLength");
        Fasta fasta = null;
        double expResult = 0.0;
        double result = FastaUtils.medianLength(fasta);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of meanLength method, of class FastaUtils.
     */
    @Test
    public void testMeanLength() {
        System.out.println("meanLength");
        Fasta fasta = null;
        double expResult = 0.0;
        double result = FastaUtils.meanLength(fasta);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of baseCumulativeSum method, of class FastaUtils.
     */
    @Test
    public void testBaseCumulativeSum() {
        System.out.println("baseCumulativeSum");
        Fasta fasta = null;
        int[] expResult = null;
        int[] result = FastaUtils.baseCumulativeSum(fasta);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
