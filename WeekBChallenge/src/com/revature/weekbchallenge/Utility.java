package com.revature.weekbchallenge;

import java.util.ArrayList;
import java.util.Scanner;

public class Utility {
	
	ArrayList<String> bank = new ArrayList<String>();
	private String start;
	private String end;
	
	public static int mutationCount(String start, String end) {
		
		int numMutations = 0;
		for(int index = 0; index < start.length(); index++) {
		
			char s;
			char e;
			
			s = start.charAt(index);
			e = end.charAt(index);
			
			if(s != e) {
				numMutations++;
			}
		}
		return numMutations; 
	}

	public static boolean geneChecker(String userInput) {
		
		userInput = userInput.toLowerCase();
		
		if(userInput.length() != 8) {
			System.out.println("Gene strings must be 8 characters long try again");
			return false;
		}
		for(int i = 0; i < userInput.length(); i++) {
			char c;
			c = userInput.charAt(i);
			if(c != 'a') { 
				if(c != 'c') {
					if(c != 'g') {
						if(c != 't') {
							System.out.println("Gene strings must be an A, C, G or T");
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	public void userInput() {
		
		boolean sTest = false;
		boolean eTest = false;
		
		int totalMutations;
		
		String start;
		String end;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Input the first gene string");
		
		while(sTest != true) {
			start = sc.next();
			sTest = Utility.geneChecker(start);
			if(sTest == true) {
				this.start = start;
			}
		}
		
		
		System.out.println("Input the end gene string");
		while(eTest != true) {
			end = sc.next();
			eTest = Utility.geneChecker(end);
			if(eTest == true) {
				this.end = end;
			}
		}
		
		totalMutations = Utility.mutationCount(this.start, this.end);
		
		System.out.println(totalMutations);
		
		sc.close();
	}
	
	public void populateBank(String input){
		
		this.bank.add(input);
	}
	
	public int mutationCheck(String start, String end) {
		
		
		if( !bank.contains(end)) {
			return -1;
		}
		
		if(start.equals(end)) {
			return 0;
		}
		
		
		return start + mutationCheck(start.);
	}

}
