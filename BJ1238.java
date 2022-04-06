import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1238 {
// Baekjoon 1238. 파티
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1238.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int X=Integer.parseInt(st.nextToken());
		int[][] arr=new int[N+1][N+1];
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				arr[i][j]=10000000;
			}
			arr[i][i]=0;
		}
		
		for (int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int t=Integer.parseInt(st.nextToken());
			arr[a][b]=t;
		}
		
		for (int k=1; k<=N; k++) {
			for (int i=1; i<=N; i++) {
				for (int j=1; j<=N; j++) {
					arr[i][j]=Math.min(arr[i][j], arr[i][k]+arr[k][j]);
				}
			}
		}
		
		int max=0;
		for (int i=1; i<=N; i++) {
			max=Math.max(max, arr[X][i]+arr[i][X]);
		}
		
		System.out.println(max);
		br.close();
	}

}
