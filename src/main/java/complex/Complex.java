package complex;

import java.math.BigDecimal;

public class Complex {
	private BigDecimal parteReal;
	private BigDecimal parteImaginaria;
	
	public Complex(BigDecimal sa, BigDecimal sb) {
		parteReal=sa;
		parteImaginaria=sb;
	}
	
	public Complex Add (Complex c) {
		return new Complex(this.parteReal.add(c.getReal()) , this.getImag().add(c.getImag()));
		
	}
	
	public Complex Subtract (Complex c) {
		return new Complex(this.parteReal.subtract(c.getReal()) , this.getImag().subtract(c.getImag()));
		
	}
	
	public Complex Multiply (Complex c) {
		BigDecimal a= this.parteReal;
		BigDecimal A=c.getReal();
		BigDecimal b=this.getImag();
		BigDecimal B=c.getImag();		
		return new Complex(a.multiply(A).subtract(b.multiply(B)),a.multiply(B).add(A.multiply(b)));
		
	}
	
	public Complex Divide (Complex c) {
		BigDecimal a= this.parteReal;
		BigDecimal A=c.getReal();
		BigDecimal b=this.getImag();
		BigDecimal B=c.getImag();
		BigDecimal Q =a.multiply(A).add(b.multiply(B)).divide(A.multiply(A).add(B.multiply(B)));
		BigDecimal W =b.multiply(A).subtract(a.multiply(B)).divide(A.multiply(A).add(B.multiply(B)));		
		
		return new Complex(Q ,W);
		
	}
	
	public Complex Modulo (Complex c) {
		return new Complex(this.parteReal+c.getReal() , this.getImag() + c.getImag());
		
	}
	public Complex Conjugada (Complex c) {
		return new Complex(this.parteReal+c.getReal() , this.getImag() + c.getImag());
		
	}
	
	public Complex Convert (Complex c) {
		return new Complex(this.parteReal+c.getReal() , this.getImag() + c.getImag());
		
	}
	
	
	
	
	
	
	
	
	public BigDecimal getReal() {
		return parteReal;
	}
	public BigDecimal getImag() {
		return parteImaginaria;
	}
	

}
