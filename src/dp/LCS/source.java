package dp.LCS;

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

		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		String n = st.nextToken(); // ABCBDAB // 긴것을 Y이 축에 놓는것이 좋음
		st = new StringTokenizer(br.readLine().trim());
		String m = st.nextToken(); // BDCABA

		int[][] D = new int[n.length() + 1][m.length() + 1];
		int[][] P = new int[n.length() + 1][m.length() + 1];
		char[] answer = new char[1212];

		for (int i = 1; i < n.length() + 1; i++) {
			for (int j = 1; j < m.length() + 1; j++) {
				if (i >= 1 && j >= 1) {
					if (n.charAt(i - 1) == m.charAt(j - 1)) {
						D[i][j] = D[i - 1][j - 1] + 1;
						P[i][j] = 0; // 대각선은 0!
					} else {
						if (D[i - 1][j] > D[i][j - 1]) {
							D[i][j] = D[i - 1][j];
							P[i][j] = 1; // 위쪽을 참조했다면 1 ! (실은 아래쪽임..)
						} else {
							D[i][j] = D[i][j - 1];
							P[i][j] = 2; // 왼쪽을 참조햇다면 2 !
						}
					}
				}
			}
		}

		int curN = n.length();
		int curM = m.length();
		int ans_size = 0;

//		for (int i = 0; i < n.length() + 1; i++) {
//			for (int j = 0; j < m.length() + 1; j++) {
//				System.out.print(D[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		for (int i = 0; i < n.length() + 1; i++) {
//			for (int j = 0; j < m.length() + 1; j++) {
//				System.out.print(P[i][j] + " ");
//			}
//			System.out.println();
//		}

		while (curN > 0 && curM > 0) {
			if (P[curN][curM] == 0) {
				answer[ans_size] = n.charAt(curN - 1);
				ans_size++;
				curN--; // 대각선 이동
				curM--; 
			} else if (P[curN][curM] == 1) curN--; // 위로이동
			else curM--; // 왼쪽이동
		}

		for (int i = ans_size - 1; i >= 0; i--) {
			wr.write(String.valueOf(answer[i]));
		}

		br.close();
		wr.flush();
		wr.close();
	}
}
