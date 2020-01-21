package Vector;

import complex.Complex;

import java.util.HashSet;
import java.util.Vector;

import Exceptions.ComplexVectorException;

public class ComplexVector {

    private final Vector<Complex> values;
    private final int size;

    public ComplexVector() {
        size = 0;
    }

    public ComplexVector(Complex[] v, int i) throws ComplexVectorException {
        Vector<Complex> values2 = new Vector<Complex>(v.length);
        for (Complex c : v) {

            values2.add(c);
        }
        values=values2;
        size = i;
    }

    public ComplexVector(Complex[] v) throws ComplexVectorException {
        Vector<Complex>  values2 = new Vector<Complex>(v.length);
        for (Complex c : v) {
            values2.add(c);
        }
        size = values2.size();
        values=values2;

    }

    public ComplexVector(HashSet<Double[]> v) throws ComplexVectorException {
        Vector<Complex>  values2 = new Vector<Complex>(v.size());
        for (Double[] x : v) {

            Complex c;
            if (x.length == 0) {
                c = new Complex(0, 0);
                values2.add(c);
            } else if (x.length == 1) {
                c = new Complex(x[0], 0);
                values2.add(c);
            } else if (x.length == 2) {
                c = new Complex(x[0], x[1]);
                values2.add(c);
            } else {
                values = null;
                // Exception

            }

        }
        size = v.size();
        values=values2;

    }

    // addddddddddd

    public void  add(Complex[] v, int i) throws ComplexVectorException {
        Vector<Complex> values2 = new Vector<Complex>(v.length);
        for (Complex c : v) {

            values2.add(c);
        }
        values=values2;
        size = i;
    }

    public void add(Complex[] v) throws ComplexVectorException {
        Vector<Complex>  values2 = new Vector<Complex>(v.length);
        for (Complex c : v) {
            values2.add(c);
        }
        size = values2.size();
        values=values2;

    }

    public void add(HashSet<Double[]> v) throws ComplexVectorException {
        Vector<Complex>  values2 = new Vector<Complex>(v.size());
        for (Double[] x : v) {

            Complex c;
            if (x.length == 0) {
                c = new Complex(0, 0);
                values2.add(c);
            } else if (x.length == 1) {
                c = new Complex(x[0], 0);
                values2.add(c);
            } else if (x.length == 2) {
                c = new Complex(x[0], x[1]);
                values2.add(c);
            } else {
                values = null;
                // Exception

            }

        }
        size = v.size();
        values=values2;

    }

    public 

}