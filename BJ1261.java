import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1261 {
// Baekjoon 1261. 알고스팟
	static class Node implements Comparable<Node>{
		int r, c, count;

		
		public Node(int r, int c, int count) {
			super();
			this.r = r;
			this.c = c;
			this.count = count;
		}


		@Override
		public int compareTo(Node o) {
			return this.count-o.count;
		}
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1261.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int M=Integer.parseInt(st.nextToken());
		int N=Integer.parseInt(st.nextToken());
		char[][] arr=new char[N][M];
		for (int i=0; i<N; i++) {
			arr[i]=br.readLine().toCharArray();
		}
		
		int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
		boolean[][] visited=new boolean[N][M];
		PriorityQueue<Node> pq=new PriorityQueue<>();
		pq.add(new Node(0, 0, 0));
		visited[0][0]=true;
		while(true) {
			Node cur=pq.poll();
			if (cur.r==N-1&&cur.c==M-1) {
				System.out.println(cur.count);
				break;
			}
			for (int d=0; d<4; d++) {
				int nr=cur.r+dir[d][0];
				int nc=cur.c+dir[d][1];
				if (nr>=0&&nr<N&&nc>=0&&nc<M&&!visited[nr][nc]) {
					if (arr[nr][nc]=='0') {
						pq.add(new Node(nr,nc,cur.count));
					} else {
						pq.add(new Node(nr,nc,cur.count+1));
					}
					visited[nr][nc]=true;
				}
			}
		}
		
		br.close();
	}

}
