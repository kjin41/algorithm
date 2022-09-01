import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ11437 {
// Baekjoon 11437. LCA
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input11437.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		ArrayList<Integer>[] list=new ArrayList[N+1];
		for (int i=1; i<=N; i++) {
			list[i]=new ArrayList<>();
		}
		for (int i=0; i<N-1; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		
		int[] depth=new int[N+1];
		int[] parent=new int[N+1];
		boolean[] visited=new boolean[N+1];
		Queue<Integer> queue=new LinkedList<Integer>();
		queue.add(1);
		visited[1]=true;
		int count=0;
		while(!queue.isEmpty()) {
			int size=queue.size();
			for (int s=0; s<size; s++) {
				int cur=queue.poll();
				depth[cur]=count;
				for (int child: list[cur]) {
					if (visited[child])	continue;
					queue.add(child);
					visited[child]=true;
					parent[child]=cur;
				}
			}
			count++;
		}
		
		int M=Integer.parseInt(br.readLine());
		for (int i=0; i<M; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int d1=depth[a];
			int d2=depth[b];
			while(a!=b) {
				if (d1>d2)	{
					a=parent[a];
					d1--;
				} else if (d1<d2) {
					b=parent[b];
					d2--;
				} else{
					a=parent[a];
					b=parent[b];
				}
			}
			System.out.println(a);
		}
		
		br.close();
	}

}
