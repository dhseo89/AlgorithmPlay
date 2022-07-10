package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class $1504 {
	//https://steady-coding.tistory.com/82
	//1번 정점에서 N번까지
	//1 -> v1 -> v2 -> N (1->v1, v1->v2, v2->N)
	//1 -> v2 -> v1 -> N (1->v2, v2->v1, v1->N)
	//**정점과 가중치를 계산하여 최대값 사용
	static int N,M,A,B;
	static int ans1,ans2,ans;
	static ArrayList<Info>[] list;
	static int[] dist;
	static boolean visited[];
	static int INF = 200000 * 1000; //이해가 잘안가는 부분...
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		dist = new int[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[start].add(new Info(end, cost));
			list[end].add(new Info(start, cost));
		}
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		ans = 0;
		ans1 = 0;
		ans2 = 0;
		ans1 += dijkstra(1,A);
		ans1 += dijkstra(A,B);
		ans1 += dijkstra(B,N);
		
		ans2 += dijkstra(1,B);
		ans2 += dijkstra(B,A);
		ans2 += dijkstra(A,N);
		ans = Math.min(ans1, ans2);
		
		System.out.println(ans >= INF ? -1 : ans);
	}
	private static int dijkstra(int s, int e) {
		PriorityQueue<Info> pq = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		visited = new boolean[N+1];
		pq.add(new Info(s, 0));
		dist[s] = 0;
		
		while(!pq.isEmpty()) {
			Info now = pq.poll();
			if(visited[now.no]) continue;
			visited[now.no] = true;
			for (int i = 0; i < list[now.no].size(); i++) {
				Info next = list[now.no].get(i);
				if(dist[next.no] > dist[now.no] + next.cost) {
					dist[next.no] = dist[now.no] + next.cost;
					pq.add(new Info(next.no, dist[next.no]));
				}
			}
		}
		return dist[e];
	}
}

class Info implements Comparable<Info> {
	int no;
	int cost;
	
	Info(int no, int cost) {
		this.no = no;
		this.cost = cost;
	}
	
	public int compareTo(Info i) {
		return cost - i.cost;
	}
}

