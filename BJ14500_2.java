import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ14500_2 {
// Baekjoon 14500. 테트로미노
	static int[][] arr;
	static int N,M,result;
	static boolean[][] order;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input14500.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr=new int[N][M];
		order=new boolean[N][M];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				tetromino(i, j);
				order[i][j]=true;
			}
		}
		
		System.out.println(result);
		br.close();
	}
	
	static class Node implements Comparable<Node>{
		int r, c, n;

		public Node(int r, int c, int n) {
			super();
			this.r = r;
			this.c = c;
			this.n = n;
		}

		@Override
		public int compareTo(Node o) {
			return o.n-this.n;
		}
		
	}
	
	private static void tetromino(int r, int c) {
		int sum=0;
		int cnt=0;
		int[][] d= {{1,0},{-1,0},{0,1},{0,-1}};
//		boolean[][] visited=new boolean[N][M];	// 반복 돌때마다 생성시 시간 많이 걸림 500*500일때 6초정도
		PriorityQueue<Node> pq=new PriorityQueue<>();
		Queue<Node> queue=new LinkedList<>();
		pq.add(new Node(r, c, arr[r][c]));
		queue.add(new Node(r, c, arr[r][c]));
		order[r][c]=true;
		while(cnt++<4&&!pq.isEmpty()) {
			Node cur=pq.poll();
			sum+=cur.n;
			for (int k=0; k<4; k++) {
				int nr=cur.r+d[k][0];
				int nc=cur.c+d[k][1];
				if (nr>=0&&nr<N&&nc>=0&&nc<M&&!order[nr][nc]) {
					order[nr][nc]=true;
					pq.add(new Node(nr, nc, arr[nr][nc]));
					queue.add(new Node(nr, nc, arr[nr][nc]));
				}
			}
		}
		if (result<sum) {
			result=sum;
		}
		
		while(!queue.isEmpty()) {
			Node cur=queue.poll();
			order[cur.r][cur.c]=false;
		}
	}
}
