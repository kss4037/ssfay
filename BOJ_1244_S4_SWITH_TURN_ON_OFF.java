package ssafu_pre;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1244_S4_SWITH_TURN_ON_OFF {
	
	static boolean state[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        
		int num_switch = Integer.parseInt(br.readLine());
		state = new boolean[num_switch+1];
		String[] state_string = br.readLine().split(" ");
		for(int i=1;i<=num_switch;i++) {
			if(state_string[i-1].equals("0")) {
				state[i] = false;
			} else {
				state[i] = true;
			}
		}

		int num_student = Integer.parseInt(br.readLine());
		int sexs[] = new int[num_student];
		int nums[] = new int[num_student];
		
		for(int i=0; i<num_student; i++) {
			state_string = br.readLine().split(" ");
			sexs[i] = Integer.parseInt(state_string[0]);
			nums[i] = Integer.parseInt(state_string[1]);
			
		}
		
		for(int i = 0; i < num_student; i++) {
			if(sexs[i] == 1) { // 남자
				for(int j = 1; nums[i] * j <= num_switch ; j++) {
					state[nums[i]*j] = !state[nums[i]*j];
				}
			}
			else { // 여자
				state[nums[i]] = !state[nums[i]];
				int idx = 1;
				while(nums[i]-idx >= 1 && nums[i] + idx <= num_switch) {
					if(state[nums[i]-idx] == state[nums[i] + idx]) {
						state[nums[i]-idx] = !state[nums[i]-idx];
						state[nums[i] + idx] = ! state[nums[i] + idx];
						idx++;
					} else {
						break;
					}
				}
			}
		}
		
		for(int i=1;i<=num_switch;i++) {
			if(state[i] == true) {
				sb.append("1 ");
			}
			else {
				sb.append("0 ");
			}
			if(i % 20 == 0) {
				sb.append('\n');
			}
		}
		System.out.print(sb.toString());
	}
    
}