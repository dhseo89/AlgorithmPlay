package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


//dfs, bfs 기본문제
public class _1260 {

	static int N,M,S;
	static int map[][];
	static boolean visited[][];
	static boolean checked[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		visited = new boolean[N+1][N+1];
		checked = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			map[start][end] = 1;
			map[end][start] = 1;
		}
		
		dfs(S);
		visited = new boolean[N+1][N+1];
		checked = new boolean[N+1];
		System.out.println();
		bfs(S);
	}
	private static void bfs(int s) {
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		checked[s] = true;
		System.out.print(s+" ");
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for (int i = 1; i <= N; i++) {
				if(map[now][i] == 1 && !visited[now][i] && !checked[i]) {
//					System.out.println(now+" "+i);
					q.add(i);
					checked[i] = true;
					visited[now][i] = true;
					System.out.print(i+" ");
				}
			}
		}
	}
	private static void dfs(int s) {
		System.out.print(s+" ");
		checked[s] = true;
		
		for (int i = 1; i <= N; i++) {
			if(map[s][i] == 1 && !visited[s][i] && !checked[i]) {
				dfs(i);
			}
		}
	}
}
