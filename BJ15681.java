import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ15681 {
// Beakjoon 15681. 트리와 쿼리
	static ArrayList<Integer>[] list;
	static int[] query;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input15681.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int R=Integer.parseInt(st.nextToken());
		int Q=Integer.parseInt(st.nextToken());
		list=new ArrayList[N+1];
		visited=new boolean[N+1];
		query=new int[N+1];
		for (int i=1; i<=N; i++) {
			list[i]=new ArrayList<>();
		}
		for (int i=0; i<N-1; i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		subTree(R);
		
		StringBuilder sb=new StringBuilder();
		for (int i=0; i<Q; i++) {
			sb.append(query[Integer.parseInt(br.readLine())]).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	private static void subTree(int cur) {
		query[cur]=1;
		visited[cur]=true;
		for (int child: list[cur]) {
			if (!visited[child]) {
				subTree(child);
				query[cur]+=query[child];
			}
		}
	}

}
