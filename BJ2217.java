package day211204;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ2217 {
// Baekjoon 2217. 로프
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input2217.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] rope=new int[N];
		for (int i=0; i<N; i++) {
			rope[i]=Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(rope);
		int max=rope[N-1];
		int cnt=1;
		for (int i=N-2; i>=0; i--) {
			if(rope[i]*++cnt>max) {
				max=rope[i]*cnt;
			} 
		}
		System.out.println(max);
		
		br.close();
	}

}
