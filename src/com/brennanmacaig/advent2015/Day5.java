package com.brennanmacaig.advent2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day5 {

	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("inputs/2015/day5");
		Scanner sc = new Scanner(f);
		int counter = 0;
		/*
		String stringToMatch = "abccdef";
		Pattern p = Pattern.compile("(\\w)\\1+");
		Matcher m = p.matcher(stringToMatch);
		if (m.find()) {
		    System.out.println("Duplicate character " + m.group(1));
		}
	*/
		
		while(sc.hasNextLine()) {
			String temp = sc.nextLine();
			
			if(temp.contains("ab") || temp.contains("cd") || temp.contains("pq") || temp.contains("xy")) {
				System.out.println("Naughty string: " + temp + " - Contains illegal combo!");
				continue;
			} else if(!doubleLetter(temp)) {
				System.out.println("Naughty string: " + temp + " - No double letter!");
				continue;
			} else if(!(vowelChecker(temp) >= 3)) {
				System.out.println("Naughty string: " + temp + " - Not enough vowels!");
				continue;
			} else {
				counter++;
			}
		}
		
		System.out.println("Done reading file. Number of nice strings: " + counter);
	}
	
	public static boolean doubleLetter(String s) {
		Pattern p = Pattern.compile("(\\w)\\1+");
		Matcher m = p.matcher(s);
		if (m.find()) {
			return true;
		} else {
			return false;
		}
	}
	
	public static int vowelChecker(String s) {
		String[] check = s.split("");
		int c = 0;
		for(int a = 0; a < check.length; a++) {
			if(check[a].equals("a") || check[a].equals("e") || check[a].equals("i") || check[a].equals("o") || check[a].equals("u")) {
				c++;
			}
		}
		return c;
	}
}
