import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11657_2 {
// Baekjoon 11657. 타임머신
// 벨만포드 O(NM)
	static class Node{
		int from, to, time;

		public Node(int from, int to, int time) {
			super();
			this.from = from;
			this.to = to;
			this.time = time;
		}
		
	}
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input11657.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int MAX=10000000;
		Node[] nodes=new Node[M];
		for (int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			int time=Integer.parseInt(st.nextToken());
			nodes[i]=new Node(from, to, time);
		}
		
		long[] dist=new long[N+1];
		Arrays.fill(dist, MAX);
		dist[1]=0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {	// 시작점부터 항상 다 돌기
				Node cur=nodes[j];
				if (dist[cur.from]!=MAX) {
					if (dist[cur.to]>dist[cur.from]+cur.time) {
						dist[cur.to]=dist[cur.from]+cur.time;
						if (i==N-1) {	// N-1번 돌면 끝이지만 한번 더 돌았을때 최솟값 갱신되면 사이클 존재
							System.out.println(-1);
							System.exit(0);
						}
					}
				}
			}
		}
		
		for (int i=2; i<=N; i++) {
			if (dist[i]==MAX) {
				System.out.println(-1);
			} else {
				System.out.println(dist[i]);
			}
		}
		
		br.close();
	}

}
