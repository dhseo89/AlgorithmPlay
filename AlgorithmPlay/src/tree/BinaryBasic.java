package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinaryBasic {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] arr = {1,2,3,4,5,6,7,8,9,10};
	public static void main(String[] args) {
		//bsearch(시작, 끝, 찾고자하는 값(
		//재귀 -> while이 아니고 계속 같은 함수로 들어가니까
		System.out.println(bsearch(0,10,3));
	}
	private static int bsearch(int start, int end, int num) {
		
		//2. 기저조건 -> 만약 start와 end구간이 겹치면(만나면) -->  못찾았다!
		if(start >= end)
			//못찾았다!
			return -1;
		
		//1. 재귀구성
		//binary search: 1. 정렬(필수) 2. mid를 활용해서 체크
		int mid = (start + end) /2;
		
		//왼쪽으로 쪼개지거나
		//만약 중간값이 내가 찾으려고 하는값보다 크면
		if(arr[mid] > num)
			//더 작은 영역으로 쪼갠다
			return bsearch(start, mid-1, num);
		
		//오른쪽으로 쪼개지거나
		//중간값이 내가 찾으려고하는 값보다 작으면
		else if(arr[mid] < num)
			return bsearch(mid+1, end, num);
		
		//찾았다!
		else {
			return mid;
		}
	}
}
