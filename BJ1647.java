import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1647 {
// Baekjoon 1647. 도시 분할 계획
	static class Road implements Comparable<Road>{
		int a, b, c;

		public Road(int a, int b, int c) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public int compareTo(Road o) {
			return this.c-o.c;
		}
		
	}
	
	static Road[] list;
	static int[] parents;
	
	public static int find(int a) {
		if (parents[a]==0) {
			return a;
		}
		return parents[a]=find(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		int pa=find(a);
		int pb=find(b);
		if (pa==pb) {
			return false;
		}
		parents[pa]=pb;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1647.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());	
		int M=Integer.parseInt(st.nextToken());
		list=new Road[M];
		parents=new int[N+1];
		for (int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			list[i]=(new Road(a, b, c));
		}
		
		Arrays.sort(list);
		
		int count=0;
		int max=0;
		long total=0l;
		for (Road r: list) {
			if (union(r.a, r.b)) {
				total+=r.c;
				max=Math.max(max, r.c);
				if (++count==N-1) {
					break;
				}
			}
		}
		
		System.out.println(total-max);
				
		br.close();
	}

}
