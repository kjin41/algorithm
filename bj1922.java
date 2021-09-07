import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1922 {
// baekjoon 1922. 네트워크 연결
// MST prim
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input1922.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int arr[][] = new int[N+1][N+1];
		StringTokenizer st;
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr[s][e] = w;
			arr[e][s] = w;
		}
		
		int minEdge[] = new int[N+1];
		boolean visited[] = new boolean[N+1];
		for (int i=1; i<=N; i++) {
			minEdge[i] = 10000;
		}
		
		int result=0;
		minEdge[1]=0;
		
		for (int i=1; i<=N; i++) {
			int min = 10000;
			int minN = 0;
			for (int j=1; j<=N; j++) {
				if (!visited[j] && min>minEdge[j]) {
					min = minEdge[j];
					minN = j;
				}
			}
			
			visited[minN]=true;
			result+=min;
			
			for (int j=1; j<=N; j++) {
				int temp = arr[minN][j];
				if (!visited[j] && temp!=0 && minEdge[j]>temp) {
					minEdge[j]=temp;
				}
			}
		}
		
		System.out.println(result);
		
	}

}


