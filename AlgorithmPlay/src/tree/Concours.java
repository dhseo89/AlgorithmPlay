package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
6
1 1
1 3
1 43
1 7
2 1
1 10
 */
/*
1위
2위
3위
3위
3명
3위
 */



/*
18
1 15
1 14
1 13
1 12
1 11
2 11
1 11
1 1
1 2
1 3
1 20
2 1
2 2
2 3
1 21
1 1
1 2
1 3
 */

/*
1위
1위
1위
1위
1위
4명
1위
1위
2위
3위
9위
8명
7명
6명
7위
1위
2위
3위
 */
public class Concours {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,cnt;
	static int T = 1000000;
	static int[] tree = new int[T*4];
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if(command == 1) {
				//대회참가 -> update 1로 업데이트
				update(1, T, 1, num, 1);
				
				//순위 출력
				int rank = query(1, T, 1, 1, num);//업데이트하고 쿼리 하면 -1 필요없음
				System.out.println(rank+"위");
				//한명이 대회에 더 참가한다
				cnt++;
			}
			if(command == 2) {
				//대회 참가취소 -> update 0로 업데이트
				update(1, T, 1, num, 0);
				
				//참가취소
				cnt--;
				System.out.println(cnt+ "명");
			}
		}
	}
	
	public static int update(int start, int end, int node, int idx, int val) {
		//종료조건
		if(start > idx || end < idx)
			return tree[node];
		
		if(start == end)
			return tree[node] = val;
		
		//재귀조건
		int mid = (start + end) / 2;
		int left = update(start, mid, node*2, idx, val);
		int right = update(mid+1, end, node*2+1, idx, val);
		return tree[node] = left+right;
		
	}
	
	public static int query(int start, int end, int node, int left, int right) {
		//종료조건
		if(left > end || right < start)
			return 0;
		if(left <= start && right >= end)
			return tree[node];
		
		//재귀조건		
		int mid = (start+end) /2;
		int lefVal = query(start, mid, node*2, left, right);
		int rightVal = query(mid+1, end, node*2+1, left, right);
		return lefVal+ rightVal;
	}
}
