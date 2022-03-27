import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1005_4 {
// Baekjoon 1005. ACM Craft
// 위상 정렬
// DP
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1005.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int K=Integer.parseInt(st.nextToken());
			
			int[] buildTime=new int[N+1];
			int[] order=new int[N+1];
			int[] dp=new int[N+1];
			ArrayList<Integer>[] list=new ArrayList[N+1];
			st=new StringTokenizer(br.readLine());
			for (int i=1; i<=N; i++) {
				buildTime[i]=Integer.parseInt(st.nextToken());
				list[i]=new ArrayList<>();
			}
			for (int i=0; i<K; i++) {
				st=new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				list[a].add(b);
				order[b]++;
			}
			int W=Integer.parseInt(br.readLine());
			
			Queue<Integer> queue=new LinkedList<>();
			for (int i=1; i<=N; i++) {
				if (order[i]==0) {
					queue.add(i);
				}
			}
			
			loop:
			while(!queue.isEmpty()) {
				int size=queue.size();
				int max=0;
				for (int s=0; s<size; s++) {
					int cur=queue.poll();
					dp[cur]+=buildTime[cur];
					if (cur==W) {
						break loop;
					}
					
					max=Math.max(max, buildTime[cur]);
					for (int i=0; i<list[cur].size(); i++) {
						int next=list[cur].get(i);
						dp[next]=Math.max(dp[cur], dp[next]);
						if (--order[next]==0) {
							queue.add(next);
						}
					}
				}
			}
			sb.append(dp[W]).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}

}
