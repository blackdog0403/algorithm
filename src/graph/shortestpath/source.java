package graph.shortestpath;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.security.acl.Owner;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 최단경로
 * https://koitp.org/problem/SHORTEST_PATH/read/
 */
public class source {

	public static class Vertex implements Comparable<Vertex> {
		public Vertex(int x, long weight) {
			this.x = x;
			this.weight = weight;
		}

		int x;
		long weight;

		@Override
		public int compareTo(Vertex o) {
			if (this.weight == o.weight)
				return o.x - this.x; // x좌표에 내림차순
			else
				return (int) (this.weight - o.weight); // 거리에 오름차순
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] dist = new long[121212];
		int[] isPassed = new int[121212];
		PriorityQueue<Vertex> pque = new PriorityQueue<Vertex>();
		// 도시간의 거리를 저장할 edge
		ArrayList<Vertex>[] edges = new ArrayList[121212];

		for (int i = 0; i < edges.length; i++) {
			edges[i] = new ArrayList<Vertex>();
		}

		// 인접 vertex 저장함.
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int tempS = Integer.parseInt(st.nextToken());
			int tempE = Integer.parseInt(st.nextToken());
			long tempWeight = Long.parseLong(st.nextToken());
			edges[tempS].add(new Vertex(tempE, tempWeight));
			edges[tempE].add(new Vertex(tempS, tempWeight));
		}

		// i까지의 최소거리를 저장할 배열.
		for (int i = 2; i <= N; i++) {
			dist[i] = -1;
		}

		pque.add(new Vertex(1, 0));

		while (!pque.isEmpty()) {
			int now = pque.peek().x;
			pque.poll();
			if (isPassed[now] == 1)
				continue;
			isPassed[now] = 1;
			for (int i = 0; i < edges[now].size(); i++) {
				Vertex closeVertex = edges[now].get(i);
				// 한번도 방문하지 않았다면 (무한대면) 인접버텍스로 가는 새루트의 거리가 작다면 업데이트
				if (dist[closeVertex.x] == -1 || dist[closeVertex.x] > dist[now] + closeVertex.weight) {
					dist[closeVertex.x] = dist[now] + closeVertex.weight;
					pque.add(new Vertex(closeVertex.x, dist[closeVertex.x]));
				}
			}
		}
		wr.write(String.valueOf(dist[N]));
		br.close();
		wr.flush();
		wr.close();
	}
}
