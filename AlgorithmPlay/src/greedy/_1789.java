package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1789 {
	//등차 수열의 합 n(s+l)/2 
	//n 갯수, s 시작항, l 마지막항
	//integer 최대범위 21억
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Long S = Long.parseLong(br.readLine());
		Long N = 1L;
		Long max = 0L;
		while(true) {
			max += N;
			if(max > S) {
				N -= 1;
				break;
			}
			N += 1;
		}
		System.out.println(N);
	}
}
