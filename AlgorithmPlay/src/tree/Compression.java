package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
8
00000000
00000000
00001111
00001111
00011111
00111111
00111111
00111111
 */
public class Compression {

	static int N;
	static int arr[][];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		search(0,0,N);
	}
	
	static boolean isCompressed(int pixel, int x, int y, int size) {
		for (int i = x; i < x+size; i++) {
			for (int j = y; j < y+size; j++) {
				if(arr[i][j] != pixel)
					return false;
			}
		}
		return true;
	}
	private static void search(int x, int y, int size) {
		
		// 기준 위치
		int cur = arr[x][y];
		//단일 노드로 구성되어있는가? (size X size 구간)
		if(isCompressed(cur, x, y , size)) {
			//기준 픽셀 출력
			System.out.print(cur);
		}
		else {
			//분할 + 정복
			//분할 들어갈때 괄호
			System.out.print("(");
			
			//다음 구간(분할정복된 부분)의 크기
			int half = size / 2;
			
			//왼쪽 위
			search(x, y, half);
			
			//오른쪽 위
			search(x, y + half, half);
			
			//왼쪽 아래
			search(x + half, y, half);
			
			//오른쪽 아래
			search(x + half, y + half, half);
			
			//정복하고 나올때 괄호
			System.out.print(")");
		}
	}
}
