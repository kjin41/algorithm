import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ12865 {
// Baekjoon 12865. 평범한 배낭
// dpdpdpdp
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input12865.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int[][] dp=new int[N+1][K+1];
		
		for (int i=1; i<=N; i++) {
			st=new StringTokenizer(br.readLine());
			int W=Integer.parseInt(st.nextToken());
			int V=Integer.parseInt(st.nextToken());
			for (int k=1; k<=K; k++) {
				if (k<W) {
					dp[i][k]=dp[i-1][k];
				} else {
					dp[i][k]=Math.max(dp[i-1][k], dp[i-1][k-W]+V);	// 무조건 전 행
				}
			}
			
		}
		
		System.out.println(dp[N][K]);
		
		br.close();
	}

}
