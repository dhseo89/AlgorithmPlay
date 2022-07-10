package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _18352 {
	
	static int N,M,K,X;
	static ArrayList<Node18352> list[];
	static boolean visited[];
	static int dist[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()); //목표거리
		X = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list[start].add(new Node18352(end, 1));
		}
		
		dijkstra(X);
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			if(dist[i] == K) {
				q.add(i);
			}
		}
		if(q.size() == 0) {
			System.out.println(-1);
		}
		else {
			while(!q.isEmpty()) {
				System.out.println(q.poll());
			}
		}
	}
	private static void dijkstra(int s) {
		PriorityQueue<Node18352> pq = new PriorityQueue<>();
		visited = new boolean[N+1];
		dist = new int[N+1];
		for (int i = 0; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		pq.add(new Node18352(s, 0));
		dist[s] = 0;
		
		while(!pq.isEmpty()) {
			Node18352 now = pq.poll();
			if(now.cost == K) continue;
			if(visited[now.no]) continue;
			visited[now.no] = true;
			for (int i = 0; i < list[now.no].size(); i++) {
				Node18352 next = list[now.no].get(i);
				if(dist[next.no] > dist[now.no] + next.cost) {
					dist[next.no] = dist[now.no] + next.cost;
					pq.add(new Node18352(next.no, dist[next.no]));
				}
			}
		}
	}
}

class Node18352 implements Comparable<Node18352> {
	int no;
	int cost;
	
	Node18352(int no, int cost){
		this.no = no;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Node18352 n) {
		return cost - n.cost;
	}
}