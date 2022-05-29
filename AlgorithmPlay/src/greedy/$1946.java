package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class $1946 {
	//https://zzang9ha.tistory.com/51
	//문제를 이해하는게 어려웠음...
	public static void main(String args[]) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int j = 0; j < T; j++) {
			int N = Integer.parseInt(br.readLine());
			int grade[][] = new int[N][2];
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				grade[i][0] = Integer.parseInt(st.nextToken());
				grade[i][1] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(grade, new Comparator<int[]>(){
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}
			});
			//for문 안에 while문을 가지고 비교하면 시간초과가 난다.
			int cnt = 1;
			int start = grade[0][1];
			//통과된 것중에 최소값을 갖고 있다가 비교한다
			for(int k = 1; k < N; k++) {
				if(start < grade[k][1]) continue;
				cnt++;
				//start = Math.min(start, grade[k][1]);  굳이 최소값을 따질필요가 없음 -> 다음 면접자는 무조건 높아야함 서류에서 밀렸기때문에
				start = grade[k][1];
			}
			System.out.println(cnt);
		}
	}
}
