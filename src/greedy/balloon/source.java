package greedy.balloon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class source {
	static int N;
	static int[] balloon;
	static int[] arrow;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine().trim());
		balloon = new int[N];
		arrow = new int[101010];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			balloon[i] = Integer.parseInt(st.nextToken());
		}

		int arrowCount = 0;
		int height;
		for (int i = 0; i < balloon.length; i++) {
			height = balloon[i];

			if (arrow[height] == 0) { // 해당높이에 화살을 쏜적이 업다면.
				// arrow[height]++; // 해당높이에 화살 쏨
				arrowCount++;
				// arrow[height]--; // 풍선을 맞추고 화살은 내려감
				arrow[height - 1]++; // 화살의 위치는 height-1로 이동했음을 표현
			} else { // 해당높이에 화살이 날아가고 있다면
				arrow[height]--; // 풍선을 맞추고 화살은 내려감
				arrow[height - 1]++; // 화살의 위치는 height-1로 이동했음을 표현
			}
		}

		wr.write(String.valueOf(arrowCount));
		br.close();
		wr.flush();
		wr.close();
	}
}
