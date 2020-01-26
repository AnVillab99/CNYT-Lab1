package Matrix;

import java.util.ArrayList;

import Vector.ComplexVector;
import complex.Complex;

public class ComplexMatrix {

    private ArrayList<ComplexVector> Matrix; // Matrix
    private int I; // Filas
    private int J; // Columnas

    /**
     * Empty ComplexMatrix constructor of i rows and j columns
     * 
     * @param i rows
     * @param j columns
     */
    public ComplexMatrix(int i, int j) {
        Matrix = new ArrayList<ComplexVector>();
        I = i;
        J = j;
    }

    public ComplexMatrix() {

    }

    /**
     * ComplexMatrix constructor from an ComplexVector[]
     * 
     * @param H
     * @throws Exception If any of the complexVectors of the array has a different
     *                   size;
     */
    public ComplexMatrix(ComplexVector[] H) throws Exception {
        Matrix = new ArrayList<ComplexVector>();
        int sV = H[0].getSize();
        for (ComplexVector cv : H) {
            if (!(cv.getSize() == sV))
                throw new Exception();
            Matrix.add(cv);

        }
        J = H.length;
        I = sV;

    }

    /**
     * ComplexMatrix constructor from an ComplexVector[]
     * 
     * @param H
     * @throws Exception If any of the complexVectors of the array has a different
     *                   size;
     */
    public ComplexMatrix(ArrayList<ComplexVector> H) throws Exception {
        Matrix = new ArrayList<ComplexVector>();
        int sV = H.get(0).getSize();
        for (ComplexVector cv : H) {
            if (!(cv.getSize() == sV))
                throw new Exception();
            Matrix.add(cv);

        }
        J = H.size();
        I = sV;

    }

    public void add(ArrayList<ComplexVector> H) throws Exception {
        Matrix = new ArrayList<ComplexVector>();
        int sV = H.get(0).getSize();
        for (ComplexVector cv : H) {
            if (!(cv.getSize() == sV))
                throw new Exception();
            Matrix.add(cv);

        }
        J = H.size();
        I = sV;

    }

    /**
     * Adds two matrixes
     * 
     * @param D the matrix to add
     * @return the added matrix
     * @throws Exception if the matrixes arent the same dimensions
     */
    public ComplexMatrix addition(ComplexMatrix D) throws Exception {

        if ((D.getI() == I && D.getJ() == J)) {
            ArrayList<ComplexVector> B = new ArrayList<ComplexVector>();
            for (int a = 0; a <= I; a++) {
                B.add(D.getRow(a).Addition(Matrix.get(a)));

            }
            return new ComplexMatrix(B);
        } else
            return null; // Toca poner una excepcion

    }

    /**
     * Substracts two matrixes
     * 
     * @param D the matrix to substract
     * @return the substracted matrix
     * @throws Exception if the matrixes arent the same dimensions
     */
    public ComplexMatrix substract(ComplexMatrix D) throws Exception {
        if ((D.getI() == I && D.getJ() == J)) {
            ArrayList<ComplexVector> B = new ArrayList<ComplexVector>();
            for (int a = 0; a <= I; a++) {
                B.add(D.getRow(a).Substraction(Matrix.get(a)));

            }
            return new ComplexMatrix(B);
        } else
            return null; // Toca poner una excepcion

    }

    /**
     * Returns the inverse of the matrix
     * 
     * @return ComplexMatrix inverse
     * 
     */
    public ComplexMatrix inverse() {
        try {
            ArrayList<ComplexVector> sm = new ArrayList<ComplexVector>();
            for (ComplexVector cv : Matrix) {
                sm.add(cv.Invert());

            }

            return new ComplexMatrix(sm);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }

    public ComplexMatrix multiply(ComplexMatrix c) throws Exception {
        // A x B
        if (J == c.getI()) {
            ComplexMatrix cm = new ComplexMatrix();
            ArrayList<ComplexVector> acv = new ArrayList<ComplexVector>();

            for (int i = 0; i < I; i++) {// itera por las filas (I) de la matriz A
                ArrayList<Complex> ac1 = new ArrayList<Complex>();

                for (int j = 0; j < c.getJ(); j++) { // itera por las columnas(J) de B
                    ArrayList<Complex> ac2 = new ArrayList<Complex>(); // AL<C> que seria la columna j
                    for (ComplexVector cv : c.getMatrix()) {
                        ac2.add(cv.getVector().get(j));
                    }
                    try {
                        ac1.add(Matrix.get(i).matrixAdition(new ComplexVector(ac2)));
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }

                acv.add(new ComplexVector(ac1));

            }
            try {
                cm.add(acv);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return cm;
        }
        else{throw new Exception();}
    }

    public ArrayList<ComplexVector> getMatrix() {
        return Matrix;
    }


    public int getI() {
        return I;
    }



    public int getJ() {
        return J;
    }

    public ComplexVector getRow(int i) {return Matrix.get(i);}

	public void  print() {
		for(ComplexVector cv :Matrix){
            cv.print();
        }
	}


}