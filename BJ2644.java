import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2644 {
// Baekjoon 2644. 촌수 계산
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input2644.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[][] arr=new int[N+1][N+1];
		boolean[] visited=new boolean[N+1];
		StringTokenizer st=new StringTokenizer(br.readLine());
		int start=Integer.parseInt(st.nextToken());
		int end=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(br.readLine());
		for (int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int parent=Integer.parseInt(st.nextToken());
			int child=Integer.parseInt(st.nextToken());
			arr[parent][child]=1;
		}
		
		Queue<Integer> queue=new LinkedList<Integer>();
		queue.add(start);
		visited[start]=true;
		int count=0;
		
		loop:
		while(!queue.isEmpty()) {
			int size=queue.size();
			for (int s=0; s<size; s++) {
				int cur=queue.poll();
				if (cur==end) {
					visited[cur]=true;
					break loop;
				}
				for (int i=1; i<=N; i++) {
					if (!visited[i] & (arr[i][cur]==1 || arr[cur][i]==1)) {
						queue.add(i);
						visited[i]=true;
					}
				}
			}
			count++;
		}
		
		if (!visited[end]) {
			count=-1;
		}
		
		System.out.println(count);
		
		br.close();
	}

}
