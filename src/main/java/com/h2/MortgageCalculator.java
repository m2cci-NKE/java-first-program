package com.h2;

import java.text.DecimalFormat;

public class MortgageCalculator {
	
	public static void main(String[] args) {
		
		long loanAmont = Long.parseLong(args[0]);
		int termInYears= Integer.parseInt(args[1]);
		float annualRate= Float.parseFloat(args[2]);
		
		MortgageCalculator calculatore = new MortgageCalculator(loanAmont, termeInYears, annualRate);
		calculatore.calculateMonthlyPayment();
		System.out.println(calculatore.toString());
	}
	
	private long loanAmont;
	private static int termeInYears; 
	private float annualRate;
	private double monthlyPayment;
	
	
	public MortgageCalculator(long loanAmont,int termeInYears,float annualRate ) {
		
		this.annualRate=annualRate;
		this.termeInYears=termeInYears;
		this.loanAmont=loanAmont;
	}
	
	
	private int getNumberOfPayments() {
		
		return 12*termeInYears;
	}
	
	private float getMonthlyInterestRate(){
		float interestRate= annualRate/100;
		return interestRate/12;
	}
	
	public void calculateMonthlyPayment() {
		//M = P(r(1+r)^n/(((1+r)^n)-1)
		long P =loanAmont;
		float r = getMonthlyInterestRate();
		int n =getNumberOfPayments();
		double M = P * (((r * Math.pow(1 + r, n))) / ((Math.pow((1 + r), n)) - 1));
	
		this.monthlyPayment= M;
	
	}
	
	@Override
	public String toString() {
		
		DecimalFormat df= new DecimalFormat("####0.00");
		
		return "monthlyPayment: " + df.format(monthlyPayment);
	}
	
	
}
