import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1267 {
// SW Expert Academy 1267. 작업 순서
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1267.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for (int t=1; t<11; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st=new StringTokenizer(br.readLine());
			int V=Integer.parseInt(st.nextToken());
			int E=Integer.parseInt(st.nextToken());
			int[] order=new int[V+1];
			ArrayList<Integer>[] list=new ArrayList[V+1];
			for (int i=1; i<=V; i++) {
				list[i]=new ArrayList<>();
			}
			st=new StringTokenizer(br.readLine());
			for (int i=0; i<E; i++) {
				int s=Integer.parseInt(st.nextToken());
				int e=Integer.parseInt(st.nextToken());
				list[s].add(e);
				order[e]++;
			}
			
			Queue<Integer> queue=new LinkedList<Integer>();
			for (int i=1; i<=V; i++) {
				if (order[i]==0)	queue.add(i);
			}
			
			while(!queue.isEmpty()) {
				int cur=queue.poll();
				sb.append(cur).append(" ");
				for (int next: list[cur]) {
					if (--order[next]==0) {
						queue.add(next);
					}
				}
//				System.out.println(queue);
//				System.out.println(Arrays.toString(order));
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
		br.close();
	}

}
