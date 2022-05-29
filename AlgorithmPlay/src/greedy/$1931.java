package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//
//그리디 알고리즘 대표적인 문제
//배열 정렬
//https://st-lab.tistory.com/145
//https://gre-eny.tistory.com/2
public class $1931 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] A = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			A[i][0] = Integer.parseInt(st.nextToken());
			A[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}else {
					return o1[1] - o2[1];
				}
			}
		});
		int cnt = 1;
		int sTime = A[0][1]; //처음 종료시간
		for(int i = 0; i < N-1; i++) {
			if(A[i+1][0] >= sTime) {
				//System.out.println(A[i+1][0]+" "+A[i+1][1]);
				cnt++;
				sTime = A[i+1][1];
			}
		}
		System.out.println(cnt);
	}
}
