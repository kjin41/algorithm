import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ16933 {
// Baekjoon 16933. 벽 부수고 이동하기 3
	static class Node{
		int r,c,k;
		boolean t;

		public Node(int r, int c, int k, boolean t) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;
			this.t = t;
		}
		
	}
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input16933.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		char[][] arr=new char[N][M];
		boolean[][][] visited=new boolean[N][M][K+1];
		for (int i=0; i<N; i++) {
			arr[i]=br.readLine().toCharArray();
		}
		
		Queue<Node> queue=new LinkedList<Node>();
		queue.add(new Node(0,0,0,true));	// N, M, K, day/night
		visited[0][0][0]=true;
		int count=0;
		int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
		while(!queue.isEmpty()) {
			long size=queue.size();
			count++;
			for (int s=0; s<size; s++) {
				Node cur=queue.poll();
				if (cur.r==N-1 && cur.c==M-1) {
					System.out.println(count);
					System.exit(0);
				}
				for (int d=0; d<4; d++) {
					int nr=cur.r+dir[d][0];
					int nc=cur.c+dir[d][1];
					int k=cur.k;
					boolean t=cur.t;
					if (nr>=0&&nr<N&&nc>=0&&nc<M) {		// 범위 안
						if (k<K&&arr[nr][nc]=='1'&&!visited[nr][nc][k+1]) { 	// 벽
							if (t) {	// 낮 
								visited[nr][nc][k+1]=true;
								queue.add(new Node(nr,nc,k+1,!t));
							} else {	// 밤
								queue.add(new Node(cur.r,cur.c,k,!t));
							}
						} else if (arr[nr][nc]=='0'&&!visited[nr][nc][k]) {	 	// 길
							visited[nr][nc][k]=true;
							queue.add(new Node(nr,nc,k,!t));
						}
					}
				}
			}
		}
		
		System.out.println(-1);
		br.close();
	}

}