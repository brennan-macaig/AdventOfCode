package com.brennanmacaig.advent2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Day1.java
 * Written by Brennan Macaig for the Advent of Code 2015 Challenge
 * Day 1's challenge can be found here: http://adventofcode.com/2015/day/1
 * @author Brennan
 *
 */
public class Day1 {
	public static int i = 0;
	public static int position = 1;
	public static void main(String[] args) throws FileNotFoundException {
		String puzzleInput = new Scanner(new File("inputs/2015/day1")).useDelimiter("\\Z").next();
		String[] puzzleArray = puzzleInput.split("");
		
		for(String s : puzzleArray) {
			if(s.equalsIgnoreCase("(")) {
				i++;
			} else if(s.equalsIgnoreCase(")")) {
				i--;
			} else {
				// won't happen.
			}
			
			if (i == -1) {
				// Position is here
				System.out.println("Position: " + position);
			}
			position++;
		}
		
		System.out.println("i = " + i);
	}
}
