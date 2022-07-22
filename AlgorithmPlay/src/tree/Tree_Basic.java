package tree;


//1. 한 노드 -> 다른 노드까지의 경로가 딱 1개임!
//2. 모든 노드는 단 하나만의 부모 노드를 가짐(root 제외)
//3. 사이클이 존재하지 않는다
// leaf노드 -> 자식이 존재하지 않음
// 이진트리 (binary Tree) -> 하나의 노드가 2개까지 자식을 가짐

//몇개의 노드가 필요한지 알아야 tree를 구현가능함
//root 1부터 시작
// left로 이동 -> n*2
// right로 이동 -> n*2+1 
public class Tree_Basic {

	//tree를 구성할때 0번을 제외하고 1번을 root로
	static int[] tree = {0, 1, 2, 3, 4, 5, 6, 7};
	public static void main(String[] args) {
		//root  노드부터 탐방
		dc(1);
	}
	private static void dc(int node) {
		
		//종료조건
		//끝까지 내려가면 return해서 올라와라
		if(node*2 > 7) {
			//아래 더 노드가 없으니까 return
			System.out.println("아래에 더 없음");
			return;
		}
		System.out.println(tree[node]+" ");
		System.out.println("LEFT : "+ tree[node*2]);
		System.out.println("RIGHT : "+ tree[node*2+1]);
		//재귀구성
		//왼쪽 노드 탐방
		dc(node * 2);
		
		//오른쪽 노드 탐방
		dc(node * 2 + 1);
	}
}
