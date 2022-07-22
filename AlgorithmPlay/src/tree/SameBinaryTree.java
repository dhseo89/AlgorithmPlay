package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//트리 구성 ->  PBT ->  몇개노드가 있는가? 2^(H+1) -1
public class SameBinaryTree {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int H,N,sum;
	static int tree[];
	public static void main(String[] args) throws IOException {
		H = Integer.parseInt(br.readLine());
		
		//노드개수 구하기
		N = (int) (Math.pow(2, H+1)) - 1;
		st = new StringTokenizer(br.readLine());
		tree = new int[N+1];
		for (int i = 2; i <= N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
//		for (int i = 1; i <= N; i++) {
//			System.out.print(tree[i]+" ");	
//		}
		
		calculate(1);
		System.out.println(sum);
	}
	private static int calculate(int start) {
		
		sum += tree[start];
		//종료조건
		if(start*2 > N) {
			return tree[start];
		}
		//재귀조건
		int left = calculate(start*2);
		int right = calculate(start*2 +1);
		
		//left와 right 비교 하기
		int diff = Math.abs(left - right);
		sum += diff;
		
		//left와 right가 어떤 값으로 통일 했는지 -> 상위 노드에 알려주고 계속 반복하여  root까지 올라가기
		//아래에서 통일하기로 한 값 -> left, right 중 큰값
		return tree[start]+ Math.max(left,  right);
	}
}
