package complex;

import java.math.BigDecimal;
import java.math.MathContext;

public class Complex {
	private BigDecimal parteReal;
	private BigDecimal parteImaginaria;
	
	public Complex(BigDecimal sa, BigDecimal sb) {
		parteReal=sa;
		parteImaginaria=sb;
	}
	public Complex(Double sa, Double sb) {
		parteReal=new BigDecimal(sa);
		parteImaginaria=new BigDecimal(sb);
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
	
	public BigDecimal Modulo () {
		MathContext mc = new MathContext(10);
		BigDecimal a= this.parteReal;
		BigDecimal b=this.getImag();
		BigDecimal x = a.multiply(a).add(b.multiply(b));		
		return new BigDecimal(Math.sqrt(x.doubleValue()));
		
	}
	
	public Complex Conjugada () {
		return new Complex(this.getReal() , this.getImag().negate());
		
	}
	
	public Complex Convert () {
		
		return new Complex(this.Modulo() , new BigDecimal(Math.atan2( this.getImag().doubleValue() , this.getReal().doubleValue())));
		
	}
	
	
	
	
	
	
	
	
	
	public BigDecimal getReal() {
		return parteReal;
	}
	public BigDecimal getImag() {
		return parteImaginaria;
	}
	
	public boolean equals(Complex c) {
		BigDecimal a= this.parteReal;
		BigDecimal A=c.getReal();
		BigDecimal b=this.getImag();
		BigDecimal B=c.getImag();
		//System.out.println(a);System.out.println(A);System.out.println(b);System.out.println(B);
		if ((Math.abs((c.getImag().subtract(this.getImag())).doubleValue())<=0.000001) && 
				(Math.abs((c.getReal().subtract(this.getReal())).doubleValue())<=0.000001)){
			return true;
		}
		return false;
	}
	
	public String print() {
		return "( "+this.getReal()+" , "+this.getImag()+" )";
	}
	

}
