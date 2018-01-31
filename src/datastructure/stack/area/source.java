package datastructure.stack.area;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;
/*
 * ������׷����� ���� ū ���簢��
 * https://koitp.org/problem/SDS_PRO_3_4/read/
 */
public class source {
	static int N;
	static int[] height;
	static long[] LPos;
	static long[] RPos;

	public static void main(String[] args) throws NumberFormatException, IOException {

		height = new int[100001];
		LPos = new long[100001];
		RPos = new long[100001];

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

		Stack<Integer> boxStack = new Stack<Integer>();
		Stack<Integer> boxPosition = new Stack<Integer>();
		StringTokenizer st;
		int N;
		
		while (true) {
			
			st = new StringTokenizer(br.readLine());
			if (st.countTokens() == 1) {
				break;
			}
			
			N = Integer.parseInt(st.nextToken());

			for (int i = 1; i <= N; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}

			// �񱳰��� �ʱ�ȭ. ���� ���� ���� ����
			boxStack.push(-1);
			boxPosition.push(0);

			// �ڽ��� �������� Ȯ�尡���� ��ġ ���ϱ�

			for (int i = 1; i <= N; i++) {
				while (boxStack.peek() >= height[i]) {
					boxStack.pop();
					boxPosition.pop();
				}
				LPos[i] = boxPosition.peek()+1;
				boxStack.push(height[i]);
				boxPosition.push(i);

			}
			
			boxStack.clear();
			boxPosition.clear();
			// ���ʱ�ȭ
			boxStack.push(-1);
			boxPosition.push(N+1);	

			// �ڽ��� ���������� Ȯ�尡���� ��ġ ���ϱ�
			for (int i = N; i >= 1; i--) {
				while (boxStack.peek() >= height[i]) {
					boxStack.pop();
					boxPosition.pop();
				}
				RPos[i] = boxPosition.peek()-1
						;
				boxStack.push(height[i]);
				boxPosition.push(i);
			}
			
			boxStack.clear();
			boxPosition.clear();
			
			long answer = 0;
			
			for (int i = 1; i <=N ; i++) {
				if(answer < (( RPos[i] - LPos[i] + 1) * height[i] )){
					answer = ( (RPos[i] - LPos[i] + 1) * height[i] );
				}
			}
			
			wr.write(String.valueOf(answer)+"\n");
			
		}

	

		br.close();
		wr.flush();
		wr.close();
	}
}
