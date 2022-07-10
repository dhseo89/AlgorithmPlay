package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class $1238_my {

	static int N,M,P;
	static int[] dist;
	static int[] distP;
	static ArrayList<Edge> list[];
	static boolean visited[];
	static int ans = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[start].add(new Edge(end, cost));
		}
		
		
		distP = dijkstra(P, distP);
		for (int i = 1; i <= N; i++) {
			if(i == P) continue;
			dist = dijkstra(i, dist);
			if(distP[i] + dist[P] > ans) {
				ans = distP[i] + dist[P];
			}
		}
		System.out.println(ans);
	}
	private static int[] dijkstra(int s, int[] dist) {
		dist = new int[N+1];
		visited = new boolean[N+1];
		for (int j = 1; j <= N; j++) {
			dist[j] = Integer.MAX_VALUE;
		}
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(s, 0));
		dist[s] = 0;
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			if(visited[now.no]) continue;
			visited[now.no] = true;
			for (int i = 0; i < list[now.no].size(); i++) {
				Edge next = list[now.no].get(i);
				if(dist[next.no] > dist[now.no] + next.cost) {
					dist[next.no] = dist[now.no] + next.cost;
					pq.add(new Edge(next.no, dist[next.no]));
				}
			}
		}
		
		return dist;
	}
}

class Edge implements Comparable<Edge> {
	int no;
	int cost;
	
	Edge(int no, int cost){
		this.no = no;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Edge e) {
		return cost - e.cost;
	}
}
