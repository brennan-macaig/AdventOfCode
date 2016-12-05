package com.brennanmacaig.advent2016;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 {
	
	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("inputs/2016/day2");
		Scanner sc = new Scanner(f);
		int startRow = 2;
		int startbtn = 5;				
		int currbtn = 5;
		int currRow = 2;
		String ans = "";
		
		while(sc.hasNextLine()) {
			String store = sc.nextLine();
			String[] puzzArray = store.split("");
			int test = 0;
			
			for(String s : puzzArray) {
				switch(s) {
					case "U": {
						test = currbtn - 3;
						if(test < 1) {
							break;
						}
						currbtn = test;
						currRow--;
						break;
					}
					case "D":{
						test = currbtn + 3;
						if(test > 9) {
							break;
						}
						currbtn = test;
						currRow++;
						break;
					}
					case "L":{
						test = currbtn - 1;
						switch(currRow) {
							case 1:
								if(test < 1) {
									break;
								}
								currbtn = test;
								break;
							case 2:
								if (test < 4) {
									break;
								}
								currbtn = test;
								break;
							case 3:
								if (test < 7) {
									break;
								}
								currbtn = test;
								break;
						}
						break;
					}
					case "R":{
						test = currbtn + 1;
						switch(currRow) {
						case 1:
							if(test > 3) {
								break;
							}
							currbtn = test;
							break;
						case 2:
							if (test > 6) {
								break;
							}
							currbtn = test;
							break;
						case 3:
							if (test > 9) {
								break;
							}
							currbtn = test;
							break;
						}
						break;
					}
				}
			}
			System.out.println("Button for this line was: " + currbtn);
			ans = ans + currbtn;
		}
		
		System.out.println("Keypad entry should be: " + ans);
	}
	
}
