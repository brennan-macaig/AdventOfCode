package com.brennanmacaig.advent2016;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Day5 {

    public static void main(String[] args) throws Exception{
        MessageDigest md = MessageDigest.getInstance("MD5");
        String input = "uqwqemis";
        int counter = 0;
        String password = "";
        int uselessNumber = 0;
        System.out.println("Hacking door with ID " + input);
        for (int i = 0; i < 8; i++) {
            while(true) {
                String temp = input + counter++;
                md.update(temp.getBytes());
                String hash = md5BytesToString(md.digest());
                if (hash.startsWith("00000")) {
                    password += hash.substring(5, 6);
                    float percent = ((password.length() * 100)/8);
                    System.out.println("Password is " + percent + "% hacked. Current password: " + password);
                    break;
                }

            }
        }

        System.out.println("We're in... password: " + password);
        System.out.println("\nHacking second door with ID: " + input);
        char[] password2 = new char[8];
        Arrays.fill(password2, '-');
        counter = 0;
        uselessNumber = 0;
        while (!isFilled(password2)) {
            while(true) {
                String temp = input + counter++;
                md.update(temp.getBytes());
                String hash = md5BytesToString(md.digest());
                if (hash.startsWith("00000")) {
                    int loc = Integer.parseInt(hash.substring(5, 6), 16);
                    if (loc < 0 || loc > 7) break;
                    if (password2[loc] == '-') {
                        password2[loc] = hash.charAt(6);
                        uselessNumber = uselessNumber + 1;
                        float percent = (uselessNumber*100)/8;
                        System.out.println("Password is " + percent + "% hacked. Current password: " + new String(password2));
                    }
                    break;
                }
            }
        }
        System.out.println("I'm in... Password is: " + new String(password2));
    }
    
	
	static String md5BytesToString(byte[] b) {
		BigInteger bigInt = new BigInteger(1,b);
		String hashtext = bigInt.toString(16);
		while (hashtext.length() < 32) {
			hashtext = "0" + hashtext;
		}
		return hashtext;
	}

    static boolean isFilled(char[] c) {
        for (int i = 0; i < 8; i++) {
            if (c[i] == '-') return false;
        }
        return true;
    }
}
