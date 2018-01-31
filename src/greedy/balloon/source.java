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

			if (arrow[height] == 0) { // �ش���̿� ȭ���� ������ ���ٸ�.
				// arrow[height]++; // �ش���̿� ȭ�� ��
				arrowCount++;
				// arrow[height]--; // ǳ���� ���߰� ȭ���� ������
				arrow[height - 1]++; // ȭ���� ��ġ�� height-1�� �̵������� ǥ��
			} else { // �ش���̿� ȭ���� ���ư��� �ִٸ�
				arrow[height]--; // ǳ���� ���߰� ȭ���� ������
				arrow[height - 1]++; // ȭ���� ��ġ�� height-1�� �̵������� ǥ��
			}
		}

		wr.write(String.valueOf(arrowCount));
		br.close();
		wr.flush();
		wr.close();
	}
}
