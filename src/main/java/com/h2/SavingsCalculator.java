package com.h2;

import java.time.LocalDate;
import java.time.YearMonth;

public class SavingsCalculator {
	
	public static void main(String[] args) {
		
		String[] creditsAsString= args[0].split(",");
		String[] debitsAsString= args[1].split(",");
		
		float[] credits = null;
		float[] debits = null;
		
		for (int i = 0; i < creditsAsString.length; i++) {
			credits[i] = Utilities.getIntFloat(creditsAsString[i]);
			
		}
		
		for (int i = 0; i < debitsAsString.length; i++) {
			debits[i] = Utilities.getIntFloat(debitsAsString[i]);
			
		}
		
		SavingsCalculator calculator  =
				new SavingsCalculator(credits, debits);
		
		float netSavings = calculator.calculate();
		
		System.out.println("Net Savings = " + netSavings + ", remaining days in month = " + remainingDaysInMonth(LocalDate.now()));
	}
	
	

	private float[] credits;
	private float[] debits;
	
	
	public SavingsCalculator(float[] credits, float[] debits) {

		this.credits= credits;
		this.debits = debits;
	}
	
	private float sumOfCredits() {
		 float sum= 0.0f;
		 
		 for ( float credit : credits) {
			sum+= credit;
		}
		 
		return sum;
	}
	
	
	private float sumOfDebits() {
		
		float sum=0.0f;
		
		for (float debit : debits) {
			sum+=debit;
		}
		return sum;
	}
	
	private static int remainingDaysInMonth(LocalDate date) {
		
		YearMonth yearMonth = YearMonth.of(date.getYear(), date.getMonth());
		int totalDaysInMonth =yearMonth.lengthOfMonth();
		
		int remaningDays= totalDaysInMonth -date.getDayOfMonth();
		return remaningDays;
	}
	
	
	public float calculate() {
		
		return sumOfCredits()-sumOfDebits();
	}
	
	
	
	
}
