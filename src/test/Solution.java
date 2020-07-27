package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
   //        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("/Users/kwangyou/Documents/dev/algorithm/src/test/input.txt"))));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer n = Integer.parseInt(st.nextToken());
        int maxGap = 0;
        int tempGap = 0;


        char[] ar = Integer.toBinaryString(n).toCharArray();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        System.out.println(ar);
        for (int i = 0; i < ar.length; i++) {
              if(ar[i]=='1'){
                  arrayList.add(i);
              }
        }
        for (int i = 0; i < arrayList.size() - 1 ; i++) {
            tempGap = arrayList.get(i+1) - arrayList.get(i) - 1;
            if(maxGap <= tempGap && tempGap > 0) {
                maxGap = tempGap;
            }
        }
//        System.out.println(maxGap);
//        System.out.println(arrayList.toString());
        wr.write(String.valueOf(maxGap));
        br.close();
        wr.flush();
        wr.close();
    }
}
