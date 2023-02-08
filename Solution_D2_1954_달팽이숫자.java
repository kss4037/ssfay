package hwalgo02_부울경_04반_권선근;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D2_1954_달팽이숫자 {
	static StringBuilder sb = new StringBuilder();
	
	static int snail[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int idx = 1;
			int cnt = 0;
			int N = sc.nextInt();
			snail = new int[N][N];
			sb.setLength(0);
			while(cnt != N/2) {
				for(int i=0+cnt;i<N-1-cnt;i++) {
					snail[cnt][i] = idx++;
				}
				for(int i=0+cnt;i<N-1-cnt;i++) {
					snail[i][N-1-cnt] = idx++;
				}
				for(int i = N-1-cnt;i>cnt;i--) {
					snail[N-1-cnt][i] = idx++;
				}
				for(int i = N-1-cnt;i>cnt;i--) {
					snail[i][cnt] = idx++;
				}
				cnt++;
//				for(int i=0;i<N;i++) {
//					System.out.println(Arrays.toString(snail[i]));
//				}
//				System.out.println();
			}
			if(N%2 == 1) {
				snail[N/2][N/2] = idx++;
			}
			System.out.println("#" + test_case);
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					sb.append(snail[i][j] + " ");
				}
				sb.append('\n');
			}
			sb.deleteCharAt(sb.length()-1);
			System.out.println(sb.toString());
		}
	}
}
