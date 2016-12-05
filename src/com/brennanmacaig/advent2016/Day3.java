package com.brennanmacaig.advent2016;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day3 {

	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("inputs/2016/day3");
		Scanner sc = new Scanner(f);
		int bigc = 0;
		int litc = 0;
		int[][] triangles = new int[(int) f.length()][3]; // Jank
		int validTriangle = 0;
		while(sc.hasNextLine()) {
			Scanner ls = new Scanner(sc.nextLine());
			while(ls.hasNextInt()) {
				triangles[bigc][litc] = ls.nextInt();
				System.out.println("Just read in " + triangles[bigc][litc]);
				litc++;
			}
			litc = 0;
			bigc++;
		}
		// Time to test for triangles!
		for(int i = 0; i < triangles.length; i++) {
			int F = triangles[i][0];
			int S = triangles[i][1];
			int T = triangles[i][2];
			
			int c1 = F+S;
			int c2 = S+T;
			int c3 = F+T;
			
			if((c1 > T) && (c2 > F) && (c3 > S)) {
				validTriangle++;
			}
		}
		System.out.println(Arrays.toString(triangles));
		System.out.println("Valid triangles: " + validTriangle);
	}
}
