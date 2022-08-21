import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ16940 {
// Baekjoon 16940. BFS 스페셜저지
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input16940.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		HashSet<Integer>[] set=new HashSet[N+1];
		for (int i=1; i<=N; i++) {
			set[i]=new HashSet<>();
		}
		StringTokenizer st;
		for (int i=0; i<N-1; i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			set[a].add(b);
			set[b].add(a);
		}
		int[] order=new int[N];
		st=new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			order[i]=Integer.parseInt(st.nextToken());
		}
		if (order[0]!=1)	{
			System.out.println(0);
			return;
		}
		boolean[] visited=new boolean[N+1];
		Queue<Integer> queue=new LinkedList<Integer>();
		queue.add(1);
		int index=1;
		int count=1;
		while(!queue.isEmpty()) {
			int cur=queue.poll();
			while(index<N) {
				int next=order[index];
				if (!visited[next]&&set[cur].contains(next)) {
					visited[next]=true;
					queue.add(next);
					index++;
					count++;
				} else {
					break;
				}
			}
		}
		if (count==N)	System.out.println(1);
		else System.out.println(0);
		br.close();
	}

}
