package complex;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Complex {
	private double parteReal;
	private double parteImaginaria;

	public Complex(double sa, double sb) {
		parteReal = sa;
		parteImaginaria = sb;
	}

	public Complex Add(Complex c) {
		return new Complex(this.parteReal + c.getReal(), this.getImag() + c.getImag());

	}

	public Complex Subtract(Complex c) {
		return new Complex(this.parteReal - c.getReal(), this.getImag() - c.getImag());

	}

	public Complex Multiply(Complex c) {
		double a = this.parteReal;
		double A = c.getReal();
		double b = this.getImag();
		double B = c.getImag();
		return new Complex((a * A) - (b * B), (a * B + A * b));

	}

	public Complex Divide(Complex c) {
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
		return new Complex(dReal, dImag);


	
	}

	public double Modulo() {
		double a = this.parteReal;
		double b = this.getImag();
		double x = (a * a) + (b * b);
		return (Math.sqrt(x));

	}

	public Complex Conjugada() {
		return new Complex(this.getReal(), this.getImag() * -1);

	}

	public Complex Convert() {
		double x = this.getImag()/this.getReal();
		BigDecimal real = new BigDecimal(this.Modulo()).setScale(4, RoundingMode.HALF_UP);
        double dReal = real.doubleValue();
        BigDecimal imag = new BigDecimal(Math.toDegrees(Math.atan(x))).setScale(4, RoundingMode.HALF_UP);
        double dImag = imag.doubleValue();
		return new Complex(dReal, dImag);

	}
	
	public double Phase() {
		double x = this.getImag()/this.getReal();
		BigDecimal imag = new BigDecimal(Math.toDegrees(Math.atan(x))).setScale(4, RoundingMode.HALF_UP);
        double phase = imag.doubleValue();
        return phase;
	}

	public double getReal() {
		return parteReal;
	}

	public double getImag() {
		return parteImaginaria;
	}

	public boolean equals(Complex c) {
		double a = this.parteReal;
		double A = c.getReal();
		double b = this.getImag();
		double B = c.getImag();
		/*
		 * System.out.println(a);System.out.println(A);System.out.println(b);System.out.
		 * println(B);
		 */
		// System.out.println(" c " +Math.abs(a-A));
		// System.out.println(Math.abs(a-A)<0.000001);
		// System.out.println(" p " +Math.abs(b-B));
		
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
