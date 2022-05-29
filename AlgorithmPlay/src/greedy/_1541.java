package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//뺄셈을 먼저 계산하자
public class _1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, "-");
		int result = Integer.MAX_VALUE;
		while(st.hasMoreTokens()) {
			String val = st.nextToken();
			
			StringTokenizer st2 = new StringTokenizer(val, "+");
			
			int temp = 0;
			while(st2.hasMoreTokens()) {
				temp += Integer.parseInt(st2.nextToken());
			}
			
			if(result == Integer.MAX_VALUE) { //첫번째값임
				result = temp;
			}else {
				result -= temp;
			}
		}
		System.out.println(result);
	}
}
