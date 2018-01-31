package datastructure.unionandfind.alliance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
 * 동맹의 동맹은 동맹
 * https://koitp.org/category/SDS_PRO_201801_02/
 */
public class source {
	static int N;
	static int Q;
	static int[] parent;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Q = Integer.parseInt(br.readLine());
	    ArrayList<Integer> answers = new ArrayList<Integer>();
		parent = new int[N+1];
		init(N); // 마을사람들의 동맹을 초기화. 본인이 스스로 대표가 되도록.

		StringTokenizer st;
		int queryType;
		int a;
		int b;

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			queryType = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if (queryType == 0) union(a, b); //System.out.println("0");
			else if (queryType == 1) {
				if (find(a) == find(b))	answers.add(1);
				else	answers.add(0);
			}

		}		
		for (Integer answer : answers) {
			System.out.println(answer);
		}
		
		br.close();
	}

	public static void init(int n) {
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
	}

	public static int find(int x) {
		if (parent[x] == x)	return x;
		return parent[x] = find(parent[x]);
	}

	public static void union(int a, int b) {
		int pA = find(a);
		int pB = find(b);
		if (pA == pB) return;
		parent[pB] = parent[pA];
	}
}
