package dp.collectingwaste;

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
		
		int N = Integer.parseInt(st.nextToken()); // 도시의 크기
		 
		int[][] D = new int[N+1][N+1];
		int[][] P = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				P[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
	
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				D[i][j] = Math.max(D[i-1][j], D[i][j-1]) + P[i][j];
			}
		}
		
		wr.write(String.valueOf(D[N][N]));
		br.close();
		wr.flush();
		wr.close();
		
	}
}
