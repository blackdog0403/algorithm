package datastructure.stack.tower;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;
/*
 * https://koitp.org/problem/SDS_PRO_3_4/read/
 */
public class source {
	static int N;
	static int[] tower;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		tower = new int[N + 1];
		Stack<Integer> towerStack = new Stack<Integer>();
		Stack<Integer> towerIndex = new Stack<Integer>();

		towerStack.push(1000000000);
		towerIndex.push(0);

		for (int i = 1; i <= N; i++) {
			tower[i] = Integer.parseInt(st.nextToken());
			
			while (!towerStack.empty() && towerStack.peek() < tower[i]) {
				towerStack.pop();
				towerIndex.pop();
			}
			
			wr.write(String.valueOf(towerIndex.peek()) + " ");
			
			towerStack.push(tower[i]);
			towerIndex.push(i);
		}
		
		br.close();
		wr.flush();
		wr.close();
	}
}
