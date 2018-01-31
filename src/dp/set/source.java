package dp.set;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class source {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 만들 숫자.
		int M = Integer.parseInt(st.nextToken()); // 사용할 숫자의 갯수

		int[][] D = new int[1010][1010];
		int[][] MD = new int[1010][1010];
		
	
		int[] a;
		int[] b;
		// 항상 작은 배열을 앞에 두고 비교를 하기 위하여!
		if (N < M) {
			a = new int[N];
			b = new int[M];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}
		} else {
			a = new int[M];
			b = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			int temp;
			temp = N;
			N = M;
			M = temp;
		}

		Arrays.sort(a);
		Arrays.sort(b);

		// D[i][j] = MD[i-1][j-1]
		// 직전까지의 최소값을 D 배열에 담아뒀다가 MD배열에서 활용한다.

		
		D[0][0] = Math.abs(a[0] - b[0]);
		
		MD[0][0] = D[0][0];

		for (int i = 1; i < M; i++) {
			D[0][i] = Math.abs(a[0] - b[i]);
			MD[0][i] = Math.min(D[0][i], MD[0][i-1]);
		}

		for (int i = 1; i < N; i++) {
			D[i][i] = MD[i-1][i-1] + Math.abs(a[i]-b[i]);
			MD[i][i] = D[i][i];
			for (int j = i+1 ; j < M; j++) {
				D[i][j] = MD[i-1][j-1] + Math.abs(a[i]-b[j]);
				MD[i][j] = Math.min(MD[i][j-1], D[i][j]);
			}
		}
		wr.write(String.valueOf(MD[N-1][M-1]));
		
		br.close();
		wr.flush();
		wr.close();
	}

}
