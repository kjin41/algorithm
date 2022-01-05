import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1916 {
// Baekjoon 1916. 최소비용 구하기
// long
// 중복 가능해서 입력받을때 최소값으로 넣기....
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1916.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int M=Integer.parseInt(br.readLine());
		long[][] arr=new long[N+1][N+1];
		for (int i=0; i<=N; i++) {
			for (int j=0; j<=N; j++) {
				arr[i][j]=1000000000;
			}
		}
		
		for (int i=0; i<M; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			arr[from][to]=Math.min(arr[from][to],Long.parseLong(st.nextToken()));
		}
		
		boolean[] visited=new boolean[N+1];
		long[] distance=new long[N+1];
		for (int i=0; i<=N; i++) {
			distance[i]=1000000000;
		}
		StringTokenizer st=new StringTokenizer(br.readLine());
		int A=Integer.parseInt(st.nextToken());
		int B=Integer.parseInt(st.nextToken());
		distance[A]=0;
		
		for (int i=1; i<=N; i++) {
			long min=1000000000;
			int index=0;
			for (int j=1; j<=N; j++) {
				if (!visited[j]&&min>distance[j]) {
					index=j;
					min=distance[j];
				}
			}
			
			visited[index]=true;
			if (index==B) {
				break;
			}
			
			for (int j=1; j<=N; j++) {
				if (!visited[j]&&distance[j]>min+arr[index][j]) {
					distance[j]=min+arr[index][j];
				}
			}

		}
		System.out.println(distance[B]);
		
		
		
		br.close();
	}

}
