import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2458_2 {
// Baekjoon 2458. 키 순서
// 플로이드 와샬
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input2458.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int[][] arr=new int[N+1][N+1];
		
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				arr[i][j]=10000;	// 나머지 최대거리
			}
			arr[i][i]=0;	// 자기자신 0
		}
		
		for (int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			arr[a][b]=1;	// 단방향으로
		}
		
		int count=0;
		for (int k=1; k<=N; k++) {
			for (int i=1; i<=N; i++) {
				for (int j=1; j<=N; j++) {
					arr[i][j]=Math.min(arr[i][j], arr[i][k]+arr[k][j]);
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			boolean flag=true;
			for (int j=1; j<=N; j++) {
				if (arr[i][j]==10000&&arr[j][i]==10000) {	// 양쪽으로 갈수 없으면
					flag=false;
					break;
				}
			}
			if (flag) {
				count++;
			}
		}
		
		System.out.println(count);
		br.close();
	}


}
