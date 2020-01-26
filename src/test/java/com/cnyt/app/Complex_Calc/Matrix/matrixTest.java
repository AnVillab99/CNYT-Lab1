package com.cnyt.app.Complex_Calc.Matrix;


import java.util.ArrayList;

import Matrix.ComplexMatrix;
import org.junit.Test;
import Vector.ComplexVector;
import complex.Complex;
import junit.framework.TestCase;

public class matrixTest extends TestCase {
    /*
     * @Test public void testComplexAddition() {
     * 
     * try { ComplexMatrix cm1 = new ComplexMatrix(crearVector1()); ComplexMatrix
     * cm2 = new ComplexMatrix(crearVector2()); ComplexMatrix cm3 =
     * cm1.addition(cm2); cm3.print(); cm1 = cm1.addition(cm2);
     * Assert.assertTrue(true); } catch (Exception e) { // TODO Auto-generated catch
     * block e.printStackTrace(); }
     * 
     * }
     * 
     * @Test public void testComplexMultiplication() {
     * 
     * try { ComplexMatrix cm1 = new ComplexMatrix(crearVector1()); ComplexMatrix
     * cm2 = new ComplexMatrix(crearVector2()); ComplexMatrix cm3 =
     * cm1.multiply(cm2); cm3.print(); cm1 = cm1.addition(cm2);
     * Assert.assertTrue(true); } catch (Exception e) { // TODO Auto-generated catch
     * block e.printStackTrace(); }
     * 
     * }
     */

    @Test
    public void testConjugate() {
        try {

            ComplexMatrix cm1 = new ComplexMatrix(crearVector1()).conjugate();


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Test
    public void testTranspose() {

        try {
            ComplexMatrix cm1 = new ComplexMatrix(crearVector1()).transpose();
        
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testAdjoint(){
       
        try {
            ComplexMatrix cm1 = new ComplexMatrix(crearVector1()).adjoint();
        
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Test
    public void testDistancia() {       
        try {
            ComplexMatrix cm1 = new ComplexMatrix(crearVector2());
            System.out.println("cm1");
            cm1.print();
            ComplexMatrix cm2 = new ComplexMatrix(crearVector1());
            double r =cm1.distance(cm2);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }



    private ArrayList<ComplexVector> crearVector1(){
        Complex a =new Complex(2,2);
        Complex b =new Complex(3,2);
        Complex c =new Complex(5,6);
        Complex d =new Complex(-2,8);
        Complex[] x ={a,b};
        Complex[] y ={c,d};
        ArrayList<ComplexVector> acv = new ArrayList<ComplexVector>();
        acv.add(new ComplexVector(x));
        acv.add(new ComplexVector(y));
        return acv;
    }

    private ArrayList<ComplexVector> crearVector2(){
        Complex a =new Complex(1,2);
        Complex b =new Complex(-3,2);
        Complex c =new Complex(7,5);
        Complex d =new Complex(-4,3);
        Complex[] x ={a,b};
        Complex[] y ={c,d};
        ArrayList<ComplexVector> acv = new ArrayList<ComplexVector>();
        acv.add(new ComplexVector(x));
        acv.add(new ComplexVector(y));
        return acv;
    
    }
}

    


