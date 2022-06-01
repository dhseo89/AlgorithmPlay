package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://cwangg897.tistory.com/102
//2^n을 찾아내는것과 최소값 찾아내기
public class $1052 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		
		int n  = 0;
		while(true) {
			int cnt = 0;
			int num = N;
			while(num != 0) {
				if(num % 2 == 1) {
					cnt++;
				}
				num = num/2;
			}
			if(cnt <= K) {
				break;
			} else {
				N += 1;
				n += 1;
			}
		}
		System.out.println(n);
	}
}
