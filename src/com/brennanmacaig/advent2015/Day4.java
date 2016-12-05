package com.brennanmacaig.advent2015;

import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * Advent of Code day 4
 * By Brennan Macaig
 * Find the challenge here: http://adventofcode.com/2015/day/4
 * 
 * FUN FACT: This is the first challenge that doesn't read in from a file.
 * See the day 4 file for more information.
 */
public class Day4 {
	public static void main(String[] args) throws FileNotFoundException, NoSuchAlgorithmException { 
		String puzzleInput = "iwrupvqb";
		int counter = 0;
		MessageDigest m = MessageDigest.getInstance("MD5");
		while(true) {
			String text = puzzleInput + counter;
			m.reset();
			m.update(text.getBytes());
			byte[] digest = m.digest();
			BigInteger bigInt = new BigInteger(1,digest);
			String hashtext = bigInt.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0"+hashtext;
			}
			// For part two, just add a zero to the value there.
			// I've left it at part 1's value for now.
			if(hashtext.startsWith("00000")) {
				System.out.println("\n=====================\n");
				System.out.println("Verify MD5: " + hashtext);
				System.out.println("Magic number: " + counter);
				System.out.println("All done!");
				break;
			}
			counter++;
		}
		
	}
}
