package divide.paperdivide;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class source {
	
	static int N;
	static int[][] colorOfPaper;
	static int one;
	static int zero;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		colorOfPaper = new int[N][N];
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				colorOfPaper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dividePaper(0,0,N-1,N-1);
		wr.write(String.valueOf(zero)+"\n"+String.valueOf(one));
		
		br.close();
		wr.flush();
		wr.close();
	}
	
	public static void dividePaper(int x1,int y1, int x2, int y2){
		boolean isPaperSame = true;
		
		for (int i = x1; i <= x2; i++) {
			for (int j = y1; j <= y2; j++) {
				if(colorOfPaper[i][j] != colorOfPaper[x1][y1]) {
					isPaperSame = false;
					break;
				}
			}
			if (!isPaperSame) break;
		}
		
		if(isPaperSame){
			if(colorOfPaper[x1][y1]==1) {
				one++;
			} else {
				zero++;
			}
			return;
		}
		
		int mx = (x1+x2)/2;
		int my = (y1+y2)/2;
		dividePaper(x1,y1,mx,my);
		dividePaper(mx+1,y1,x2,my);
		dividePaper(x1,my+1,mx,y2);
		dividePaper(mx+1,my+1,x2,y2);

	}
}
