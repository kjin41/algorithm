import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA14179 {
// SW Expert Academy 14179. 복제한 수열의 인버전 수
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input14179.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		long mod=(long) (Math.pow(10, 9)+7);
		for (int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			long K=Long.parseLong(st.nextToken());
			int[] arr=new int[N];
			int[][] order=new int[2][N];
			st=new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			
			for (int i=0; i<N; i++) {
				for (int j=i+1; j<N; j++) {		// 자기보다 큰 인덱스 중 작은 원소 개수
					if (arr[i]>arr[j]) 	order[0][i]++;
				}
				for (int j=0; j<N; j++) {		// 전체 중 작은 원소 개수
					if (arr[i]>arr[j]) 	order[1][i]++;
				}
			}
			
			long a=0, b=0;
			for (int i=0; i<N; i++) {
				a+=order[0][i];
				b+=order[1][i];
			}
			
			long ans=(K*(K-1)/2)%mod;
			ans=(ans*b)%mod;
			ans=(ans+K*a)%mod;

			sb.append(ans).append("\n");
		}
				
		System.out.println(sb);
		br.close();
	}

}
