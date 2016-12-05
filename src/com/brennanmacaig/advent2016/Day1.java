package com.brennanmacaig.advent2016;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day1 {

	public static void main(String[] args) throws FileNotFoundException {
		String puzzleInput = new Scanner(new File("inputs/2016/day1")).useDelimiter("\\Z").next();
		String[] puzzleArray = puzzleInput.split(", ");
		int xCount = 0;
		int yCount = 0;
		
		int yneg = 0;
		int ypos = 0;
		int xneg = 0;
		int xpos = 0;
		
		String orientation = "N";
		
		for(int i = 0; i < puzzleArray.length; i++) {
			puzzleArray[i] = puzzleArray[i].replaceAll(" ", "");
		}
		
		for(String s : puzzleArray) {
			// Read in the string character by character.
			String num = s.substring(1);
			if(s.startsWith("R")) {
				// Right movement.
				switch(orientation) {
					case "N":
						orientation = "E";
						xpos = xpos + Integer.parseInt(num);
						break;
					case "E":
						orientation = "S";
						yneg = yneg + Integer.parseInt(num);
						break;
					case "S":
						orientation = "W";
						xneg = xneg + Integer.parseInt(num);
						break;
					case "W":
						orientation = "N";
						ypos = ypos + Integer.parseInt(num);
						break;
				}
			} else {
				// Left movement.
				switch(orientation) {
				case "N":
					orientation = "W";
					xneg = xneg + Integer.parseInt(num);
					break;
				case "E":
					orientation = "N";
					ypos = ypos + Integer.parseInt(num);
					break;
				case "S":
					orientation = "E";
					xpos = xpos + Integer.parseInt(num);
					break;
				case "W":
					orientation = "S";
					yneg = yneg + Integer.parseInt(num);
				}
			}
		}
		
		xCount = xpos - xneg;
		yCount = ypos - yneg;
		String coordPair = "(" + xCount + "," + yCount + ")";
		double hyp = Math.hypot(xCount, yCount);
		int tot = Math.abs(xCount) + Math.abs(yCount);
		System.out.println("Input file generated final location of " + coordPair);
		System.out.println("Ideally this is " + hyp + " blocks away.");
		System.out.println("Realistically, this is " + tot + " blocks away.");
	}
	
}
