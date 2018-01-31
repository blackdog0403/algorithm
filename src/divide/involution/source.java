package divide.involution;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class source {
	static int N;
	static long mod;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		long a = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		mod = (long) (1e9 + 7);

		wr.write(String.valueOf(calc(a%mod, m)));
		
		br.close();
		wr.flush();
		wr.close();
	}

	static long calc(long a, long m) {
		if (m == 0)	return 1;
		
		long x = calc(a, m / 2);
		
		long y;
		
		if (m % 2 == 1) { // È¦¼ö¸é x^2m+1 = x^m X x^m * a 
			y = a;
		} else {          // Â¦¼ö¸é x^2m = x^m X x^m * 1
			y = 1;
		}
		return (x * x % mod * y) % mod;

	}
}