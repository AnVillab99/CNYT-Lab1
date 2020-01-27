package com.cnyt.app.Complex_Calc.complex;

import complex.Complex;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;

public class ComplexTest extends TestCase {

	@Test
	public void testdebeCrearComplejos() {
		final Complex a = new Complex(5.87, -3.7);
		final Complex b = new Complex(5.87, -3.7);
		Assert.assertTrue(a.equals(b));

	}

	@Test
	public void testdebeAñadirComplejos() {
		final Complex a = new Complex(5.87, -3.7);
		final Complex b = new Complex(2.0, 5.9);
		final Complex resultado = new Complex(7.87, 2.2);
		final Complex c = a.Add(b);
		Assert.assertTrue(resultado.equals(c));
	}

	@Test
	public void testdebeRestarCOmplejos() {
		final Complex a = new Complex(5.87, -3.7);
		final Complex b = new Complex(2.0, 5.9);
		final Complex resultado = new Complex(3.87, -9.6);
		final Complex c = a.Subtract(b);
		Assert.assertTrue(resultado.equals(c));
	}

	@Test
	public void testdebeMultiplicarComplejos1() {
		final Complex a = new Complex(5.87, -3.7);
		final Complex b = new Complex(2.0, 5.9);
		final Complex resultado = new Complex(33.57, 27.233);
		final Complex c = a.Multiply(b);
		Assert.assertTrue(resultado.equals(c));
	}

	@Test
	public void testdebeMultiplicarComplejosConCeros() {
		final Complex a = new Complex(5.87, -3.7);
		final Complex b = new Complex(0, 0);
		final Complex resultado = new Complex(0, 0);
		final Complex c = a.Multiply(b);
		Assert.assertTrue(resultado.equals(c));
	}

	@Test
	public void testdebeDividirComplejos() {
		final Complex a = new Complex(5.87, -3.7);
		final Complex b = new Complex(2.0, 5.9);
		final Complex resultado = new Complex(-0.259985, -1.083046);
		Complex c;
		try {
			c = a.Divide(b);
			Assert.assertTrue(resultado.equals(c));
		} catch (final Exception e) {

			e.printStackTrace();
			fail();
		}

	}

	@Test
	public void testnoDebeDividirComplejosCero() {
		final Complex a = new Complex(5.87, -3.7);
		final Complex b = new Complex(0, 0);

		try {
			
			Complex c = a.Divide(b);

			fail();
		} catch (final Exception e) {
			assertTrue(e.getMessage().equals("Denominador cero"));
		}

	}

	@Test
	public void testModulo() {
		final Complex a = new Complex(5.87, -3.7);
		final double resultado = 6.93879672;
		Assert.assertTrue(Math.abs(resultado - a.Modulo()) <= 0.00000001);
	}

	@Test
	public void testConjugada() {
		final Complex a = new Complex(5.87, -3.7);
		final Complex c = new Complex(5.87, 3.7);
		Assert.assertTrue(a.Conjugada().equals(c));

	}

	@Test
	public void testConvert() {
		final Complex a = new Complex(5.87, -3.7);
		final Complex resultado = new Complex(6.9388, Math.toRadians(-32.2242));
		final Complex c = a.Convert();
		Assert.assertTrue(resultado.equals(c));
	}

	@Test
	public void testGetReal() {
		final Complex a = new Complex(5.87, -3.7);
		final double c = 5.87;
		Assert.assertTrue(c == a.getReal());
	}

	@Test
	public void testGetImag() {
		final Complex a = new Complex(5.87, -3.7);
		final double c = -3.7;
		Assert.assertTrue(c == a.getImag());
	}

	@Test
	public void testPhase() {
		final Complex a = new Complex(5.87, -3.7);
		final Double resultado = -32.2242;
		final Double c = a.Phase();
		Assert.assertTrue(resultado.equals(c));
		
	}

}
