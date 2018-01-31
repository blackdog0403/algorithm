package geometry.pointposition;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 점의 위치
 * https://koitp.org/problem/SDS_PRO_9_2/read/
 */

public class source {
	public static class Point {
		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}

		long x;
		long y;

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
	}

	static Point[] a;
	static Point p;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;

		a = new Point[N];
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			a[i] = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
		}
		Point x;
		for (int tc = 0; tc < 2; tc++) {
			st = new StringTokenizer(br.readLine());
			p = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
			x = new Point((long) (p.x + 1), (long) (1e9 + 1));
			cnt = 0;

			for (int i = 0; i < N; i++) {
				if (isCross(p, x, a[i], a[(i + 1) % N])) cnt++;
			}
			if (cnt%2==1) wr.write("in" + "\n");
			else wr.write("out"+ "\n");
		}

		br.close();
		wr.flush();
		wr.close();
	}

	public static long ccw(Point p1, Point p2, Point p3) {
		long result = p1.x * p2.y + p2.x * p3.y + p3.x * p1.y - p1.y * p2.x - p2.y * p3.x - p3.y * p1.x;
		return result < 0 ? -1 : 1;
	}

	public static boolean isCross(Point p1, Point p2, Point p3, Point p4) {
		return ccw(p1, p2, p3) * ccw(p1, p2, p4) < 0 && ccw(p3, p4, p1) * ccw(p3, p4, p2) < 0;
	}
}
