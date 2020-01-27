package Vector;

import complex.Complex;

import java.util.ArrayList;
import java.util.HashSet;

import Exceptions.ComplexVectorException;

/**
 * Public class ComplexVector, once the values are set they cannot be directly
 * changed
 */
public class ComplexVector {

    private ArrayList<Complex> values;
    private int size;
    private int mod = 0;

    /**
     * Empy ComplexVector constructor
     */
    public ComplexVector() {
        size = 0;

    }

    /**
     * COnstructs ComplexVector from a complex array Complex[]
     * 
     * @param v Complex[] array
     */
    public ComplexVector(Complex[] v) {
        values = new ArrayList<Complex>();
        for (Complex c : v) {
            values.add(c);
        }
        size = values.size();

        mod = 1;

    }

    /**
     * ComplexVector constructor from complex arraylist ArrayList<Complex>
     * 
     * @param v ArrayList<Complex>
     */
    public ComplexVector(ArrayList<Complex> v) {
        values = new ArrayList<Complex>();
        for (Complex x : v) {
            values.add(x);
        }
        size = v.size();
        mod = 1;
    }

    /**
     * Create vector from Hashset<Double[]>, the array must be of 1 or 2 numbers
     * only, anything else will throw an exception
     * 
     * @param v Hashset<Double[]>
     * @throws ComplexVectorException
     */
    public ComplexVector(HashSet<Double[]> v) throws ComplexVectorException {
        values = new ArrayList<Complex>();
        for (Double[] x : v) {

            Complex c;
            if (x.length == 0) {
                c = new Complex(0, 0);
                values.add(c);
            } else if (x.length == 1) {
                c = new Complex(x[0], 0);
                values.add(c);
            } else if (x.length == 2) {
                c = new Complex(x[0], x[1]);
                values.add(c);
            } else {
                values = null;
                // Exception hay uno o mas valores no validos

            }

        }
        size = v.size();
        mod = 1;

    }

    // addddddddddds

    /**
     * add vector from Complex[]
     * 
     * @param v
     * @throws ComplexVectorException
     */
    public void add(Complex[] v) throws ComplexVectorException {
        if (mod == 0) {
            ArrayList<Complex> values2 = new ArrayList<Complex>(v.length);
            for (Complex c : v) {
                values2.add(c);
            }
            size = values2.size();
            values = values2;
            mod = 1;

        }
    }

    /**
     * Add to vector from Hashset<Double> the array must be of 1 or 2 numbers only,
     * anything else will throw an exception
     * 
     * @param v
     * @throws ComplexVectorException
     */
    public void add(HashSet<Double[]> v) throws ComplexVectorException {
        if (mod == 0) {

            ArrayList<Complex> values2 = new ArrayList<Complex>(v.size());
            for (Double[] x : v) {

                Complex c;
                if (x == null) {
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
            values = values2;
            mod = 1;

        }
        // else //throw exception
    }

    /**
     * Add to complexvector from ArrayList<Complex>
     * 
     * @param v ArrayList<Complex>
     */
    public void add(ArrayList<Complex> v) {

        if (mod == 0) {
            values = new ArrayList<Complex>();

            for (Complex x : v) {

                values.add(x);
            }
            size = v.size();
            mod = 1;
        }

    }

    public int getSize() {
        return size;
    }

    /**
     * returns the complex vector of the vector
     * 
     * @return
     */
    public ArrayList<Complex> getVector() {
        return values;
    }

    /**
     * Returns the addition of the given and this ComplexVector
     * 
     * @param cv the other ComplexVector
     * @return the added vector
     * @throws Exception if the other vector has a diferent dimension
     */
    public ComplexVector Addition(ComplexVector cv) throws Exception {

        if (cv.getSize() == this.size) {
            ComplexVector r = new ComplexVector();
            ArrayList<Complex> vr = new ArrayList<Complex>();
            ArrayList<Complex> v2 = cv.getVector();
            for (int i = 0; i < v2.size(); i++) {
                vr.add(v2.get(i).Add(values.get(i)));

            }
            r.add(vr);
            return r;

        } else
            throw new Exception();

    }

    /**
     * Returns the substraction of the given and this ComplexVector
     * 
     * @param cv the other ComplexVector
     * @return the substracted vector
     * @throws Exception if the other vector has a diferent dimension
     */
    public ComplexVector Substraction(ComplexVector cv) throws Exception {

        if (cv.getSize() == this.size) {
            ComplexVector r = new ComplexVector();
            ArrayList<Complex> vr = new ArrayList<Complex>();
            ArrayList<Complex> v2 = cv.getVector();
            for (int i = 0; i < v2.size(); i++) {
                vr.add(values.get(i).Subtract(v2.get(i)));
            }
            r.add(vr);
            return r;

        } else
            throw new Exception();

    }

    /**
     * Returns the inverse of this ComplexVector
     * 
     * @return the inverse of this vector
     */
    public ComplexVector Invert() {
        ComplexVector r = new ComplexVector();
        ArrayList<Complex> vr = new ArrayList<Complex>();
        for (int i = 0; i < size; i++) {
            vr.add(values.get(i).inverse());
        }
        r.add(vr);
        return r;

    }

    /**
     * Return the escalar multiplication of the given vector and this one
     * 
     * @param cv Given ComplexVector
     * @return double the scalar multipication
     * @throws Exception if the gicen vector has another dimension
     */
    public Complex dotMultiplication(ComplexVector cv) throws Exception {
        if (cv.getSize() == this.size) {
            Complex r = new Complex(0, 0);
            ArrayList<Complex> v2 = cv.getVector();
            for (int i = 0; i < v2.size(); i++) {
                r.Add(values.get(i).Multiply(v2.get(i)));
            }
            return r;
        } else
            throw new Exception();

    }

    /**
     * Return the ComplexVector multiplied by a complex
     * 
     * @param c the complex to multiply
     * @return multiplied ComplexVector
     */
    public ComplexVector EscMultiplication(Complex c) {
        ComplexVector r = new ComplexVector();
        ArrayList<Complex> vr = new ArrayList<Complex>();
        for (int i = 0; i < values.size(); i++) {
            vr.add(values.get(i).Multiply(c));
        }
        r.add(vr);
        return r;

    }

    /**
     * Returns the summatory of the multiplication of each element of two
     * complexVectors as a single complex
     * 
     * @param c the other complex vector
     * @return Complex
     * @throws Exception
     */
    public Complex matrixAdition(ComplexVector c) throws Exception {
        if (c.getSize() == size) {
            Complex res = new Complex(0, 0);

            for (int i = 0; i < size; i++) {
                Complex T = values.get(i).Multiply(c.getVector().get(i));

                res = res.Add(T);
            }

            return res;
        } else
            throw new Exception();

    }

    public void print() {
        String s = "";
        for (Complex c : values) {

            s += "[ " + c.print() + " ]";

        }
        System.out.println(s);
    }

    public ComplexVector conjugate() {
        Complex[] c = new Complex[this.values.size()];
        for (int i = 0; i < size; i++) {
            c[i] = values.get(i).inverse();

        }
        return new ComplexVector(c);

    }

    public Complex interProduct(ComplexVector cv) throws Exception {
        if (this.size != cv.getSize())
            throw new Exception();
        Complex ip = new Complex(0, 0);
        ComplexVector cv2 = cv.conjugate();
        for (int i = 0; i < size; i++) {
            ip = ip.Add(values.get(i).Multiply(cv2.getVector().get(i)));
        }
        return ip;

    }

    public double norm() throws Exception {
        return Math.sqrt(this.interProduct(this).getReal());
    }

    public double distance(ComplexVector cv) throws Exception {

        ComplexVector r = this.Substraction(cv);
        return Math.sqrt(r.interProduct(r).getReal());

    }

    public boolean equals(ComplexVector c){
        if(c.getSize() != size){return false;}
        for(int i=0;i<size;i++){
            if(!(c.getVector().get(i).equals(values.get(i)))){return false;}
        }
        return true;
    }

}