package sort.manynum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class source {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 한 줄에 정수 하나가 주어지는 경우
		int N = Integer.parseInt(br.readLine());
		// 한 줄에 정수 N개가 공백으로 분리되어 주어지는 경우
//		int[] num = {1,5,3,4,2,5,5,5,2,2,2}; //new int[N];
		int[] num = new int[N];
		int[] count = new int[N];
		
		for (int i = 0; i < N; i++) {
			 num[i] = Integer.parseInt(br.readLine());
		}

//		Comparator<Integer> comparator = new Comparator<Integer>() {
//	        @Override
//	        public int compare(Integer o1, Integer o2) {
//	            return o2 - o1;
//	        }
//	    };
		
		Arrays.sort(num);
		
//		for (int i = 0; i < num.length; i++) {
//			System.out.println(num[i]);
//		}
//		
//		System.out.println("================================================");
		
		count[0]=1;
		
		for (int i = 1; i < num.length ; i++) {
			if (num[i] == num[i-1]) {
				count[i] = count[i-1]+1;
			} else{
				count[i] = 1 ;
			}
			
		}
	
//		for (int i = 1; i < count.length; i++) {
//			System.out.println(count[i]);
//		}
//		System.out.println("================================================");
		
		int manyNum =0;
		int maxCount = 0;
		
		for (int i = 0; i < count.length; i++) {
			if( count[i] > maxCount ){
				maxCount = count[i]; 
				manyNum = num[i];
			}
		}
		
		System.out.println(manyNum);
		br.close();
		
		
	}
	
}
