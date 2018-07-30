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
package fastautils;

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
