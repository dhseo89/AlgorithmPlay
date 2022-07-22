package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://reakwon.tistory.com/38
public class MergeSort {

	static int arr[];
	static int N;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] =  Integer.parseInt(st.nextToken());
		}
		mergeSort(0, N-1);
	}
	
	//merge 구현
	static void merge(int start, int end) {
		//left와 right 포인터 세팅
		int mid = (start + end) / 2;
		
		//왼쪽 절반의 시작 포인터 = 시작과 같음
		int left = start;
		//오른쪽 절반의 시작 포인터
		int right = mid+1;
		
		//temp 세팅 -> 임시로 start-end 구간을 보면서 정렬된 값들을 저장할 배열
		int[] temp = new int[N];
		
		//temp에서 기록과 arr(원본의) 위치를 저장하고 있을  index 값
		int index = start;
		
		//left와 right포인터 이동하면서 정렬 -> temp에 저장
		while(left <= mid && right <= end) {
			//left와 right포인터가 가리키는 요소를 비교
			if(arr[left] < arr[right]) {
				//left가 기리키는 요소가 더 작으면 -> left의 값을 temp에 넣고
				//index와 left 포인터를 하나씩 우측으로 이동
				temp[index++] = arr[left++];
			}
			else {
				temp[index++] = arr[right++];
			}
		}
		
		//left 또는 right 포인터가 끝까지 이동
		// -> 요소가 남은 배열에서 남은 모든 요소 temp에 투입
		// left가 가리키는 배열(A)이 먼저 끝났다면
		if(left > mid) {
			//right에 남아있는 요소들을 모두 temp에 투입
			for(int i = right; i <= end; i++) {
				temp[index++] = arr[i];
			}
		}
		else {
			for(int i = left; i <= mid; i++) {
				temp[index++] = arr[i];
			}
		}
		
		//원본 덮어씌우기
		for(int i = start; i <= end; i++) {
			arr[i] = temp[i];
		}
	}
	
	//start~end 구간을 정렬
	static void mergeSort(int start, int end) {
		
		//종료조건? 단일노드까지 갔으면 종료
		if(start >= end)
			return;
		
		//재귀 구성
		int mid = (start + end) / 2;
		
		//왼쪽 절반 정렬 -> 분할
		//mid 포함!
		mergeSort(start, mid);
		
		//오른족 절반 정렬 -> 분할
		mergeSort(mid+1, end);
		
		//정복 start~end 구간을 정렬하면서 합치면서 올라감
		merge(start, end);
		
		//start ~ end 구간이 정렬이 끝나면 -> 해당 구간의 정려된 요소 출력
		printArr(start, end);
	}

	private static void printArr(int start, int end) {
		for (int i = start; i <= end; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
