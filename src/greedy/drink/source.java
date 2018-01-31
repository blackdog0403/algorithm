package greedy.drink;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class source {
	public static class Promise {
		int time;
		int drink;

		public Promise(int time, int drink) {
			this.time = time;
			this.drink = drink;
		}

		public int getTime() {
			return time;
		}

		public void setTime(int time) {
			this.time = time;
		}

		public int getDrink() {
			return drink;
		}

		public void setDrink(int drink) {
			this.drink = drink;
		}
		
		@Override
		public String toString() {
			return "Promise [time=" + time + ", drink=" + drink + "]";
		}
		

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

		int N;
		long spendTime=0;
		long totalDrink=0;
		
		N = Integer.parseInt(br.readLine());

		StringTokenizer st;
		ArrayList<Promise> promiseList = new ArrayList<Promise>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			promiseList.add(new Promise(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Comparator<Promise> comparator = new Comparator<Promise>() {
			@Override
			public int compare(Promise i, Promise j) {
				return  i.getTime() * j.getDrink() - j.getTime()*i.getDrink();
			}
		};
		
		Collections.sort(promiseList,comparator);
		
		
//		for (Promise promise : promiseList) {
//			System.out.println(promise.toString());
//		}
		
		for (Promise promise : promiseList) {
			totalDrink+= (long) promise.getDrink() * spendTime;
			spendTime += promise.getTime() * 2;
		}
		
		wr.write(String.valueOf(totalDrink));
		
		br.close();
		wr.flush();
		wr.close();

	}
}
