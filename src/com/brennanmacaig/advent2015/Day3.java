package com.brennanmacaig.advent2015;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Advent of Code day 3
 * Programmed by Brennan Macaig
 * You can find the challenge here: http://adventofcode.com/2015/day/3
 */
public class Day3 {
	public static void main(String[] args) throws IOException {
		String puzzleInput = new Scanner(new File("inputs/2016/day3")).useDelimiter("\\Z").next();
		String[] puzzleArray = puzzleInput.split("");
		int xCounter = 0;
		int yCounter = 0;
		int xRobo = 0;
		int yRobo = 0;
		String pairs = "0,0";
		String roboPairs = "0,0";
		String coordPair = "";
		String coordRobo = "";
		for(int i = 0; i < puzzleArray.length; i++) {
			String s = puzzleArray[i];
			if((i == 0) || ((i%2) == 0)) {
				// normal santa
				switch(s) {
					case "^":
						yCounter++;
						break;
					case "v":
						yCounter--;
						break;
					case ">":
						xCounter++;
						break;
					case "<":
						xCounter--;
						break;
					default:
						System.out.println("Bad character this member... Skipping");
						break;
				}
				coordPair = xCounter + "," + yCounter;
				
				String matchString = "";
				boolean collision = false;
				for(String check : pairs.split("#")) {
					if(check.equals(coordPair)) {
						// Found one!
						matchString = "chk " + check + " pair: " + coordPair;
						collision = true;
						break;
					}
				}
				if(!collision) {
					pairs = pairs + "#" + coordPair;
				}
				System.out.println("NORMAL SANTA: " + coordPair + " Matched: " + collision + " " + matchString);
				
			} else {
				// Robo-Santa
				switch(s) {
					case "^":
						yRobo++;
						break;
					case "v":
						yRobo--;
						break;
					case ">":
						xRobo++;
						break;
					case "<":
						xRobo--;
						break;
					default:
						System.out.println("Bad character this member... Skipping");
						break;
				}
				coordRobo = xRobo + "," + yRobo;
				
				String matchString = "";
				boolean collision = false;
				for(String check : roboPairs.split("#")) {
					if(check.equals(coordRobo)) {
						// Found one!
						matchString = "chk " + check + " pair: " + coordRobo;
						collision = true;
						break;
					}
				}
				if(!collision) {
					roboPairs = roboPairs + "#" + coordRobo;
				}
				System.out.println("ROBO SANTA: " + coordRobo + " Matched: " + collision + " " + matchString);
			} 

		}
		String finalAns="0,0";
		String[] roboAns = roboPairs.split("#");
		String[] normAns = pairs.split("#");
		System.out.println(Arrays.toString(roboAns));
		System.out.println(Arrays.toString(normAns));
		String garbageMatch = "";
		boolean finalCollision = false;
		for (int i = 0; i < roboAns.length; i++) {
			String s = roboAns[i];
			for (int b = 0; b < normAns.length; b++) {
				String c = normAns[b];
				if(s.equals(c)) {
					// OK. So S and C are equal to each other (they must be the same pair!)
					// At this point we want to say that the array DID collide, and we SHOULDN'T match the pair into the new array.
					// Otherwise, add the pair.
					finalCollision = true;
					System.out.println("Final collision at " + s + " other is: " + c);
				}
			}
			if (!finalCollision) {
				// Nothing matched
				System.out.println("No match found for " + s);
				if(s.equals("0,0")) {
					// do nothing here
				} else {
					finalAns = finalAns + s;
				}
			}
		}
		finalAns = finalAns + "#" + pairs;
		String[] blah = finalAns.split("#");
		System.out.println(finalAns);
		System.out.println("\nFinal ans: " + blah.length);
	}
}