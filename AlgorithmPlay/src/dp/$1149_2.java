package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://mingyeongun-dev.tistory.com/30
//dp배열을 한번 더 두는 경우가 많음
//bottom-up
public class $1149_2 {

	static int N;
	static int[][] val;
	static int[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		val = new int[N][3];
		dp = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				val[i][j] = Integer.parseInt(st.nextToken());
				if(i == 0) {
					dp[i][j] = val[i][j];
				}
			}
		}
		for (int i = 1; i < N; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + val[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + val[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + val[i][2];
		}
		System.out.println(Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]));
		
	}
	private static void printTest(int[][] arr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
