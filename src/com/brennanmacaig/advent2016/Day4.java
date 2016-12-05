package com.brennanmacaig.advent2016;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Day4 {

	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("inputs/2016/day4");
		Scanner sc = new Scanner(f);
		
		while(sc.hasNextLine()) {
			String together = "";
			int[] letters = new int[26];
			String[] lettermap = { "a", "b", "c", "d", "e", 
								   "f", "g", "h", "i", "j", 
								   "k", "l", "m", "n", "o", 
								   "p", "q", "r", "s", "t", 
								   "u", "v", "w", "x", "y", "z"}; // KMS

			
			String ln = sc.nextLine();
			String remCheck = ln.substring(ln.lastIndexOf("[") + 1);
			remCheck = remCheck.replace("]", "");
			
			String id = ln.substring((ln.lastIndexOf("-") + 1), (ln.lastIndexOf("[")));
			
			
			String encrypted = ln.substring(0, (ln.lastIndexOf("-")));
			encrypted = encrypted.replaceAll("-", "");
			
			String[] arr = encrypted.split("");
			for (String s : arr) {
				int i;
				for (i = 0; i < 26; i++) {
					if(s.equals(lettermap[i])) {
						letters[i] = letters[i]+1;
					}
				}
			}
			for (int i = 0; i < 26; i++) {
				together = together + lettermap[i] + "," + letters[i] + "#";
			}
			System.out.println(together);
		}
	}
}
