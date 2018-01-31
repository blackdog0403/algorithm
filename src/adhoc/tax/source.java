package adhoc.tax;

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

		long i,j =0;
		long[] a = new long[1212121];
		long[] D = new long[101];
		long[] ans = new long[101];
		long[] temp = new long[101];

		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Integer.parseInt(st.nextToken());
		long K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (i = 0; i < N; i++) {
			a[(int) i] = Long.parseLong(st.nextToken());
		}
		for (i = 0; i < N; i++) {
			for (j = 0; j < Math.min(K, i); j++) {
				D[(int) j] += a[(int) i];
			}
			j = Math.min(K, i);
			while ( j > 0 && D[(int) (j-1)] < a[(int) i]) {
//				D[]
				
			}
			
		}
		wr.write(String.valueOf(10));
		br.close();
		wr.flush();
		wr.close();

	}

}
