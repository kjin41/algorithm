import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ2151_2 {
// Baekjoon 2151. 거울 설치
// bfs
	static int N;
	static char[][] arr;
	
	static class Node implements Comparable<Node>{
		int r, c, d, count;

		public Node(int r, int c, int d, int count) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
			this.count = count;
		}

		@Override
		public int compareTo(Node o) {
			return this.count-o.count;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input2151.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr=new char[N][N];
		int[][] doors=new int[2][2];
		int k=0;
		for (int i=0; i<N; i++) {
			arr[i]=br.readLine().toCharArray();
			for (int j=0; j<N; j++) {
				if (arr[i][j]=='#') {
					doors[k][0]=i;
					doors[k++][1]=j;
				}
			}
		}
		
		boolean[][][] visited=new boolean[N][N][3];	// 설치 X, /, \
		int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
		PriorityQueue<Node> pq=new PriorityQueue<>();
		for (int d=0; d<4; d++) {
			pq.add(new Node(doors[0][0], doors[0][1], d, 0));
		}
		while(!pq.isEmpty()) {
			Node cur=pq.poll();
			k=1;
			while(true) {
				int nr=cur.r+dir[cur.d][0]*k;
				int nc=cur.c+dir[cur.d][1]*k++;
				if (cur.r==doors[1][0]&&cur.c==doors[1][1])	{
					System.out.println(cur.count);
					System.exit(0);;
				}
				if (inRange(nr, nc)) {
					if (arr[nr][nc]=='.')	continue;
					if (!visited[nr][nc][0]) {
						visited[nr][nc][0]=true;
						pq.add(new Node(nr, nc, cur.d, cur.count));	// 거울 설치 안하고 통과
					}
					if (!visited[nr][nc][1]) {
						visited[nr][nc][1]=true;
						pq.add(new Node(nr, nc, changeDir(cur.d, 1), cur.count+1));	// /
					}
					if (!visited[nr][nc][2]) {
						visited[nr][nc][2]=true;
						pq.add(new Node(nr, nc, changeDir(cur.d, 2), cur.count+1));	// \
					}
				} else {
					break;
				}
			}
			
		}
		br.close();
	}

	private static int changeDir(int d, int index) {
		if (index==1) {	// /
			if (d==0)	return 3;
			else if (d==1)	return 2;
			else if (d==3)	return 0;
			else if (d==2)	return 1;
		} else {	// \
			if (d==0)	return 1;
			else if (d==1)	return 0;
			else if (d==2)	return 3;
			else if (d==3)	return 2;
		}
		return d;
	}

	private static boolean inRange(int r, int c) {
		if (r>=0&&r<N&&c>=0&&c<N&&arr[r][c]!='*')	return true;
		return false;
	}

}
