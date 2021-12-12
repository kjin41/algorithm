import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1389 {
// Baekjoon 1389. 케빈 베이컨의 6단계 법칙
// 플로이드-와샿
// 경출도
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1389.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int[][] arr=new int[N+1][N+1];
		for (int i=0; i<=N; i++) {
			for (int j=0; j<=N; j++) {
				arr[i][j]=10000;
			}
		}
		for (int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			arr[a][b]=1;
			arr[b][a]=1;
		}
		
		for (int k=1; k<=N; k++) {
			for (int i=1; i<=N; i++) {
				for (int j=1; j<=N; j++) {
					arr[i][j]=Math.min(arr[i][j], arr[i][k]+arr[k][j]);
				}
			}
		}
		
		int min=10000;
		int index=1;
		for (int i=1; i<=N; i++) {
			int sum=0;
			for (int j=1; j<=N; j++) {
				sum+=arr[i][j];
			}
			sum-=arr[i][i];
			if (min>sum) {
				min=sum;
				index=i;
			}
		}
		
		System.out.println(index);
		br.close();
	}

}
