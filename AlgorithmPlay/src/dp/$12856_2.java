package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

//Top-Down
//https://kang-james.tistory.com/entry/%EB%B0%B1%EC%A4%80-12865-Java-%ED%8F%89%EB%B2%94%ED%95%9C-%EB%B0%B0%EB%82%AD-DP
public class $12856_2 {

	static Integer[][] dp;
	static int[] W; // weight
	static int[] V; // value
	static int N, K;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		W = new int[N+1];
		V = new int[N+1];

		dp = new Integer[N+1][K + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(knapsack(N, K));

	}

	static int knapsack(int i, int k) {
		// i가 0미만, 즉 범위 밖이 된다면
		if (i == 0) {
			System.out.println("0 -> " + i + "  " + k);
			return 0;
		}

		// 탐색하지 않은 위치라면?
		if (dp[i][k] == null) {
			System.out.println("dp[i][k] == null -> " + i + "  " + k);
			for (int j = 0; j < N+1; j++) {
				for (int j2 = 0; j2 < K + 1; j2++) {
					System.out.print(dp[j][j2]+" ");
				}
				System.out.println();
			}
			// 현재 물건(i)을 추가로 못담는 경우 (이전 i값 탐색)
			if (W[i] > k) {
				System.out.println("if go...");
				dp[i][k] = knapsack(i - 1, k);
				for (int j = 0; j < N+1; j++) {
					for (int j2 = 0; j2 < K + 1; j2++) {
						System.out.print(dp[j][j2]+" ");
					}
					System.out.println();
				}
			}
			// 현재 물건(i)을 담을 수 있는 경우
			else {
				System.out.println("else go...");
				// 이전 i값과 이전 i값에 대한 k-W[i]의 값 + 현재 가치(V[i])중 큰 값을 저장
				int horizen = knapsack(i - 1, k);
				System.out.println("horizen.... "+ horizen);
				int diagonal = knapsack(i - 1, k - W[i]) + V[i];
				System.out.println("diagonal.... "+diagonal);
				dp[i][k] = Math.max(horizen, diagonal);
				System.out.println("else -> "+ i+"  "+k);
				for (int j = 0; j < N+1; j++) {
					for (int j2 = 0; j2 < K + 1; j2++) {
						System.out.print(dp[j][j2]+" ");
					}
					System.out.println();
				}
			}
		}
		return dp[i][k];
	}
}
