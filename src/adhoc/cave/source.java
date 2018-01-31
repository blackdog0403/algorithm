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
			J[i] = H - J[i]; // �������� ���ʿ� �����Ƿ� ����ϱ� ���ϵ��� �־��� ���� - �������� ���̷� ����Ѵ�.
		}
		
		Arrays.sort(S);
		Arrays.sort(J);
		
		now = 0;
		
		for (int i = 1; i <=H; i++) {
			while (now<N&& S[now] < i) now++;
			SH[i] = N - now; // ������ ���̰�i�϶� ����ڷδ� �� �ε���
		}
		
		now = 0;

		for (int i = 1; i <=H; i++) {
			while (now<N&& J[now] < i) now++;
			JH[i] = now; // �������� ���̰� i�϶� ��������� �ε���
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
