package Matrix;

import complex.Complex;

public class Matrix {

    private Complex [][] Matrix; //Matrix
    int I; //Filas
    int J; // Columnas


    public Matrix(int i,int j){
        Matrix = new Complex[i][j];
        I=i;
        J=j;
    }

    
    public Matrix(Complex[][] H){
        Matrix=H;
        J=H[0].length;
        I=H.length;

    }
    public Matrix add(Matrix D){
        if((D.getI()==I && D.getJ()==J)){
            Complex [][] B=D.getMatrix();
            for(int a=0; a<=I;a++){
                for(int b=0; b<=J;b++){
                    B[a][b]=B[a][b].Add(Matrix[a][b]);
                }
            }
            return new Matrix(B);
        }
        else return null; // Toca poner una excepcion
        
    }

    public Matrix substract(Matrix D){
        if((D.getI()==I && D.getJ()==J)){
            Complex [][] B=D.getMatrix();
            for(int a=0; a<=I;a++){
                for(int b=0; b<=J;b++){
                    B[a][b]=B[a][b].Subtract(Matrix[a][b]);
                }
            }
            return new Matrix(B);
        }
        else return null; // Toca poner una excepcion
        
    }

    public Complex[][] getMatrix() {
        return Matrix;
    }

    public void setMatrix(Complex[][] v) {
        Matrix = v;
    }

    public int getI() {
        return I;
    }

    public void setI(int i) {
        I = i;
    }

    public int getJ() {
        return J;
    }

    public void setJ(int j) {
        J = j;
    }
    
}