import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ14938 {
// Baekjoon 14938. 서강그라운드
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input14938.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int R=Integer.parseInt(st.nextToken());
		int[][] arr=new int[N+1][N+1];
		int[] item=new int[N+1];
		st=new StringTokenizer(br.readLine());
		for (int i=1; i<=N; i++) {
			item[i]=Integer.parseInt(st.nextToken());
		}
		
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				arr[i][j]=100000;
			}
			arr[i][i]=0;
		}
		
		for (int r=0; r<R; r++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int l=Integer.parseInt(st.nextToken());
			arr[a][b]=l;
			arr[b][a]=l;
		}
		
		for (int k=1; k<=N; k++) {
			for (int i=1; i<=N; i++) {
				for (int j=1; j<=N; j++) {
					if (arr[i][j]>arr[i][k]+arr[k][j]) {
						arr[i][j]=arr[i][k]+arr[k][j];
					}
				}
			}
		}
		
		
		int max=0;
		for (int i=1; i<=N; i++) {
			int temp=0;
			for (int j=1; j<=N; j++) {
				if (arr[i][j]<=M) {
					temp+=item[j];
				}
			}
			if (max<temp) {
				max=temp;
			}
		}
		
		System.out.println(max);
		
		br.close();
	}

}
