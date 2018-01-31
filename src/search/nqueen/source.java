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
		
		column[1] = 1; // �� ùĭ�� �¾�
		findQueensRoutes(1);

		System.out.println(numOfCase);
	
	}
	
	public static void findQueensRoutes(int row){
        if(row == N){
        	numOfCase++;
        	return;
        } 
        
        for(int i=1;i<=row+1;i++){// row+1������ (�ڱⲨ ������ �Ǵ��ϱ�...
        	column[row]=i; //row �࿡ i�� ���´�.
            if(column[i]==column[row] || Math.abs(i-row)== Math.abs(column[i]-column[row])) continue;
            findQueensRoutes(row+1); // ������ ���ٸ� ���� ������
        }
    }
}
