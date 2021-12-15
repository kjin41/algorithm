import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2458 {
// Baekjoon 2458. 키 순서
// bfs
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input2458.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int[][] arr=new int[N+1][N+1];
		for (int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			arr[a][b]=1;
			arr[b][a]=2;
		}
		
		boolean[] know=new boolean[N+1];
		int count=0;
		for (int i=1; i<=N; i++) {
			compare(i, arr, 1, N);
			compare(i, arr, 2, N);
			
		}
		
		for (int i=1; i<=N; i++) {
			int temp=0;
			for (int j=1; j<=N; j++) {
				if (arr[i][j]==0) {
					temp++;
				}
			}
			if (temp==1) {
				count++;
			}
		}
			
		System.out.println(count);
		br.close();
	}

	private static void compare(int i, int[][] arr, int flag, int N) {boolean[] visited=new boolean[N+1];
		visited[i]=true;
		Queue<Integer> queue=new LinkedList<Integer>();
		queue.add(i);
		while(!queue.isEmpty()) {
			int t=queue.poll();
			for (int j=1; j<=N; j++) {
				if (!visited[j]&&arr[t][j]==flag) {
					queue.add(j);
					arr[i][j]=flag;
					visited[j]=true;
				}
			}
		
		}
		
	}

}
