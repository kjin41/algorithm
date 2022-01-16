import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2293 {
// baekjoon 2293. 동전 1
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input2293.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int[] arr=new int[N];
		long[] dp=new long[K+1];
		for (int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		dp[0]=1l;	// 아무 동전을 사용하지 않는 경우도 1개의 경우로 생각
		for (int i=0; i<N; i++) {	// 사용할 수 있는 동전을 늘리면서
			for (int j=0; j<=K; j++) {	// j원을 만드는 경우의 수
				if (j>=arr[i]) {		// 사용할 동전보다 만들 j원이 크거나 같아야함
					dp[j]+=dp[j-arr[i]];	// 예를 들어 j=10, arr[i]=3인 경우 7원까지 만든 경우의수에서 3원만 더하면 되므로
				}
			}
		}
		
		System.out.println(dp[K]);
		br.close();
	}

}
