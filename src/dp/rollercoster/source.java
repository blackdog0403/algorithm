package dp.rollercoster;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class source {
	static class Block {
		public Block(int x, int width, int fun, int cost) {
			this.x = x;
			this.w = width;
			this.f = fun;
			this.c = cost;
		}

		int x;
		int w;
		int f;
		int c;

		@Override
		public String toString() {
			return "Block [x=" + x + ", width=" + w + ", fun=" + f + ", cost=" + c + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

		int l, n, b;

		StringTokenizer st = new StringTokenizer(br.readLine());

		l = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		int[][] D = new int[1212][1212];

		ArrayList<Block>[] L = new ArrayList[1001];

		for (int i = 0; i < L.length; i++) {
			L[i] = new ArrayList<Block>();
		}

		Block bl;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			bl = new Block(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			L[bl.x + bl.w].add(bl);
		}

		for (int i = 1; i < b; i++) {
			D[0][i] = -1;
		}

		for (int i = 1; i <= l; i++) {
			for (int j = 0; j <= b; j++) {
				D[i][j] = -1;
				for (int k = 0; k < L[i].size(); k++) {

					if (j - L[i].get(k).c < 0)
						continue; // 비용초과하면 스킵

					if (D[L[i].get(k).x][j - L[i].get(k).c] == -1)
						continue; // 지금 비용을 뺀 케이스에 레일을 놓을 수 없다면

					if (D[i][j] == -1 || D[i][j] < D[L[i].get(k).x][j - L[i].get(k).c] + + L[i].get(k).f) {
						D[i][j] = D[L[i].get(k).x][j - L[i].get(k).c] + L[i].get(k).f;
					}
				}
			}
		}

		int anwser = -1;

		for (int i = 0; i <= b; i++) {
			if (D[l][i] == -1)
				continue;
			if (anwser == -1 || anwser < D[l][i]) {
				anwser = D[l][i];
			}

		}

		wr.write(String.valueOf(anwser));
		br.close();
		wr.flush();
		wr.close();
	}
}
