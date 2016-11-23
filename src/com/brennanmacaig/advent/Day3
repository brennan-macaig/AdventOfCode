import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Advent of Code day 3
 * Programmed by Brennan Macaig
 * You can find the challenge here: http://adventofcode.com/2015/day/3
 */
public class Day3 {
	public static void main(String[] args) throws IOException {
		String puzzleInput = new Scanner(new File("inputs/day3")).useDelimiter("\\Z").next();
		String[] puzzleArray = puzzleInput.split("");
		int xCounter = 0;
		int yCounter = 0;
		String pairs = "0,0";

		for(int i = 0; i < puzzleArray.length; i++) {
			String s = puzzleArray[i];
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
					break;
			}
			
			String coordPair = xCounter + "," + yCounter;
			boolean collision = false;
			for(String check : pairs.split("#")) {
				if(check.equals(coordPair)) {
					// Found one!
					System.out.println("Found a match! Check: " + check + " Pair: " + coordPair);
					collision = true;
					break;
				}
			}
			if(!collision) {
				pairs = pairs + "#" + coordPair;
			}
		}
		System.out.println("Final string value representation:");
		System.out.println(pairs);
		String[] garbageAns = pairs.split("#");
		System.out.println("Individual houses: " + garbageAns.length);
	}
}
