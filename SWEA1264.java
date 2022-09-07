import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1264 {
// SW Expert Academy 1264. 이미지 유사도 검사
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1264.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for (int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			int N=Integer.parseInt(br.readLine().trim());
			char[] arr1=br.readLine().toCharArray();
			char[] arr2=br.readLine().toCharArray();
			int[][] dp=new int[N+1][N+1];
			for (int i=1; i<=N; i++) {
				for (int j=1; j<=N; j++) {
					if (arr1[i-1]==arr2[j-1])	dp[i][j]=dp[i-1][j-1]+1;
					else dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
			double ans=(double)dp[N][N]/N*10000;
			int temp=(int) Math.round(ans);
			StringBuilder strAns=new StringBuilder();
			strAns.append(temp/100).append(".");
			temp%=100;
			if (temp<10)	strAns.append("0");
			strAns.append(temp);
			sb.append(strAns).append("\n");
		}
		System.out.println(sb);
		
		br.close();
	}

}
