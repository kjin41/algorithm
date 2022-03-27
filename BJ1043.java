import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1043 {
// Baekjoon 1043. 거짓말
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1043.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		boolean[][] arr=new boolean[N+1][N+1];
		st=new StringTokenizer(br.readLine());
		int T=Integer.parseInt(st.nextToken());
		int[] truth=new int[T];
		for (int i=0; i<T; i++) {
			truth[i]=Integer.parseInt(st.nextToken());
		}

		int[][] party=new int[M][50];
		for (int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			for (int j=0; j<n; j++) {
				party[i][j]=Integer.parseInt(st.nextToken());
			}
			for (int j=0; j<n-1; j++) {
				for (int k=j+1; k<n; k++) {
					arr[party[i][j]][party[i][k]]=true;
					arr[party[i][k]][party[i][j]]=true;
				}
			}
		}
		
		
		for (int k=1; k<=N; k++) {
			for (int i=1; i<=N; i++) {
				for (int j=1; j<=N; j++) {
					if (arr[i][k] && arr[k][j]) {
						arr[i][j]=true;
						arr[j][i]=true;
					}
				}
			}
		}
		
		boolean[] connect=new boolean[N+1];
		for (int t: truth) {
			connect[t]=true;
			for (int j=1; j<=N; j++) {
				if (arr[t][j]) {
					connect[j]=true;
				}
			}
		}
		
		int count=0;
		for (int i=0; i<M; i++) {
			boolean flag=false;
			for (int j=0; j<50; j++) {
				if (connect[party[i][j]]) {
					flag=true;
					break;
				}
			}
			if (!flag) {
				count++;
			}
		}
		System.out.println(count);
		
		br.close();
	}

}
