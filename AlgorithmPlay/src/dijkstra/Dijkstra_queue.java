package dijkstra;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;


class Node implements Comparable<Node>{
	int end, weight;
	
	public Node(int end, int weight){
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		return weight - o.weight;
	}
}

// 성능문제를 해결하기 위해 우선큐를 사용한다
public class Dijkstra_queue {

	static int N,M,start;
	static final int INF = 300000;
	static List<Node>[] list;
	static int[] dist;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		start = sc.nextInt();
		list = new ArrayList[N+1];
		dist = new int[N+1];
		
		Arrays.fill(dist, INF);
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();
			list[a].add(new Node(b, w));
		}
		
		StringBuilder sb = new StringBuilder();
		dijsktra(start);
		
		for (int i = 1; i <=N; i++) {
			if(dist[i] == INF) sb.append("INF\n");
			else sb.append(dist[i] + "\n");
		}
		System.out.println(sb.toString());
	}

	private static void dijsktra(int s) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		boolean[] check = new boolean[N+1];
		queue.add(new Node(s, 0));
		dist[start] = 0;
		
		while(!queue.isEmpty()) {
			Node curNode = queue.poll();
			int cur = curNode.end;
			
			if(check[cur] == true) continue;
			check[cur] = true;
			
			for (Node node : list[cur]) {
				if(dist[node.end] > dist[cur] + node.weight) {
					dist[node.end] = dist[cur] + node.weight;
					queue.add(new Node(node.end, dist[node.end]));
				}
			}
		}
	}
}
