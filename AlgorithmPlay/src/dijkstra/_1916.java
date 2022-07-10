package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//다익스트라
//출발점이 중요
//거리값 배열 필요
//비교하여 업데이트
public class _1916 {

	static int N,M;
	static ArrayList<Node2> list[];
	static int[] dist;
	static int ans = 0;
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		dist = new int[N+1];
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[start].add(new Node2(end, cost));
			
		}
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		dijkstart(s);
		System.out.println(dist[e]);
	}
	
	private static void dijkstart(int s) {
		PriorityQueue<Node2> pq = new PriorityQueue<>();
		pq.add(new Node2(s, 0));
		dist[s] = 0;
		
		while(!pq.isEmpty()) {
			Node2 now = pq.poll();
			if(visited[now.no]) continue;
			visited[now.no] = true;
			for (int i = 0; i < list[now.no].size(); i++) {
				Node2 next = list[now.no].get(i);
				int ncost = next.cost + dist[now.no];
				if(dist[next.no] > ncost) {
					dist[next.no] = ncost;
					pq.add(new Node2(next.no, ncost));
				}
			}
		}
	}
}

class Node2 implements Comparable<Node2>{
	int no;
	int cost;
	
	Node2(int no, int cost){
		this.no = no;
		this.cost = cost;
	}
	@Override
	public int compareTo(Node2 n) {
		return cost - n.cost;
	}
}
