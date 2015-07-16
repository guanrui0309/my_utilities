package com.cola.getdir;

public class Pow {

	private static double EXPECT_VALUE = 1000;
	private static double BASE_NUMBER = 2.0;

	/*
	 * public static void main(String[] args) {
	 * 
	 * for (double b = 0; b <= EXPECT_VALUE; b++) { if (Math.pow(BASE_NUMBER, b)
	 * <= EXPECT_VALUE) { System.out.println(b); } }
	 * 
	 * }
	 */

	public static void main(String[] args) {

		double max = Math.log(EXPECT_VALUE) / Math.log(BASE_NUMBER);
		for (double i = 0; i <= max; i++)
			System.out.println("2 ^ " + i + " less than " + EXPECT_VALUE);
	}

}
