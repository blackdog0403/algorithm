package sort.house;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class source {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int hole = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int[] parts = new int[N];
	
		for (int i = 0; i < N; i++) {
			parts[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(parts);
		
		int holeWidth = hole * 10000000;
		int maxDiff = -1;
		int targetIndex = -1;
		int start, end = 0;
		
		for (int i = 0; i < N ; i++) {
			start = i+1;
			end = N-1;
			
			int result = -1;
			int F = holeWidth - parts[i];

			// binarySearch
			while(start <= end){
				int medium = (start + end) / 2;
				if(F == parts[medium]) {
					result = medium;
					break;
				}
				if (F < parts[medium]) end = medium - 1;
				else start = medium + 1;
			}
			
			if(result == -1) continue;
			if(maxDiff < parts[result] - parts[i]) {
				maxDiff = parts[result] - parts[i];
				targetIndex = i;
			}
		}

		if (maxDiff == -1) System.out.println("danger");
		else System.out.println("yes " + parts[targetIndex] + " " + (holeWidth - parts[targetIndex]) );

	}

}
