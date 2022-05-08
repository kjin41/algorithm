import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ5582 {
// Baekjoon 5582. 공통 부분 문자열
// dp
// https://velog.io/@jkh9615/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-5582-%EA%B3%B5%ED%86%B5-%EB%B6%80%EB%B6%84-%EB%AC%B8%EC%9E%90%EC%97%B4-Java
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input5582.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		char[] arr1=br.readLine().toCharArray();
		char[] arr2=br.readLine().toCharArray();
		
		int len1=arr1.length;
		int len2=arr2.length;
		int max=0;
		
		int[][] dp=new int[len1+1][len2+1];
		for (int i=0; i<len1; i++) {
			for (int j=0; j<len2; j++) {
				if (arr1[i]==arr2[j]) {
					dp[i+1][j+1]=dp[i][j]+1;
					max=Math.max(max, dp[i+1][j+1]);
				}
			}
		}
		
		System.out.println(max);
		
		br.close();
	}

}
