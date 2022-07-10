package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class $$9370 {

	// https://gre-eny.tistory.com/76
	//https://dragon-h.tistory.com/22
	static int T, N, M, D, S, G, H;
	static int[] dist;
	static boolean visited[];
	static ArrayList<Node9370> list[];
	static int dest[];
	static int INF = 10000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int test = 0; test < T; test++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken()); // 후보지 개수
			dest = new int[D];
			list = new ArrayList[N + 1];
			dist = new int[N+1];
	
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			G = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			for (int i = 1; i <= N; i++) {
				list[i] = new ArrayList<>();
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				if(start == G && end == H || start == H && end == G) {
					cost = cost*2-1; //홀수
				}
				else {
					cost = cost*2; //짝수
				}
				list[start].add(new Node9370(end, cost));
				list[end].add(new Node9370(start, cost));
			}
			for (int i = 0; i < D; i++) {
				dest[i] = Integer.parseInt(br.readLine());
			}
			
			PriorityQueue<Integer> q = new PriorityQueue<>();
			for (int i = 0; i < D; i++) {
				int ans = 0;
				ans = dijkstra(S, dest[i]);
				if(ans % 2 == 1) {
					q.add(dest[i]);
				}
			}
			while(!q.isEmpty()) {
				System.out.print(q.poll()+" ");
			}
			System.out.println();
		}
	}

	private static int dijkstra(int s, int e) {
		PriorityQueue<Node9370> pq = new PriorityQueue<Node9370>();
		visited = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			dist[i] = INF;//Integer.MAX_VALUE;
		}
		dist[s] = 0; 
		pq.add(new Node9370(s, 0));
		
		while(!pq.isEmpty()) {
			Node9370 now = pq.poll();
			if(visited[now.no]) continue;
			visited[now.no] = true;
			for (int i = 0; i < list[now.no].size(); i++) {
				Node9370 next = list[now.no].get(i);
				if(dist[next.no] > dist[now.no] + next.cost) {
					dist[next.no] = dist[now.no] + next.cost;
					pq.add(new Node9370(next.no, dist[next.no]));
				}
			}
		}
		return dist[e];
	}
}

class Node9370 implements Comparable<Node9370> {
	int no;
	int cost;

	Node9370(int no, int cost) {
		this.no = no;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node9370 n) {
		return cost - n.cost;
	}
}
