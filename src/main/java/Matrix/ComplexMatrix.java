package Matrix;

import java.util.ArrayList;

import Vector.ComplexVector;
import complex.Complex;

public class ComplexMatrix {

    private Complex[][] Matrix; // Matrix
    private int I; // Filas
    private int J; // Columnas
    private int mod = 0;

    /**
     * Empty ComplexMatrix constructor of i rows and j columns
     * 
     * @param i rows
     * @param j columns
     */
    public ComplexMatrix(int i, int j) {
        Matrix = new Complex[j][i];
        I = i;
        J = j;
    }

    public ComplexMatrix() {

    }
    
    /**
     * ComplexMatrix constructor from a Complex[][]
     * @param c Complex[][]
     */
    public ComplexMatrix(Complex[][] c) {
        I = c.length;
        J = c[0].length;
        Matrix = c;
    }

    /**
     * ComplexMatrix constructor from an ComplexVector[]
     * 
     * @param H  ComplexVector[]
     * @throws Exception If any of the complexVectors of the array has a different
     *                   size;
     */
    public ComplexMatrix(ComplexVector[] H) throws Exception {
        Matrix = new Complex[H.length][H[0].getSize()];
        int sV = H[0].getSize();
        for (int i = 0; i < H.length; i++) {
            if (!(H[i].getSize() == sV)) {
                throw new Exception();
            }
            for (int j = 0; j < H[0].getSize(); j++) {
                Matrix[i][j] = H[i].getVector().get(j);

            }

        }
        I = H.length;
        J = H[0].getSize();
        mod = 1;

    }

    /**
     * ComplexMatrix constructor from an ComplexVector[]
     * 
     * @param H ArrayList<ComplexVector> 
     * @throws Exception If any of the complexVectors of the array has a different
     *                   size;
     */
    public ComplexMatrix(ArrayList<ComplexVector> H) throws Exception {
        Matrix = new Complex[H.size()][H.get(0).getSize()];

        for (int i = 0; i < H.size(); i++) {
            if (!(H.get(i).getSize() == H.get(0).getSize())) {
                throw new Exception();
            }
            for (int j = 0; j < H.get(0).getSize(); j++) {
                Matrix[i][j] = H.get(i).getVector().get(j);

            }

        }
        I = H.size();
        J = H.get(0).getSize();
        mod = 1;

    }

    /**
     * Para modificacion interna, modificar libremente en la matriz en i j
     * 
     * @param i fila
     * @param j columna
     * @param c nuevo valor
     */
    private void modificar(int i, int j, Complex c) {
        Matrix[i][j] = c;
    }

    /**
     * Add complex vectors from arraylist
     * 
     * @param H ArrayList<ComplexVector> 
     * @throws Exception
     */
    public void add(ArrayList<ComplexVector> H) throws Exception {
        if (mod == 0) {
            Matrix = new Complex[H.size()][H.get(0).getSize()];

            for (int i = 0; i < H.size(); i++) {
                if (!(H.get(i).getSize() == H.get(0).getSize())) {
                    throw new Exception();
                }
                for (int j = 0; j < H.get(0).getSize(); j++) {
                    Matrix[i][j] = H.get(i).getVector().get(j);

                }

            }
            I = H.size();
            J = H.get(0).getSize();
            mod = 1;
        }

    }

    /**
     * Adds two matrixes
     * 
     * @param D the matrix to add
     * @return ComplexMatrix the added matrix
     * @throws Exception if the matrixes arent the same dimensions
     */
    public ComplexMatrix addition(ComplexMatrix D) throws Exception {
        if ((D.getI() == I && D.getJ() == J)) {
            ComplexMatrix res = new ComplexMatrix(I, J);

            for (int a = 0; a < I; a++) {
                for (int b = 0; b < J; b++) {
                    res.modificar(a, b, D.getMatrix()[a][b].Add(Matrix[a][b]));
                }

            }
            return res;
        } else
            return null; // Toca poner una excepcion
    }

    /**
     * Substracts two matrixes
     * 
     * @param D the matrix to substract
     * @return ComplexMatrix the substracted matrix
     * @throws Exception if the matrixes arent the same dimensions
     */
    public ComplexMatrix substract(ComplexMatrix D) throws Exception {
        if ((D.getI() == I && D.getJ() == J)) {
            ComplexMatrix res = new ComplexMatrix(I, J);

            for (int a = 0; a < I; a++) {
                for (int b = 0; b < J; b++) {
                    res.modificar(a, b, Matrix[a][b].Subtract(D.getMatrix()[a][b]));
                }

            }
            return res;
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
            ComplexMatrix res = new ComplexMatrix(I, J);

            for (int a = 0; a < I; a++) {
                for (int b = 0; b < J; b++) {
                    res.modificar(a, b, Matrix[a][b].inverse());

                }

                return res;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * Multiplies 2 matrixes
     * 
     * @param c matrix to multiply
     * @return Complex matrixmultiplied matrix
     * @throws Exception If the mtrixes are from diffrent size
     */
    public ComplexMatrix multiply(ComplexMatrix c) throws Exception {
        // A x B
        try {
            ComplexMatrix res = new ComplexMatrix(I, c.getJ());
            if (J == c.getI()) {
                for (int i = 0; i < I; i++) {
                    Complex[] ca = new Complex[J]; // almacena la horizaontal de la 1
                    for (int j = 0; j < J; j++) {
                        ca[j] = Matrix[i][j];
                    }

                    for (int b = 0; b < c.getJ(); b++) {
                        Complex[] cb = new Complex[c.getI()]; // almacena la vertical de B
                        for (int a = 0; a < c.getI(); a++) {
                            cb[a] = c.getMatrix()[a][b];
                        }
                        ComplexVector v1 = new ComplexVector(ca);
                        ComplexVector v2 = new ComplexVector(cb);
                        res.modificar(i, b, v1.matrixAdition(v2));
                    }

                }
                return res;

            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }

    }

    /**
     * Return the transponse of the matrix
     * 
     * @return ComplexMAtrix transposed matrix
     */
    public ComplexMatrix transpose() {
        ComplexMatrix res = new ComplexMatrix(I, J);

        for (int a = 0; a < I; a++) {
            for (int b = 0; b < J; b++) {
                res.modificar(a, b, Matrix[b][a]);
            }
        }
        return res;

    }

    /**
     * Returns the conjugate of the matrix
     * 
     * @return ComplexMatrix conjugated matrix
     */
    public ComplexMatrix conjugate() {
        ComplexMatrix res = new ComplexMatrix(I, J);

        for (int a = 0; a < I; a++) {
            for (int b = 0; b < J; b++) {
                res.modificar(a, b, Matrix[a][b].Conjugada());
            }
        }
        return res;
    }

    /**
     * returns the adjoint of the matrix
     * 
     * @return ComplexMAtrix adjoint of the matrix
     */
    public ComplexMatrix adjoint() {
        return this.transpose().conjugate();
    }

    public Complex trace() {
        Complex c = new Complex(0, 0);
        for (int i = 0; i < I; i++) {
            c = c.Add(Matrix[i][i]);

        }
        return c;
    }

    /**
     * Inner product of this and other matrix = trace (At*B)
     * 
     * @param cm opther matrix
     * @return Complex inner product
     * @throws Exception
     */
    public Complex interProduct(ComplexMatrix cm) throws Exception {
        ComplexMatrix cv = this.adjoint().multiply(cm);
        return cv.trace();

    }

    /**
     * Returns the norm of the matrix = sqrt(traza(At*A)(real part))
     * 
     * @return double the norm of this matrix
     * @throws Exception
     */
    public double norm() throws Exception {
        return Math.sqrt(this.transpose().multiply(this).trace().getReal());
    }

    
        

    
    /**
     * Returns the distance between 2 matrixes
     * @param c the other ComplexMatrix
     * @return the distance
     * @throws Exception if the matrixes are of different dimmensions
     */
    public double distance(ComplexMatrix c) throws Exception {
        return this.substract(c).norm();

    }

    /**
     * Checks if the curretn matrix is unitary (A*Aadjoint )= I
     * @return boolean
     */
    public boolean unitary() {        
        try {           
            ComplexMatrix c1 = this.multiply(this.adjoint());
            for (int a = 0; a < I; a++) {
                for (int b = 0; b < J; b++) {
                    Complex C =c1.getMatrix()[a][b];
                    if (a==b){
                        if(!(C.getReal()==1 &&C.getImag()==0)){ return false;}
                    }
                    else{
                        if(!(C.getReal()==0 &&C.getImag()==0)){ return false;}
                    }
                }
            }
            return true;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        
    }

    /**
     * Checks if the current matrix is Hermitian: At = A
     * @return boolean
     */
    public boolean hermitian(){
        if(I!=J){
            return false;
        }
        return this.equals(this.adjoint());
    }


    /**
     * Returns the tensor product between two matrixes
     * @param c the other matrix
     * @return ComplescMatrix the tensor product
     */
    public ComplexMatrix tensorProduct(ComplexMatrix c){
        int I2 = c.getI();
        int J2 = c.getJ();
        Complex[][] tpc = new Complex[I*I2][J*J2]; 
        /**
         * cada A[i][j]*B es una seccion del tensor, que una nueva matriz, la 1 es la matriz que va en 
         * el sector 1 que es la esq sup izq, el 2 es a la derecha de esa, a Aj de distancia, cuando se llega
         * al final de la nueva, se baja la siguiente seccion de filas(g) y la cluman se vuelve 0 y repetir.
         * ruega
         */
        
        int g =0; 
        int h =0;
        for(int i=0;i<I;i++){            
            for(int j=0;j<J;j++){    
                Complex[][] r =c.escalarMultply(Matrix[i][j]); // la C[] que sale de A[i][j] *B
                llenar(tpc, r, g,h);
                h++;
            }
            h=0;
            g++;

            }
        
        return new ComplexMatrix(tpc);
        }

    

    /**
     * multiplica una matriz por un comlejo.
     * @param c Complejo 
     * @return
     */
    private Complex[][] escalarMultply(Complex c){
        Complex[][] mod = new Complex[I][J];
        for(int i=0;i<I;i++){
            for(int j =0; j<J;j++){
                mod[i][j]=Matrix[i][j].Multiply(c);
                System.out.println("");
            }
        }
        return (mod);
    }
    /**
     * se llena el Complex[][] de original (og) con la filler que es 1 elemento A[i][j] *B
     * @param og
     * @param filler
     * @param vecesI
     * @param vecesJ
     * @return
     */
    private Complex[][] llenar(Complex[][] og, Complex[][] filler, int vecesI, int vecesJ){
        int iF = filler.length;
        int jF = filler[0].length;
        int inicialI = iF*vecesI; //la fila desde donde se comenzara a llenar la og 
        int inicialJ = jF*vecesJ; // la columna desde donde se comenzara a llenar la og
        int itI =0;
        int itJ =0;
        for(int a =inicialI; a<inicialI+iF;a++){
            for(int b =inicialJ; b<inicialJ+jF;b++){
                og[a][b]= filler[itI][itJ];
                
                itJ++;
            }
            itJ=0;
            itI++;

        }
        return og;



    }


    public Complex[][] getMatrix() {
        return Matrix;
    }

    public int getI() {
        return I;
    }

    public int getJ() {
        return J;
    }

    public void print() {

        for (int a = 0; a < I; a++) {
            String s = "";
            for (int b = 0; b < J; b++) {
                s += Matrix[a][b].print();
            }
            System.out.println(s);
        }

    }

    /**
     * Checks if this and the given matrix are equal
     * @param cm the other matrix
     * @return boolean
     */
    public boolean equals(ComplexMatrix cm){
        if(I!=cm.getI() || J!= cm.getJ()){return false;}
        for(int i=0;i<I;i++){
            for(int j=0;j<J;j++){
                if(!(cm.getMatrix()[i][j].equals(Matrix[i][j]))){
                    return false;
                }
            }
        }
        return true;
    }
}