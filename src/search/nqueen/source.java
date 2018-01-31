package search.nqueen;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class source {
	static int numOfCase;
	static int N;
	static int[] column;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		column = new int[N+1];
		
		br.close();
		
		column[1] = 1; // 젤 첫칸에 셋업
		findQueensRoutes(1);

		System.out.println(numOfCase);
	
	}
	
	public static void findQueensRoutes(int row){
        if(row == N){
        	numOfCase++;
        	return;
        } 
        
        for(int i=1;i<=row+1;i++){// row+1까지만 (자기꺼 까지만 판단하기...
        	column[row]=i; //row 행에 i에 놓는다.
            if(column[i]==column[row] || Math.abs(i-row)== Math.abs(column[i]-column[row])) continue;
            findQueensRoutes(row+1); // 문제가 없다면 다음 행으로
        }
    }
}
