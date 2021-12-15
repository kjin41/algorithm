import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2156 {
// Baekjoon 2156. 포도주 시식
// dp
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input2156.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] arr=new int[N+1];
		int[] dp=new int[N+1];
		for (int i=1; i<=N; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		dp[1]=arr[1];
		if (N!=1) {
			dp[2]=dp[1]+arr[2];
		}
		for (int i=3; i<=N; i++) {	// 셋 중 최대값
			dp[i]=Math.max(dp[i-3]+arr[i-1]+arr[i], Math.max(dp[i-2]+arr[i], dp[i-1]));
		}
		
		System.out.println(dp[N]);
		
		br.close();
	}

}
