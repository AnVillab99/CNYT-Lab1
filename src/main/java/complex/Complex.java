package complex;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Implemntacion de numeros complejos, compuesto de 2 reales
 * Uno represnta la parte real y otro la imaginaria
 */
public class Complex {
	private double parteReal;
	private double parteImaginaria;

	/**
	 * Constructor vacio de complejos
	 */
	public Complex(){}
	/**
	 * Constructor de complejos que recibe doubles
	 * @param sa double real
	 * @param sb double imaginario
	 */
	public Complex(double sa, double sb) {
		parteReal = sa;
		parteImaginaria = sb;
	}

	/**
	 * Constructor de complejo que recibe enteros
	 * @param sa int real 
	 * @param sb int imaginario
	 */
	public Complex(int sa, int sb) {
		parteReal =  new Double(sa);
		parteImaginaria = new Double(sb);
	}

	/**
	 * Constructor de enteros que recibe real double imaginario entero
	 * @param sa double real
	 * @param sb int imaginario
	 */
	public Complex(double sa, int sb) {
		parteReal = new Double(sa);
		parteImaginaria = sb;
	}

	/**
	 * Constructor de complejos recibe real entero imaginario doule
	 * @param sa int real
	 * @param sb double imaginario
	 */
	public Complex(int sa, double sb) {
		parteReal = sa;
		parteImaginaria = new Double(sb);
	}

	/**
	 *  Suma este y el complejo dado
	 * @param c complejo a sumar
	 * @return Complex suma
	 */
	public Complex Add(Complex c) {
		return new Complex((double)(this.parteReal + c.getReal()), (double)(this.getImag() + c.getImag()));

	}

	/**
	 *  Resta este y el complejo dado
	 * @param c complejo a restar
	 * @return Complex suma
	 */
	public Complex Subtract(Complex c) {
		return new Complex((double)(this.parteReal - c.getReal()), (double)(this.getImag() - c.getImag()));

	}

	/**
	 * Multiplica este con el complejo dado
	 * @param c complejo dado
	 * @return complejos multiplicados
	 */
	public Complex Multiply(Complex c) {
		double a = this.parteReal;
		double A = c.getReal();
		double b = this.getImag();
		double B = c.getImag();
		double C=(a * A) - (b * B);
		double D=(a * B + A * b);
		return new Complex(C,D);

	}

	/**
	 * Multilpica este complejo por un double
	 * @param c double a multiplicar
	 * @return Complejo
	 */
	public Complex SMultiply(double c){
		double a = this.parteReal;
		double b = this.getImag();
		return new Complex((double)(a * c),(double)(b * c) );
	}

	/**
	 * retorna el inverso de este complejo
	 * @return complejo inverso
	 */
	public Complex inverse(){
		double a = this.parteReal;
		double b = this.getImag();
		return new Complex((double)-a,(double) -b);

	}
	/**
	 * Divide este complejo por uno dado
	 * @param c complejo denominador
	 * @return complejo division
	 * @throws Exception Si el denominador es 0
	 */
	public Complex Divide(Complex c) throws Exception{
		if(c.getImag()==0 && c.getReal()==0){
			throw new Exception("Denominador cero");
		}
		double a = this.parteReal;
		double A = c.getReal();
		double b = this.getImag();
		double B = c.getImag();
		double Q = ((a * A) + (b * B)) / ((A * A) + (B * B));
		double W = ((b * A) - (a * B)) / ((A * A) + (B * B));
		BigDecimal real = new BigDecimal(Q).setScale(6, RoundingMode.HALF_UP);
        double dReal = real.doubleValue();
        BigDecimal imag = new BigDecimal(W).setScale(6, RoundingMode.HALF_UP);
        double dImag = imag.doubleValue();
		return new Complex((double)dReal, (double)dImag);
	
	}	

	/**
	 * Divide el complejo por un entero
	 * 
	 * @param c double denominador
	 * @return complejo dividido
	 * @throws Exception Si el denominador es 0
	 */
	public Complex SDivide(double c) throws Exception {
		if(c==0){throw new Exception("Denominador cero");}
		double a = this.parteReal;
		double b = this.getImag();
		return new Complex((double)(a / c), (double)(b/c));


	}
	/**
	 * devuelve el modulo del complejo
	 * @return double modulo del complejo
	 */
	public double Modulo() {
		double a = this.parteReal;
		double b = this.getImag();
		double x = (a * a) + (b * b);
		return (Math.sqrt(x));

	}
	/**
	 * Devuelve la conjugada del complejo
	 * @return complejo conjugado
	 */
	public Complex Conjugada() {
		return new Complex(this.getReal(), this.getImag() * -1);

	}

	/**
	 * Convierte el complejo a coordenadas polares
	 * @return complejo con los valores polares
	 */
	public Complex Convert() {
		double x = this.getImag()/this.getReal();
		BigDecimal real = new BigDecimal(this.Modulo()).setScale(4, RoundingMode.HALF_UP);
        double dReal = real.doubleValue();
        BigDecimal imag = new BigDecimal(Math.toDegrees(Math.atan(x))).setScale(4, RoundingMode.HALF_UP);
        double dImag = imag.doubleValue();
		return new Complex((double)dReal, (double)Math.toRadians(dImag));

	}
	
	/**
	 * Devulve la fase del complejo
	 * @return double fase
	 */
	public double Phase() {
		double x = this.getImag()/this.getReal();
		BigDecimal imag = new BigDecimal(Math.toDegrees(Math.atan(x))).setScale(4, RoundingMode.HALF_UP);
        double phase = imag.doubleValue();
        return (double)phase;
	}

	public double getReal() {
		return parteReal;
	}

	public double getImag() {
		return parteImaginaria;
	}

	/**
	 * Comprara este y otro complejo
	 * @param c complejo
	 * @return boolean
	 */
	public boolean equals(Complex c) {
		
		if ((Math.abs((c.getImag() - (this.getImag()))) <= 0.0000001)
				&& (Math.abs((c.getReal() - (this.getReal()))) <= 0.0000001)) {
			return true;
		}
		return false;
	}

	public String print() {
		return "( " + this.getReal() + " , " + this.getImag() + " )";
	}

}
