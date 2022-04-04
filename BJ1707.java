import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1707 {
// Baekjoon 1707. 이분그래프
// 사이클과 관련 없음

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1707.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int K=Integer.parseInt(br.readLine());
		for (int k=0; k<K; k++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int V=Integer.parseInt(st.nextToken());
			int E=Integer.parseInt(st.nextToken());
			ArrayList<Integer>[] list=new ArrayList[V+1];
			for (int i=0; i<=V; i++) {
				list[i]=new ArrayList<>();
			}
			
			boolean flag=true;
			for (int i=0; i<E; i++) {
				st=new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				list[a].add(b);
				list[b].add(a);
			}
			
			int[] visited=new int[V+1];		// 집합 1, -1으로 분류
			Queue<Integer> queue=new LinkedList<Integer>();
			loop:
			for (int i=1; i<=V; i++) {
				if (visited[i]==0) {
					queue.add(i);
					visited[i]=1;	// 최초는 아무데나
				}
				
				while(!queue.isEmpty()) {
					Integer cur=queue.poll();
					for (int j=0; j<list[cur].size(); j++) {
						int c=list[cur].get(j);
						if (visited[c]==0) {
							visited[c]=-visited[cur];	// 인접해 있으면 다른 집합으로 분류
							queue.add(c);				// 인접해 있는 원소부터 다음 탐색
						} else if (visited[c]==visited[cur]) {	// 인접해 있는데 같은 집합으로 분류될 경우 NO
							flag=false;
							break loop;
						}
					}
				}
				
			}
			
			if (flag) {
				sb.append("YES").append("\n");
			} else {
				sb.append("NO").append("\n");
			}
			
		}
		
		System.out.println(sb);
		br.close();
	}

}
