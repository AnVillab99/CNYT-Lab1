package complex;

import java.math.MathContext;

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

		return new Complex(Q, W);

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

		return new Complex(this.Modulo(), (Math.atan2(this.getImag(), this.getReal())));

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
