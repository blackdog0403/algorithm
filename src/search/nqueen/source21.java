package search.nqueen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
public class source21 {
    static int N;
    static int[] column;
    static int cnt;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        N = Integer.parseInt(br.readLine());
 
        column = new int[N + 1];
 
        for (int i = 1; i <= N; i++) {
            column[1] = i;
            backtracking(1);
        }
 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }
 
    private static void backtracking(int row) {
        if (row == N) {
            cnt++;
            return;
        }
 
        row++;
 
        for (int i = 1; i <= N; i++) {
            column[row] = i;
 
            if (isPossible(row)) {
                backtracking(row);
            }
        }
 
 
    }
 
    private static boolean isPossible(int row) {
 
        for (int i = 1; i < row; i++) {
            if (column[i] == column[row]) {
                return false;
            }
 
            if (Math.abs(column[i] - column[row]) == Math.abs(i - row)) {
                return false;
            }
 
        }
 
        return true;
    }
}