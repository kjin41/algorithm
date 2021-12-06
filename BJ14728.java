import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14728 {
// Baekjoon 14728. 벼락치기
// dp
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input14728.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int T=Integer.parseInt(st.nextToken());
		int[][] arr=new int[N+1][T+1];
		for (int i=1; i<=N; i++) {
			st=new StringTokenizer(br.readLine());
			int K=Integer.parseInt(st.nextToken());
			int S=Integer.parseInt(st.nextToken());
			for (int t=1; t<=T; t++) {
				if (t<K) {
					arr[i][t]=arr[i-1][t];
				} else {
					arr[i][t]=Math.max(arr[i-1][t-K]+S, arr[i-1][t]);
				}
			}
		}
		System.out.println(arr[N][T]);
		
		br.close();
	}

}
