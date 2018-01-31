package datastructure.stack.area;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;
/*
 * 히스토그램에서 가장 큰 직사각형
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

			// 비교값을 초기화. 가장 작은 값을 세팅
			boxStack.push(-1);
			boxPosition.push(0);

			// 박스별 왼쪽으로 확장가능한 위치 구하기

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
			// 재초기화
			boxStack.push(-1);
			boxPosition.push(N+1);	

			// 박스별 오른쪽으로 확장가능한 위치 구하기
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
