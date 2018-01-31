package adhoc.cave;

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

		int n = Integer.parseInt(st.nextToken());
		int N = n / 2;
		int now =0;
		int[] S = new int[N];
		int[] J = new int[N];
		int[] SH = new int[515151];
		int[] JH = new int[515151];
		
		int H = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			S[i] = Integer.parseInt(br.readLine());
			J[i] = Integer.parseInt(br.readLine());
			J[i] = H - J[i]; // 종유석은 위쪽에 있으므로 계산하기 편하도록 주어진 높이 - 종유석의 길이로 계산한다.
		}
		
		Arrays.sort(S);
		Arrays.sort(J);
		
		now = 0;
		
		for (int i = 1; i <=H; i++) {
			while (now<N&& S[now] < i) now++;
			SH[i] = N - now; // 석순은 높이가i일때 여기뒤로는 다 부딧힘
		}
		
		now = 0;

		for (int i = 1; i <=H; i++) {
			while (now<N&& J[now] < i) now++;
			JH[i] = now; // 종유석은 높이가 i일때 여기까지는 부딪힘
		}
		
		int ans = -1;
		int cnt = 0;
		
		for (int i = 1; i <= H; i++) {
			if (ans == -1 || SH[i]+JH[i] < ans ) ans = JH[i] + SH[i]; 
		}
		
		for (int i = 1; i <=H ; i++) {
			if(ans == JH[i]+SH[i]) cnt++;
		}
		
		wr.write(String.valueOf(ans+ " " + cnt));
		br.close();
		wr.flush();
		wr.close();
	}

}
