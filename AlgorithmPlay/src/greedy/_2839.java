package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 2839
//6일때 3으로 2봉지 가져가야된다는 점을 확인
public class _2839 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int cnt = 0;
		int N = Integer.parseInt(st.nextToken());
		while (true) {
			if (N % 5 == 0) {
				cnt = (N / 5) + cnt;
				break;
			} else {
				N = N - 3;
				cnt++;
			}
			if (N < 0) {
				cnt = -1;
				break;
			}
		}
		System.out.println(cnt);
	}
}
