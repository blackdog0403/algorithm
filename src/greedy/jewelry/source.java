package greedy.jewelry;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class source {

	public static class Jewel {
		int weight;
		int price;

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

	}

	static int J;
	static int B;
	static int[][] jewel;
	static int[] bags;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
	
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		J = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		ArrayList<Jewel> jewelList = new ArrayList<Jewel>();
		bags = new int[B];

		Jewel jewel;
		for (int i = 0; i < J; i++) {
			jewel = new Jewel();
			st = new StringTokenizer(br.readLine());
			jewel.setWeight(Integer.parseInt(st.nextToken()));
			jewel.setPrice(Integer.parseInt(st.nextToken()));
			jewelList.add(jewel);
		}

		Comparator<Jewel> comparator = new Comparator<Jewel>() {
			@Override
			public int compare(Jewel o1, Jewel o2) {
				return o1.getWeight() - o2.getWeight();
			}
		};

		Collections.sort(jewelList, comparator);

		for (int i = 0; i < B; i++) {
			st = new StringTokenizer(br.readLine());
			bags[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(bags);
		
		PriorityQueue<Integer> maxPriceHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		long answer = 0;
		int index =0;
		
		for (int i = 0; i < bags.length; i++) {
			// i ��° ���濡 ���� �� �ִ� �������� �ְ�
			while( index < jewelList.size() && jewelList.get(index).getWeight() <= bags[i]){
				maxPriceHeap.add(jewelList.get(index).getPrice());
				index++;
			}
							
			// ������ ���� �װ� �ش簡�濡 �� �� �ִ� ���� ��� �����̴�.
			if (!maxPriceHeap.isEmpty()) {
				answer += (long) maxPriceHeap.peek();
				maxPriceHeap.poll();
			}
			
			// ������ ũ�⿡ ���� ������������ ������ �صױ� ������ heap�� ����ִ� ������ �ִ밡���� ���� ���濡�� ��ȿ�ϴ�. 
		}

		wr.write(String.valueOf(answer));
		br.close();
		wr.flush();
		wr.close();
	}
}
