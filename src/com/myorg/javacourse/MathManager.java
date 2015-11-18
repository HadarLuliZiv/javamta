package com.myorg.javacourse;

public class MathManager {
	
	static double radius, angleB, hypotenuse, base, exp;
	
	public MathManager(double radiusVal, double angleBVal, double hypotenuseVal,double baseVal, double expVal) {
		radius= radiusVal;
		angleB= angleBVal;
		hypotenuse= hypotenuseVal;
		base= baseVal;
		exp= expVal;
	}

	public static double CalculateCircleArea(){
	    double area = Math.PI * radius * radius;
        
        System.out.println("Area of a circle with radius " + radius + "is:" + area+ " square­cm.");
        return area;
	}
	
	public static double CalculateOppositeLength(){
		double opposite = hypotenuse*Math.sin(angleB * Math.PI/180);
		 System.out.println("Length of opposite where angle B is 30 degrees and Hypotenuse length is 50 cm is "+ opposite);
		return opposite;
	}
	
	public static double CalculatePower(){
		double result= Math.pow(base,exp);
		System.out.println("Power of 20 with exp of 13 is "+ result);
		return result;
	}
	
	public static String getResults(){
		String line1 =("calculation 1: Area of circle with radius " + radius +" is " + MathManager.CalculateCircleArea());
		String line2 =("calculation 2: Length of opposite where angle B is " +angleB + MathManager.CalculateOppositeLength());
		String line3 =("calculation 3: Power of base "+base+ " with exp of " +exp+ " is "+ MathManager.CalculatePower());
		String resultStr =( line1 + "<br>" +line2+ "<br>" +line3 );
		return resultStr;
	}
}
