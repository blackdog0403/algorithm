package dp.rodcutting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class source {
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		 
		int rod[] = new int[N+1];
		int price[] = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i < N+1; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}
		
		rod[0] = 0;
		price[0] = 0;
		
		int max=0;
		
		for (int j = 1; j < N+1; j++) {
			for (int i = 1; i <=j ; i++) {
				if (max < rod[j-i]+price[i]) {
					max = rod[j-i]+price[i];
				} 
			}
			rod[j] = max;
		}
		
		
		wr.write(String.valueOf(rod[N]));
		br.close();
		wr.flush();
		wr.close();
	}
	
}
