package dp.assembly;

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

		int N = Integer.parseInt(st.nextToken());
		int e1 = Integer.parseInt(st.nextToken());
		int e2 = Integer.parseInt(st.nextToken());
		int x1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());

		int[] S1st = new int[N + 1];
		int[] S2nd = new int[N + 1];
		int[] T1 = new int[N];
		int[] T2 = new int[N];
		int[] D1 = new int[N + 1];
		int[] D2 = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());

		for (int i = 1; i < S1st.length; i++) {
			S1st[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i < S2nd.length; i++) {
			S2nd[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i < S1st.length - 1; i++) {
			T1[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < S2nd.length - 1; i++) {
			T2[i] = Integer.parseInt(st.nextToken());
		}
		D1[0] = 0;
		D2[0] = 0;
		D1[1] = S1st[1] + e1; 
		D2[1] = S2nd[1] + e2;
		
		for (int i = 2; i < N+1 ; i++) {
			D1[i] = Math.min( D2[i-1]+T2[i-1]+S1st[i], D1[i-1]+S1st[i]);
			D2[i] = Math.min( D1[i-1]+T1[i-1]+S2nd[i], D2[i-1]+S2nd[i]);
		}
		
		wr.write(String.valueOf(Math.min(D1[N] + x1, D2[N] + x2)));
		
		br.close();
		wr.flush();
		wr.close();
	}

}
