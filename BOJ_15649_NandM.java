package com.ssafy.live02;

import java.util.Scanner;

public class BOJ_15649_NandM {
	static int N , M;
	static boolean[] selected;
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		numbers = new int[M+1];
		selected = new boolean[N+1];
		
		
		solve(0 );
		System.out.println(sb.toString());
		
		
	}

	private static void solve(int cnt) {
		if(cnt == M) {
			for(int i = 0; i<M ; i++) {
				sb.append(numbers[i] + " ");
			}
			sb.append('\n');
			return;
		}
		for(int i = 1; i<= N; i++) {
			if(selected[i] == true) {
				continue;
			}
			selected[i] = true;
			numbers[cnt] = i;
			solve(cnt + 1 );
			selected[i] = false;
		}
	}
}
