package sort.house;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class sourceTest {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int hole = Integer.parseInt(br.readLine());
		int holeWidth = 1 * 10000000;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] parts = new int[N];
		
		for (int i = 0; i < N; i++) {
			parts[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(parts);
		int maxDiff = 0;
		int head =0;
		int tail =0;
		
		
		for (int i = 0; i < parts.length; i++) {
			for (int j = parts.length - 1; j >= 0 ; j--) {
				if( parts[i] + parts[j]  < holeWidth ) {
					break;
				} else if ( parts[i] + parts[j] == holeWidth ){
				  if(Math.abs(parts[i] - parts[j]) > maxDiff) {
					  head = parts[i];
					  tail = parts[j];
					  maxDiff = Math.abs(parts[i] - parts[j]);
				  }
				} else if (parts[i] + parts[j] > holeWidth) {
					continue;
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
