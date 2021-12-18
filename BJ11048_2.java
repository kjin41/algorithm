import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11048_2 {
// Baekjoon 11048. 이동하기
// DP
	
	static int N,M,max;
	static int[][] arr, dp;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input11048.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr=new int[N+1][M+1];
		dp=new int[N+1][M+1];
		
		for (int i=1; i<=N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j=1; j<=M; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=M; j++) {
				dp[i][j]=arr[i][j]+Math.max(dp[i-1][j], Math.max(dp[i][j-1], dp[i-1][j-1]));
			}
		}
		
		System.out.println(dp[N][M]);
		
		br.close();
	}

}
