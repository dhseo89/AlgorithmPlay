package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1439 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st1 = new StringTokenizer(str, "0"); //덩어리수, 연속된것 하나로
		StringTokenizer st2 = new StringTokenizer(str, "1");
		System.out.println(Math.min(st1.countTokens(), st2.countTokens()));
	}
}
