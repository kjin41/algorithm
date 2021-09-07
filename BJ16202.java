import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16202 {
// Baekjoon 16202. MST게임
// MST kruskal
	static class Edge {
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
	}
	
	static Edge[] edgeList;
	static int N, M, K;
	static int parents[];
	
	private static void make() {
		parents = new int[N+1];
		for (int i=1; i<=N; i++) {
			parents[i]=i;
		}
	}
	
	private static int find(int p) {
		if (parents[p]==p) return p;
		return parents[p] = find(parents[p]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot==bRoot)	return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input16202.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		edgeList = new Edge[M];
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(start, end, i+1);
			
		}
		
		StringBuilder sb = new StringBuilder();
		int i=0;
		for (i=0; i<K; i++) {
			make();
			boolean flag=false;
			int cnt=0, result=0;
			for (int j=i; j<M; j++) {
//				System.out.println(j);
				Edge e = edgeList[j];
				if (union(e.start, e.end)) {
					result+=e.weight;
					if (++cnt==N-1) {
						flag=true;
						break;
					}
//					System.out.println(result);
				}
			}
			
			if (flag) {
				sb.append(result).append(" ");
			} else {
				break;
			}
//			System.out.println(sb);
		}
		
		for (int j=i; j<K; j++) {
			sb.append("0 ");
			
		}
		
		System.out.println(sb);
	}

}
