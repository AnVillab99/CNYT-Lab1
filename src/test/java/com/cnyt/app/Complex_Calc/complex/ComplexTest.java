package com.cnyt.app.Complex_Calc.complex;

import complex.Complex;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;


public class ComplexTest extends TestCase {

	@Test
	public void testComplex() {
		Complex a = new Complex (5.87,-3.7);
		Complex b = new Complex (5.87,-3.7);
		Assert.assertTrue(a.equals(b));
		
	}
	
	
	public void testAdd() {
		Complex a = new Complex (5.87,-3.7);
		Complex b = new Complex (2.0, 5.9);
		Complex resultado = new Complex (7.87, 2.2);
		Complex c = a.Add(b);
		Assert.assertTrue(resultado.equals(c));
	}
		

	public void testSubtract() {
		Complex a = new Complex (5.87,-3.7);
		Complex b = new Complex (2.0, 5.9);
		Complex resultado = new Complex (3.87,-9.6);
		Complex c = a.Subtract(b);
		Assert.assertTrue(resultado.equals(c));
	}

	public void testMultiply() {
		Complex a = new Complex (5.87,-3.7);
		Complex b = new Complex (2.0, 5.9);
		Complex resultado = new Complex (33.57,27.233);		
		Complex c = a.Multiply(b);
		Assert.assertTrue(resultado.equals(c));
	}

	public void testDivide() {
		Complex a = new Complex (5.87,-3.7);
		Complex b = new Complex (2.0, 5.9);
		Complex resultado = new Complex (-0.259985,-1.083046);		
		Complex c = a.Divide(b);
		
		Assert.assertTrue(resultado.equals(c));
	}

	public void testModulo() {
		Complex a = new Complex (5.87,-3.7);
		double resultado = 6.93879672;
		Assert.assertTrue(Math.abs(resultado-a.Modulo())<=0.00000001);
	}

	public void testConjugada() {
		Complex a = new Complex (5.87,-3.7);
		Complex c = new Complex (5.87,3.7);		
		Assert.assertTrue(a.Conjugada().equals(c));
		
	}

	public void testConvert() {
		Complex a = new Complex (5.87,-3.7);
		Complex resultado = new Complex(6.9388,-32.2242);
		Complex c = a.Convert();
		Assert.assertTrue(resultado.equals(c));
	}

	public void testGetReal() {
		Complex a = new Complex (5.87,-3.7);
		double c = 5.87;
		Assert.assertTrue(c==a.getReal());
	}

	public void testGetImag() {
		Complex a = new Complex (5.87,-3.7);
		double c = -3.7;
		Assert.assertTrue(c==a.getImag());
	}
	
	public void testPhase() {
		Complex a = new Complex (5.87,-3.7);
		Double resultado = -32.2242;
		Double c = a.Phase();
		Assert.assertTrue(resultado.equals(c));
		
	}

}
