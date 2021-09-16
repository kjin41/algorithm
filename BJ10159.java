import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ10159 {
//	Baekjoon 10159. 저울
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input10159.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int arr[][] = new int[N+1][N+1];
		for (int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			arr[b][s]=1;
			arr[s][b]=2;
		}
		
		int sum[] = new int[N+1];
		for (int i=1; i<=N; i++) {
			Queue<int[]> queue = new LinkedList<int[]>();
			queue.add(new int[]{1, i});
			queue.add(new int[]{2, i});
			boolean visited[][] = new boolean[3][N+1];
			visited[1][i]=true;
			visited[2][i]=true;
			
			while(!queue.isEmpty()) {
				int cur[] = queue.poll();
				for (int j=1; j<=N; j++) {
					if (!visited[cur[0]][j]&&arr[cur[1]][j]==cur[0]) {
						queue.add(new int[] {cur[0], j});
//						System.out.println(cur[0]+" "+cur[1]+" "+ j);
						visited[cur[0]][j]=true;
						sum[i]++;
					}
				}
			}
			
		}
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<=N; i++) {
			sb.append(N-sum[i]-1).append("\n");
		}
		System.out.println(sb);
	}

}
