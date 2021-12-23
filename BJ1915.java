import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1915 {
// Baekjoon 1915. 가장 큰 정사각형
// dp
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1915.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		char[][] arr=new char[N][M];
		int[][] dp=new int[N][M];
		for (int i=0; i<N; i++) {
			arr[i]=br.readLine().toCharArray();
		}
		
		int max=0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (i==0||j==0) {
					dp[i][j]=arr[i][j]-'0';
				} else if (arr[i][j]=='0') {
					dp[i][j]=0;
				} else {
					dp[i][j]=Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]))+1;	// 셋 중 작은 값+1	
				}
				
				if (max<dp[i][j]) {
					max=dp[i][j];
				}
			}
		}
		
		System.out.println(max*max);
		
		br.close();
		
	}

}
