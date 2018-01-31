package dp.maxpartsum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class source {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine()); 
		int[] arr = new int[N+1];		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			arr[i]= Integer.parseInt(st.nextToken()); // 만들 숫자.
		}

		long[] D = new long[N+1];
		long ans = (long) -1e18;
	
		for (int i = 1; i <= N; i++) {
			D[i] = Math.max( (long) D[i-1] + arr[i] , arr[i]);
			ans = Math.max(ans, D[i]);
		}
		wr.write(String.valueOf(ans));
		br.close();
		wr.flush();
		wr.close();
		
	}
}