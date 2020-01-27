package com.cnyt.app.Complex_Calc.complex;

import complex.Complex;
import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;

import Vector.ComplexVector;

public class testVector extends TestCase {

    private ComplexVector crearVector1() {
        Complex a = new Complex(1, 1);
        Complex b = new Complex(2, 1);

        Complex[] x = { a, b };

        return new ComplexVector(x);
    }

    private ComplexVector crearVector2() {
        Complex a = new Complex(3, 1);
        Complex b = new Complex(4, 1);
        Complex[] x = { a, b };
        return new ComplexVector(x);

    }

    @Test
    public void testAddVectors() {
        try {
            Complex a = new Complex(1, 1);
            Complex b = new Complex(2, 1);
            Complex[] x = { a, b };
            ComplexVector v1 = new ComplexVector(x);
            Complex[] y = { b, a };
            ComplexVector v2 = new ComplexVector(y);

            Complex c = new Complex(3, 2);
            Complex d = new Complex(3, 2);
            Complex[] z = { c, d };
            ComplexVector v3 = new ComplexVector(z);
            ComplexVector v4 = v1.Addition(v2);
            Assert.assertTrue((v3.equals(v4)));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail();
        }

    }

    @Test
    public void testSubstractVectors() {
        try{
        Complex a = new Complex(1, 1);
        Complex b = new Complex(2, 1);
        Complex[] x = { a, b };
        ComplexVector v1 = new ComplexVector(x);
        Complex[] y = { b, a };
        ComplexVector v2 = new ComplexVector(y);
        Complex c = new Complex(-1, 0);
        Complex d = new Complex(1, 0);
        Complex[] z = { c, d };
        ComplexVector v3 = new ComplexVector(z);
        ComplexVector v4 = v1.Substraction(v2);
       
        assertTrue(v4.equals(v3));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }



    @Test
    public void testIvertVector() {
        Complex a = new Complex(1, 1);
        Complex b = new Complex(2, 1);
        Complex[] x = { a, b };
        ComplexVector v1 = new ComplexVector(x);
        Complex[] y = { b.inverse(), a.inverse() };
        ComplexVector v2 = new ComplexVector(y);
        try {      
            assertTrue(v1.equals(v2));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail();
        }
    }
        
        @Test
        public void testDotMult() {
            Complex a = new Complex(1, 1);
            Complex b = new Complex(2, 1);
            Complex[] x = { a, b };
            ComplexVector v1 = new ComplexVector(x);
            Complex[] y = { b, a };
            ComplexVector v2 = new ComplexVector(y);
            try {
                Complex c = new Complex(2, 6);
                Complex d = v1.dotMultiplication(v2);    
                assertTrue(c.equals(d));
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                fail();
            }
            
        }
    
    }



