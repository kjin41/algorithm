import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ5567 {
// Baekjoon 5567. 결혼식
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input5567.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int M=Integer.parseInt(br.readLine());
		boolean[][] arr=new boolean[N+1][N+1];
		for (int i=0; i<M; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			arr[a][b]=true;
			arr[b][a]=true;
		}
		
		Queue<Integer> queue=new LinkedList<Integer>();
		boolean[] visited=new boolean[N+1];
		visited[1]=true;
		int count=0;
		for (int i=2; i<=N; i++) {
			if (arr[1][i]&&!visited[i]) {
				queue.add(i);
				visited[i]=true;
				count++;
			}
		}
		while(!queue.isEmpty()) {
			int fr=queue.poll();
			for (int i=1; i<=N; i++) {
				if (arr[fr][i]&&!visited[i]) {
					visited[i]=true;
					count++;
				}
			}
		}
		
		System.out.println(count);
		
		br.close();
	}

}
