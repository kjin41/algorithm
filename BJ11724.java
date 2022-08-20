import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11724 {
// Baekjoon 11724. 연결 요소의 개수
	static int N, M;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input11724.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		parent=new int[N+1];
		for (int i=1; i<=N; i++) {
			parent[i]=i;
		}
		for (int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			union(a,b);
		}
		
		boolean[] root=new boolean[N+1];
		for (int i=1; i<=N; i++) {
			root[find(i)]=true;	
		}
		
		int count=0;
		for (int i=1; i<=N; i++) {
			if (root[i])	count++;	
		}
		
		System.out.println(count);
		br.close();
	}

	private static void union(int a, int b) {
		int pa=find(a);
		int pb=find(b);
		if (pa!=pb)	parent[pa]=pb;
		return;
	}

	private static int find(int a) {
		if (parent[a]==a)	return a;
		return parent[a]=find(parent[a]);
	}

}
