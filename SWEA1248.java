import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1248 {
// SW Expert Academy 1248. 공통 조상
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1248.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for (int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st=new StringTokenizer(br.readLine());
			int V=Integer.parseInt(st.nextToken());
			int E=Integer.parseInt(st.nextToken());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			int[][] child=new int[V+1][2];
			int[] parent=new int[V+1];
			st=new StringTokenizer(br.readLine());
			for (int i=0; i<E; i++) {
				int p=Integer.parseInt(st.nextToken());
				int c=Integer.parseInt(st.nextToken());
				parent[c]=p;
				if (child[p][0]==0)	child[p][0]=c;
				else child[p][1]=c;
			}
			
			HashSet<Integer> set=new HashSet<>();
			
			while(a!=0) {
				set.add(a);
				a=parent[a];
			}		
			
			int common=1;
			while(b!=0) {
				if (set.contains(b)) {
					common=b;
					break;
				}
				b=parent[b];
			}
			
			int count=0; 
			Queue<Integer> queue=new LinkedList<Integer>();
			queue.add(common);
			while(!queue.isEmpty()) {
				int cur=queue.poll();
				count++;
				if (child[cur][0]!=0)	queue.add(child[cur][0]);
				if (child[cur][1]!=0)	queue.add(child[cur][1]);
			}
			sb.append(common).append(" ").append(count).append("\n");
			 
		}
		System.out.println(sb);
		br.close();
	}

}
