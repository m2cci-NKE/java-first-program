package com.h2;

import java.text.DecimalFormat;

public class MortgageCalculator {
	
	public static void main(String[] args) {
		
		long loanAmount  = Long.parseLong(args[0]);
		int termeInYears = Integer.parseInt(args[1]);
		float annualRate= Float.parseFloat(args[2]);
		
		MortgageCalculator calculatore = new MortgageCalculator(loanAmount, termeInYears, annualRate);
		calculatore.calculateMonthlyPayment();
		System.out.println(calculatore.toString());
	}
	
	private long loanAmount;
	private static int termInYears; 
	private float annualRate;
	private double monthlyPayment;
	
	
	public MortgageCalculator(long loanAmount ,int termInYears,float annualRate ) {
		
		this.annualRate=annualRate;
		this.termInYears=termInYears;
		this.loanAmount =loanAmount ;
	}
	
	
	private int getNumberOfPayments() {
		
		return 12*termInYears;
	}
	
	private float getMonthlyInterestRate(){
		float interestRate= annualRate/100;
		return interestRate/12;
	}
	
	public void calculateMonthlyPayment() {
		//M = P(r(1+r)^n/(((1+r)^n)-1)
		long P =loanAmount;
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
