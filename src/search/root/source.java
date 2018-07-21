package search.root;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

//TODO: 조상확인
//https://koitp.org/problem/ROOTED_TREE/read/
public class source {
	
	static int[] start;
	static int[] end;
	static int[] vertex;
	static int count;
	static ArrayList<Integer>[] edge;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		start = new int[121212];
		end = new int[121212];
		vertex = new int[121212];
		count=0;

		edge = new ArrayList[121212];
		for (int i = 0; i < edge.length; i++) {
			edge[i] = new ArrayList<Integer>();
		}
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			int x = Integer.parseInt(st.nextToken());
			if(i == R) continue;
			edge[x].add(i);
			
		}
		
		dfs(R);	
		
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if (start[x] <= vertex[y] && vertex[y] <= end[x]) {
				wr.write("YES");
				wr.write("\n");
			} else {
				wr.write("NO");
				wr.write("\n");
			}
		}
		
		br.close();
		wr.flush();
		wr.close();
	}
	
	public static void dfs(int x) {
		count++;
		start[x] = count; // 시작시점
		vertex[x] = count;
		for (int i = 0; i < edge[x].size(); i++) {
			dfs(edge[x].get(i));
		}
		
		end[x] = count;
//		System.out.println("start[x]:" + start[x] + " end[x]:" + end[x]);
		
	}
}
