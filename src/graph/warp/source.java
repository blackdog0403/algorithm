package graph.warp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class source {
	public static class Redge {
		public Redge(int x, int weight) {
			this.x = x;
			this.weight = weight;
		}
		int x;
		int weight;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		@SuppressWarnings("unchecked")
		ArrayList<Redge>[] edges = new ArrayList[121212];
		for (int i = 0; i < edges.length; i++) {
			edges[i] = new ArrayList<Redge>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int tempS = Integer.parseInt(st.nextToken());
			int tempE = Integer.parseInt(st.nextToken());
			int tempWeight = Integer.parseInt(st.nextToken());
			// tempE ���� ������ ���� ���ؽ��� �������� ����ġ�� arraylist�� �����صд�
			edges[tempE].add(new Redge(tempS, tempWeight));
		}

		long[] D = new long[121212];
		for (int i = 1; i <= N; i++) {
			D[i] = -1;
		}
		D[1] = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < edges[i].size(); j++) {
				Redge prev = edges[i].get(j);
				if (D[prev.x] == -1)
					continue;
				// i��° ������ ���� ������� �ʾҰų�
				// i���� ���� ����ߴµ� (�� ���������� �ּҰŸ� + �������� i������ ���� �����Ÿ� )
				if (D[i] == -1 || D[i] > D[prev.x] + prev.weight) {
					D[i] = D[prev.x] + prev.weight;
				}
			}
		}
		wr.write(String.valueOf(D[N]));
		br.close();
		wr.flush();
		wr.close();
	}
}
