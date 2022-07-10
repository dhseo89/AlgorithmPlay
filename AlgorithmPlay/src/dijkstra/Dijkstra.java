package dijkstra;

public class Dijkstra {

	static int number = 6;
	static int MIN = 300000;
	
	static int[][] a = {
		{0, 4, 5, 2, 1, MIN},
		{4, 0, 1, 2, MIN, MIN},
		{5, 1, 0, 3, 1, 5},
		{2, 2, 3, 0, 1, MIN},
		{1, MIN, 1, 1, 0, 2},
		{MIN, MIN, 5, MIN, 2, 0}
	};
	
	static boolean v[] = new boolean[6];
	static int d[] = new int[6];
	
	
	public static void main(String[] args) {
		dijkstra(0);
		print();
	}
	
	static int getSmallIndex() {
		int min = MIN;
		int index = 0;
		for (int i = 0; i < number; i++) {
			if(d[i] < min && !v[i]) {
				min = d[i];
				index = i;
			}
		}
		return index;
	}	
	
	static void dijkstra(int start) {
		for (int i = 0; i < number; i++) {
			d[i] = a[start][i];
		}
		
		v[start] = true;
		for (int i = 0; i < number; i++) {
			int current = getSmallIndex();
			v[current] = true;
			for (int j = 0; j < 6; j++) {
				if(!v[j]) {
					if(d[current] + a[current][j] < d[j]) {
						d[j] = d[current] + a[current][j];
					}
				}
			}
		}
		//System.out.println("end");		
	}	
	
	static void print() {
		for (int i = 0; i < number; i++) {
			System.out.println(d[i]);
		}
	}
}
