package complex;

import junit.framework.Assert;
import junit.framework.TestCase;

public class ComplexTest extends TestCase {

	public void testComplex() {
		fail("Not yet implemented");
	}
	
	
	public void testAdd() {
		Complex a = new Complex (5.87,-3.7);
		Complex b = new Complex (2.0, 5.9);
		Complex resultado = new Complex (7.87, 2.2);
		Complex c = a.Add(b);
		Assert.assertTrue(resultado.equals(c));
		//Assert.assertEquals(a.Add(b),resultado);
		
		//fail("Not yet implemented");
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
		Complex resultado = new Complex (33.43,26.82);		
		Complex c = a.Multiply(b);
		System.out.println(c.print());
		Assert.assertTrue(resultado.equals(c));
	}

	public void testDivide() {
		fail("Not yet implemented");
	}

	public void testModulo() {
		fail("Not yet implemented");
	}

	public void testConjugada() {
		fail("Not yet implemented");
	}

	public void testConvert() {
		fail("Not yet implemented");
	}

	public void testGetReal() {
		fail("Not yet implemented");
	}

	public void testGetImag() {
		fail("Not yet implemented");
	}

}
