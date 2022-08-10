package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


//https://kloong.tistory.com/entry/%EB%B0%B1%EC%A4%80-%EA%B3%B5%EC%9E%A5-7578-Java
public class $7578 {

	static int N;
	static int Max = 1000000;
	static Pair[] list;
	static HashMap<Integer,Integer> map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new Pair[N+1];
		map = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int start = Integer.parseInt(st.nextToken());
			map.put(start, i);
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int end = Integer.parseInt(st.nextToken());
			int startIdx = map.get(end);
			list[i] = new Pair(startIdx, i, end);
		}
		//구간이 2개이상 겹쳐야지 교차한다
		
	}
}

class Pair {
	int start;
	int end;
	int val;
	
	Pair(int start, int end, int val){
		this.start = start;
		this.end = end;
		this.val = val;
	}
}