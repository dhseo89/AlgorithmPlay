package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
4
1 5 8 9
 */
public class RodCutting {
    
    private static int N;
    private static BufferedReader br;
    private static StringTokenizer st;
    
    private static int [] partPrice;
    private static int [] maxPricePerLength;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        partPrice = new int [N+1];
        maxPricePerLength = new int [N+1];
        
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            partPrice[i] = Integer.parseInt(st.nextToken());
        }
        
        br.close();
        
        for (int i = 1; i <= N; i++) {
            int max = 0;
            for (int j = 1; j <= i; j++) {
                max = Math.max(max, partPrice[j] + maxPricePerLength[i-j]);
            }
            maxPricePerLength[i] = max;
        }
        
        System.out.println(maxPricePerLength[N]);
    }
 
}
