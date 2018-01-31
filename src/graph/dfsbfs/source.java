package graph.dfsbfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class source {
	public static class Vertex {
		public Vertex() {
			// this.parent = 0;
			// this.dist = 0;
			this.passed = 0;
		}
		// int parent = 0;
		// int dist = 0;
		int passed = 0; // 0, 1, 2
	}

	static Vertex[] vertices;
	static ArrayList<Integer>[] adjList;
	static BufferedReader br;
	static BufferedWriter wr;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		wr = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		// ���ؽ��� �ʱ�ȭ
		vertices = new Vertex[V + 1];
		for (int i = 0; i <= V; i++) {
			vertices[i] = new Vertex();
		}

		// �� ���ý��� �������ý��� �����ϱ� ���� ArrayList�� �ʱ�ȭ
		adjList = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++) {
			adjList[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int tempX = Integer.parseInt(st.nextToken());
			int tempY = Integer.parseInt(st.nextToken());
			adjList[tempX].add(tempY);
			adjList[tempY].add(tempX);
		}

		// ������������ �����س��� �湮������ ������������ ��µǵ��� �Ѵ�.
		for (int i = 1; i <= V; i++) {
			Collections.sort(adjList[i]);
		}

		dfsVisit(S);

		// vertex ���ʱ�ȭ
		vertices = new Vertex[V + 1];
		for (int i = 0; i <= V; i++) {
			vertices[i] = new Vertex();
		}

		wr.write("\n");

		// bfsVisit
		Deque<Integer> que = new LinkedList<Integer>();
		vertices[S].passed = 1;
		que.add(S);
		while (que.size() != 0) {
			int s;
			s = que.poll();
			wr.write(String.valueOf(s) + " ");
			for (int i = 0; i < adjList[s].size(); i++) {
				int v = adjList[s].get(i);
				if (vertices[v].passed == 0) {
					vertices[v].passed = 1;
					// vertices[v].dist = vertices[s].dist;
					// vertices[v].parent = s;
					que.add(v);
				}
			}
		}
		br.close();
		wr.flush();
		wr.close();

	}

	public static void dfsVisit(int s) throws IOException {
		vertices[s].passed = 1; // �������ٰ� ǥ��
		wr.write(String.valueOf(s) + " ");
		for (int i = 0; i < adjList[s].size(); i++) {
			int v = adjList[s].get(i);
			if (vertices[v].passed == 0) { // �� ����������
				// vertices[v].parent = s;
				dfsVisit(v);
			}
		}
	}

}
