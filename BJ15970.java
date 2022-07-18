import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ15970 {
// Baekjoon 15970. 화살표 그리기
	
	static class Node implements Comparable<Node>{
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Node o) {
			return this.x-o.x;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input15970.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		Node[] nodes=new Node[N];
		
		for (int i=0; i<N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			nodes[i]=new Node(x, y);
		}
		
		Arrays.sort(nodes);
		ArrayList<Integer>[] list=new ArrayList[N+1];
		for (int i=0; i<=N; i++) {
			list[i]=new ArrayList<>();
		}
		for (int i=0; i<N; i++) {
			list[nodes[i].y].add(nodes[i].x);
		}
		
		int dist=0;
		for (ArrayList<Integer> l: list) {
			int size=l.size();
			if (size==0)	continue;
			dist+=l.get(1)-l.get(0);
			for (int i=1; i<size-1; i++) {
				dist+=Math.min(l.get(i+1)-l.get(i), l.get(i)-l.get(i-1));
			}
			dist+=l.get(size-1)-l.get(size-2);
		}
		
		System.out.println(dist);
		
		br.close();
	}

}
