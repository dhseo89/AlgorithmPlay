package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//dp배열을 한번 더 두는 경우가 많음
//top-down 재귀
public class $1149 {

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
		dp[0][0] = val[0][0];
		dp[0][1] = val[0][1];
		dp[0][2] = val[0][2];
		System.out.println(Math.min(Math.min(findColor(N-1,0),findColor(N-1,1)),findColor(N-1,2)));
		
	}
	private static int findColor(int N, int color) {
		if(dp[N][color] == 0) {
			if(color == 0) {
				dp[N][color] = Math.min(findColor(N-1, 1), findColor(N-1, 2)) + val[N][color];
			}
			else if(color == 1) {
				dp[N][color] =  Math.min(findColor(N-1, 0), findColor(N-1, 2)) + val[N][color];
			}
			else if(color == 2) {
				dp[N][color] =  Math.min(findColor(N-1, 0), findColor(N-1, 1)) + val[N][color];
			}
		}
		return dp[N][color];
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
