package dp.close2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class source {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		long[] D = new long[N+1];
		long[] PZERO = new long[N+1];
		
		D[0]=0;
		PZERO[0]=0;
		D[1]=1;
		PZERO[1]=0;
		
		for (int i = 2; i <=N; i++) {
			D[i] = PZERO[i-1]*2 + (D[i-1]-PZERO[i-1]);
			PZERO[i] = PZERO[i-1] + (D[i-1]-PZERO[i-1]);
		}
		
		wr.write(String.valueOf(D[N]));
		br.close();
		wr.flush();
		wr.close();
		
	}

}