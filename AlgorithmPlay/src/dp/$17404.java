package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class $17404 {

	static int val[][];
	static int dp[][];
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				val[i][j] =  Integer.parseInt(st.nextToken());
			}
		}
		dp[1][1] = val[1][1];
		dp[1][2] = val[1][2];
		dp[1][3] = val[1][3];
		dp();
	}
	private static void dp() {
		for (int i = 1; i <= N; i++) {
			if(i==1) {
				
			}
			else if(i==2) {
				
			}
			else if(i==3) {
				
			}
		}
	}
}
