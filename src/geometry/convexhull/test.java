package geometry.convexhull;

import java.util.Arrays;
import java.util.Comparator;

public class test {
	public static class point {
		int x;
		int y;
		@Override
		public String toString() {
			return "point [x=" + x + ", y=" + y + "]";
		}
		
		
	}
	public static void main(String[] args) {
		point[] p = new point[5];
		for (int i = 0; i < p.length; i++) {
			
			p[i] = new point();
			p[i].x = i;
			p[i].y = p.length - i;
		}

		
		Comparator<point> comp = new Comparator<point>() {

			@Override
			public int compare(point o1, point o2) {
				// TODO Auto-generated method stub
				if(o1.x > o2.x) return 1; // 앞에것이 크면  바꾸라 1는 이야기임 
				else if(o1.x < o2.x) return -1; // 뒤에것이 크면 바꾸지마 -1  즉 오름 차순
				else return 0;
				// o1.x - o2.x; // 오름
				// o2.x - o1.x; // 내림
			}
		};
		
		Arrays.sort(p,comp);
		
		for (int i = 0; i < p.length; i++) {
			System.out.println(p[i]);
		} 
		
	}

}
