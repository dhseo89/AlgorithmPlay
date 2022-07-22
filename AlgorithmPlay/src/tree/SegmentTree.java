package tree;

//어떤 구간에 대한 정보를 기록하고있는 트리
//init 안쓰이는 경우 많음
//* query A~B 구간의   query 처리 -> 겹치는 구간: 계속 내려가봄, 포함되는구간: 그 구간의 기록된 값을   return,  완전히 벗어난 구간: 정답에 영향을 주지않는 값 return
//* update 어떤 값이 바뀌었을때 segmentTee 변경
//세그먼트 트리는 CBT+FBT
//MAX,MIN,SUM TREE 존재

//층수 = Math.cell(log2 leaf)

//tree node 개수 세팅 => leaf node의 개수 X4
//트리는 1번부터 쓰는게 좋음
//start와 end를 이용하여 종료조건을 만드는 경우가 대다수임
public class SegmentTree {

	static int[] arr = {0, 1, 3, 5, 7, 9, 2, 4,6,8,10};
	static int[] tree;
	public static void main(String[] args) {
		//tree init
		int n = 10;
		
		//배열 요소를 입력받아야한다면 -> tree의 leaf node의 순서와 동일하게 쓸 수 있도록 1번부터 입력받자
		//for(int i=1; i<=n....)
		
		//leaf X 4
		tree = new int[n * 4];
		
		//init(배열요소의 시작, 끝(포함), 트리의 노드번호)
		init(1, n, 1);
		
		for (int i = 1; i < n*4; i++) {
			System.out.println(i+": "+ tree[i]);
		}
		
		//배열 요소의 시작, 배열 요소의 끝, 트리의 노드 번호, query의 시작, query의 끝
		int ans = query(1, n, 1, 3, 6);
		System.out.println(ans);
		
		ans = update(1, n, 1, 7, 100);
		System.out.println(ans);

	}
	
	//O(NlogN)
	static int init(int start, int end, int node) {
		
		//종료조건-> 단일 노드가 되면 leaf node
		if(start == end) 
			//지금 node의 위치에 배열에서의 값 저장
			return tree[node] = arr[start]; //arr[end]; //노상관
		
		//재귀구성 --> 분할 정복 -> 왼쪽, 오른쪽
		int mid = (start + end) / 2;
		//배열이 절반이 되면서 트리 번호는 X2
		int leftVal = init(start, mid, node*2);
		int rightVal = init(mid+1, end, node*2+1);
		
		//지금 내 노드 = 아래 두개의 노드중 더 큰값 저장 (MAX TREE)
		return tree[node] = Math.max(leftVal, rightVal);
	}
	
	//O(logN)
	static int query(int start, int end, int node, int left, int right) {
		//return 조건
		
		//1. 구간을 완전히 벗어난다
		if(left > end || right < start)
			//정답에 영향을 주지않는 값을 return
			//** 주의: 상황에 따라서 어떤값이 영향을 안주는가?
			return Integer.MIN_VALUE;
		
		//2. 포함되는 구간이다
		if(left <= start && right >= end)
			return tree[node];
		
		//3. 겹치는 구간이다 -> 분할 정복
		int mid = (start+end) /2;
		int leftVal = query(start, mid, node*2, left, right);
		int rightVal = query(mid+1, end, node*2+1, left, right);
		//**주의: query에서는  tree 기록 X
		return Math.max(leftVal, rightVal);
	}
	
	//idx 배열에서 고치려고하는 인덱스
	//val 교체될 값
	static int update(int start, int end, int node, int idx, int val) {
		
		//종료 조건
		if(idx < start || idx > end)
			return tree[node];
		
		//leaf node까지 도달했다면 -> 갱신
		// idx == start && idx == end
		if(start == end)
			//만약 원본도 수정하겠다고하면 
			//arr[start] = val;
			return tree[node] = val;
		
		//재귀구성
		int mid = (start+end) / 2;
		int leftVal = update(start, mid, node*2, idx, val);
		int rightVal = update(mid+1, end, node*2+1, idx, val);
		return tree[node] = Math.max(leftVal, rightVal);
	}
}
