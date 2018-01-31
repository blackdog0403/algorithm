package sort.house;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class sourceTest2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int holeCentimeter = Integer.parseInt(br.readLine());
		int holeWidth = holeCentimeter * 10000000;

		int N = Integer.parseInt(br.readLine());
		int[] parts = new int[N];

		for (int i = 0; i < N; i++) {
			parts[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(parts);
		
		int maxDiff = 0;
		int head = 0;
		int tail = 0;

		for (int i = 0; i < parts.length; i++) {

			int shortPart = parts[i];
			int longPart = holeWidth - shortPart;

			if (Arrays.binarySearch(parts, i+1, parts.length, longPart) >= 0) {
				if (Math.abs(shortPart - longPart) > maxDiff) {
					maxDiff = Math.abs(shortPart - longPart);
					head = shortPart;
					tail = longPart;
				}
			}
		}

		if (maxDiff > 0) {
			System.out.println("yes " + head + " " + tail);
		} else {
			System.out.println("danger");
		}

	}

}
