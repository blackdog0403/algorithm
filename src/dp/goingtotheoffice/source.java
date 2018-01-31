package dp.goingtotheoffice;

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

		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] M = new int[H + 2][W + 2];
		int[][] D = new int[1212][1212];

		for (int i = 1; i <= H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= W; j++) {
				M[i][j] = Integer.parseInt(st.nextToken());
				// 초기 매트릭스
			}
		}
		D[1][1] = N - 1; // n-1번 출근했을 떼의 D 배열[i][j]를 지나간 횟수

		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= W; j++) {
				if (i == 1 && j == 1)
					continue;
				//위쪽에서 왓으면 아래쪽에는 나머지도 더해주고
				if (M[i - 1][j] == 0) { 
					D[i][j] += D[i-1][j] /2 + D[i-1][j] % 2;
				} else { 
					D[i][j] += D[i-1][j] /2 ;
				}
				
				if (M[i][j-1] == 1) {
					D[i][j] += D[i][j-1] /2 + D[i][j-1] % 2;
				} else {
					D[i][j] += D[i][j-1] /2;
				}
			}
		}
		
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= W; j++) {
				if(D[i][j]%2==1) {
					if(M[i][j]==1) M[i][j]=0;  
					else M[i][j]=1;
				}
			}
		} 
		
		int nowx =1;
		int nowy =1;
		while (nowx <=H && nowy <=W) {
			if(M[nowx][nowy]==0) nowx++;
			else nowy++;
		}
		wr.write(String.valueOf(nowx + " " +nowy));
		br.close();
		wr.flush();
		wr.close();

	}
}
