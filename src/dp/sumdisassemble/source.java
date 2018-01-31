package dp.sumdisassemble;

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
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 만들 숫자.
		int K = Integer.parseInt(st.nextToken()); // 사용할 숫자의 갯수 
		int[][] D = new int[K+1][N+1];
		D[0][0] = 1;
		
		for (int i = 1; i <= K; i++) {
			D[i][0]=D[i-1][0];
			for (int j = 1; j <= N; j++) {
				D[i][j] = (D[i-1][j] + D[i][j-1]) % (int)(1e9);
			}
		}
		
		wr.write(String.valueOf(D[K][N]));
		br.close();
		wr.flush();
		wr.close();
		
	}
}
