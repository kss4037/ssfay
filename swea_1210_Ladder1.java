package com.ssafy.live02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class swea_1210_Ladder1 {
	static String ladder[][];
	static int result , now;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case = 1; test_case <= 10; test_case++) {
			int time = Integer.parseInt(br.readLine());
			
			ladder = new String[100][];
			
			for(int i=0; i<100;i++) {
				ladder[i] = br.readLine().split(" ");
			}
		
			for(int i=0; i< 100; i++) {
				if(ladder[0][i].equals("1")) {
					now = i;
					goDown(0,i);
				}
			}
			System.out.println("#" + test_case + " " + result);
		}
		
		
	}

	private static void goDown(int row , int col) {
		//System.out.println(row + " " + col);
		if(row == 99) {
			if(ladder[99][col].equals("2")) {
				result = now;
			}
			return;
		}
		if(col+1 < 100 && ladder[row][col+1].equals("1")) {
			while(col+1 < 100 && ladder[row][col+1].equals("1")) {
				col++;
			}
			row++;
			goDown(row , col);
		}
		else if(col-1 >= 0 && ladder[row][col-1].equals("1")) {
			while(col-1 >= 0 && ladder[row][col-1].equals("1")) {
				col--;
			}
			row++;
			goDown(row,col);
		}
		else {
			goDown(row+1 , col);
		}
	}
}
