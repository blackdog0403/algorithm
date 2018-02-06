package search.nqueen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class source {
	static int answer;
	static int N;
	static int[] column;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		column = new int[N + 1];

		findQueensRoutes(1);

		wr.write(String.valueOf(answer));

		br.close();
		wr.flush();
		wr.close();

	}

	public static void findQueensRoutes(int row) {

		if (row == N + 1) {
			answer++;
			return;
		}

		for (int i = 1; i <= N; i++) {
			column[row] = i;
			if (check(row)) {
				findQueensRoutes(row + 1);
			}
		}

	}

	private static boolean check(int row) {

		for (int i = 1; i < row; i++) {
			if (column[i] == column[row] || Math.abs(column[i] - column[row]) == Math.abs(i - row)) {
				return false;
			}
		}

		return true;
	}

}
