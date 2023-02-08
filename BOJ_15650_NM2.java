package com.ssafy.live01.dist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15650_NM2 {
	static int N, M;
	static StringBuilder sb;
	static int[] save;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		sb = new StringBuilder();
		save = new int[M];
		sol(0,1);
		System.out.println(sb.toString());
	}
	private static void sol(int cnt, int idx) {
		if(cnt == M) {
			for(int i=0;i<M;i++) {
				sb.append(save[i] + " ");
			}
			sb.append('\n');
			return;
		}
		
		for(int i=idx; i<=N; i++) {
			save[cnt] = i;
			sol(cnt+1 , i+1);
		}
	}
}
