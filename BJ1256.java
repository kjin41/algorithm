import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1256 {
// Baekjoon 1256. 사전
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1256.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int MAX=1000000001;
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		long[][] dp=new long[N+1][M+1];
		for (int i=0; i<=N; i++) {
			for (int j=0; j<=M; j++) {
				if (i==0||j==0) {
					dp[i][j]=1;
					continue;
				} 
				dp[i][j]=dp[i][j-1]+dp[i-1][j];
				if (dp[i][j]>MAX || dp[i][j-1]==0 || dp[i-1][j]==0) {
					dp[i][j]=MAX;
				}
			}
		}
		
		StringBuilder sb=new StringBuilder();
		int curN=N, curM=M;
		for (int i=0; i<N+M; i++) {
			if (curN*curM==0) {
				break;
			}
			if (dp[curN-1][curM]<K) { 	// a를 앞에 하나 놓았을 경우보다 크면 z 놓기
				sb.append("z");
				K-=dp[curN-1][curM];
				curM--;
			} else {
				sb.append("a");
				curN--;
			}
		}
		
		if (K!=1) {
			System.out.println(-1);
			System.exit(0);
		}
		
		for (int i=0; i<curN; i++) {
			sb.append("a");
		}
		for (int i=0; i<curM; i++) {
			sb.append("z");
		}
		System.out.println(sb);
		
		
		br.close();
	}

}
