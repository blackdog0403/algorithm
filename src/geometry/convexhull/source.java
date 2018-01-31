package geometry.convexhull;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

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

	static Point P;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		P = new Point(0, 0);
		P.y = 414141;
		Point[] a = new Point[N];
		Stack<Point> ST = new Stack<Point>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			a[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			if (a[i].y < P.y) { // 가장낮은 점을 선택 이건 convex hull에 항상 포함되니까.
				P.x = a[i].x;
				P.y = a[i].y;
			}
			if (P.y == a[i].y && a[i].x < P.x) {
				P = a[i]; // 이미 가장 낮다면 더 왼쪽에 있는 점으로 선택.
			}
		}

		Comparator<Point> comparator = new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				long k = ccw(P, o1, o2);
				if (k == 0)
					return (dist(P, o1) - dist(P, o2)) > 0 ? 1 : -1; // 거리가 작은것부터 오름차순으로
				return k < 0 ? 1 : -1; // 반시계 방향으로 정열
			}
		};

		Arrays.sort(a, comparator);

		for (int i = 0; i < N; i++) {
			// 일직선상에 있거나 반시계 방향이면 제거 
			while (ST.size() >= 2 && ccw(ST.get(ST.size() - 2), a[i], ST.get(ST.size() - 1)) >= 0) {
				ST.pop();
			}
			// 시계 방향이면 추가
			ST.push(a[i]);
		}

		wr.write(String.valueOf(ST.size()));
		br.close();
		wr.flush();
		wr.close();
	}

	public static long dist(Point a, Point b) {
		return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
	}

	public static long ccw(Point p1, Point p2, Point p3) {
		return p1.x * p2.y + p2.x * p3.y + p3.x * p1.y - p1.y * p2.x - p2.y * p3.x - p3.y * p1.x;
	}

	// public static boolean isCross(Point p1, Point p2, Point p3, Point p4) {
	// return ccw(p1, p2, p3) * ccw(p1, p2, p4) < 0 && ccw(p3, p4, p1) * ccw(p3,
	// p4, p2) < 0;
	// }
}
