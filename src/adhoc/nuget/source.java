package adhoc.nuget;

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

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] a = new long[N];

		for (int i = 0; i < N; i++) {
			a[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(a);
		long now = 0;
		
		for (int i = 0; i < N; i++) {
			if (a[i] > now + 1) {
				wr.write(String.valueOf(now + 1));
				wr.flush();
				wr.close();
				return;
			}
			now += a[i];
		}
		wr.write(String.valueOf(now + 1));
		
		br.close();
		wr.flush();
		wr.close();

	}

}
