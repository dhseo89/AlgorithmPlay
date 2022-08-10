package dfs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class $15686 {

	static int N,M;
	static int map[][];
	static int[] pickStore;
	static ArrayList<Store> home = new ArrayList<>();
	static ArrayList<Store> store = new ArrayList<>();
	static int result=Integer.MAX_VALUE;;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		pickStore = new int[M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) home.add(new Store(i,j));
				if(map[i][j] == 2) store.add(new Store(i,j));
			}
		}
		
		dfs(0,0);
		System.out.println(result);
	}
	
	//백미네 이부분
	private static void dfs(int start, int cnt) {
		if(cnt == M) {
			calGo();
			return;
		}
		
		for (int i = start; i < store.size(); i++) {
			pickStore[cnt] = i;
			dfs(i+1, cnt+1);
		}
	}
	private static void calGo() {
		
		int tempSum = 0;
		for (int i = 0; i < home.size(); i++) {
			Store h = home.get(i);
			int temp = Integer.MAX_VALUE;
			for (int j = 0; j < pickStore.length; j++) {
				Store s = store.get(pickStore[j]);
				temp = Math.min(Math.abs(h.x - s.x) + Math.abs(h.y - s.y), temp);
			}
			tempSum += temp;
		}
		
		result = Math.min(tempSum, result);
	}
}

class Store {
	int x;
	int y;
	
	Store(int x, int y){
		this.x = x;
		this.y = y;
	}
}
