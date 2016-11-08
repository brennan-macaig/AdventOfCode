package com.brennanmacaig.advent;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Day2 {

	public static int getMinValue(int[] array) {
		int minValue = array[0];
		for(int i = 1; i < array.length; i++) {
			if(array[i] < minValue) {
				minValue = array[i];
			}
		}
		return minValue;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		int counter = 0;
		int answer = 0;
		int ribbon = 0;
		String puzzleInput = new Scanner(new File("inputs/day2")).useDelimiter("\\Z").next();
		puzzleInput = puzzleInput.replace("\n", "").replaceAll("\r", "y");
		String[] puzzleArray = puzzleInput.split("y");
		String[][] arrayOfStringArrays = new String[puzzleArray.length][3];
		
		for(int i = 0; i < puzzleArray.length; i++) {
			
			String[] s = puzzleArray[i].split("x");
			for(int a = 0; a < 3; a++) {
				
				arrayOfStringArrays[counter][a] = s[a];
			}
			counter++;
		}
		/* Shout out to Phanta on the FRC-Discord server for helping me with this.
		 * I don't know how this works, and I don't want to. It just does.
		 */
		int[][] nums = Arrays.stream(arrayOfStringArrays).map(row -> Arrays.stream(row).mapToInt(num -> Integer.parseInt(num)).toArray()).toArray(int[][]::new);
		
		// Lets do some math, shall we?
		int L=0, W=1, H=2;
		
		for(int i = 0; i < nums.length; i++) {
			System.out.println("----- LOOP " + i + " -----");
			int length = nums[i][L];
			int width = nums[i][W];
			int height = nums[i][H];
			
			int LW = length*width;
			int WH = width*height;
			int HL = height*length;
			
			int[] test = {LW, WH, HL};
			int toAdd = getMinValue(test);
			System.out.println("Smallest Value (added) " + toAdd);
			System.out.println("Total this box: " + (2*LW + 2*WH + 2*HL + toAdd));
			answer = 2*LW + 2*WH + 2*HL + toAdd + answer;
			
			// -------- Ribbon --------
			int p1 = width + height + width + height;
			int p2 = length + height + length + height;
			int p3 = width + length + width + length;
			System.out.println("P1: " + p1 + " P2: " + p2 + " P3: " + p3);
			int[] perimTest = {p1, p2, p3};
			int smallestPerim = getMinValue(perimTest);
			System.out.println("Smallest Side: " + smallestPerim);
			int volume = length * width * height;
			System.out.println("Ribbon this box: " + (volume+smallestPerim));
			ribbon = smallestPerim + volume + ribbon;
		}
		System.out.println("====================================\nDONE!");
		System.out.println("Paper: " + answer);
		System.out.println("Ribbon: " + ribbon);
	}
	
	
}
