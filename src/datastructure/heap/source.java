package datastructure.heap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
/*
 * �߾Ӱ�
 * https://koitp.org/problem/SDS_PRO_3_6/read/
 */
public class source {
	static int N;
	static int[] number;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		int medium;
		
		N = Integer.parseInt(br.readLine().trim());
		
		number = new int[N];
		
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(br.readLine().trim());
		}
		//Heap�� �������� �⺻!
		//�߰��� ������ ������������ 
		//�߰��� �������� ������������
		PriorityQueue<Integer> leftHeap = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> rightHeap = new PriorityQueue<>();
		

		medium =number[0];
		wr.write(String.valueOf(medium)+"\n");
		

		//2��° ���� Ȧ����° ���� ó���Ѵ�.
		for (int i = 1; i < N - 1; i+=2) {
			for (int j = 0; j < 2; j++) {
				if(number[i+j] < medium) leftHeap.add(number[i+j]);
				else rightHeap.add(number[i+j]);
			}
			
			while(leftHeap.size() > rightHeap.size()) {
				rightHeap.add(medium);
				medium = leftHeap.peek();
				leftHeap.poll();
			}
			
			while(leftHeap.size() < rightHeap.size()) {
				leftHeap.add(medium);
				medium = rightHeap.peek();
				rightHeap.poll();
			} 
			
			wr.write(String.valueOf(medium)+"\n");
		}
		
		br.close();
		wr.flush();
		wr.close();
	}
}
