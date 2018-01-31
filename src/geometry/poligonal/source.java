package geometry.poligonal;

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
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;

		long[][] P = new long[N + 1][2];
		long answer = 0;
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			P[i][0] = Integer.parseInt(st.nextToken());
			P[i][1] = Integer.parseInt(st.nextToken());
		}

		long poliStartX;
		long poliStartY;
		long poliEndX;
		long poliEndY;

		poliStartX = P[1][0];
		poliStartY = P[1][1];
		
		for (int i = 3; i <= N; i++) {
			poliEndX = P[i][0];
			poliEndY = P[i][1];
			answer += calcArea(poliStartX, poliStartY, P[i-1][0],P[i-1][1], poliEndX, poliEndY);
		}
	
		wr.write(String.valueOf(answer/2) +"."+ String.valueOf(answer%2==0 ? 0 : 5));
		br.close();
		wr.flush();
		wr.close();
	}

	public static long calcArea(long x1, long y1, long x2, long y2, long x3, long y3) {

		long extent = Math.abs(x1 * y2 + x2 * y3 + x3 * y1 - y1 * x2 - y2 * x3 - y3 * x1) ;
		return extent;

	}
}
