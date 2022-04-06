import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ17244 {
// Baekjoon 17244. 아 맞다 우산
// 비트마스크
	static class Node {
		int r, c, mask;

		public Node(int r, int c, int mask) {
			super();
			this.r = r;
			this.c = c;
			this.mask = mask;
		}
		
	}
	static Node[] nodes=new Node[5];
	static int things=0;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input17244.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int M=Integer.parseInt(st.nextToken());
		int N=Integer.parseInt(st.nextToken());
		char[][] arr=new char[N][M];
		int[] start=new int[2];
		for (int i=0; i<N; i++) {
			arr[i]=br.readLine().toCharArray();
			for (int j=0; j<M; j++) {
				if (arr[i][j]=='S') {
					start[0]=i;
					start[1]=j;
				} else if (arr[i][j]=='X') {
					nodes[things++]=new Node(i, j, 0);
				}
			}
		}
		int bits=(int)Math.pow(2, things)-1;	// 비트마스크 필요한 총 개수 
		boolean[][][] visited=new boolean[N][M][bits+1];
		Queue<Node> queue=new LinkedList<Node>();
		queue.add(new Node (start[0], start[1], 0));
		visited[start[0]][start[1]][0]=true;
		int count=0;
		int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
		loop:
		while(!queue.isEmpty()) {
			int size=queue.size();
			for (int s=0; s<size; s++) {
				Node cur=queue.poll();
				if (arr[cur.r][cur.c]=='E'&&cur.mask==bits) {
					break loop;
				}
				for (int d=0; d<4; d++) {
					int nr=cur.r+dir[d][0];
					int nc=cur.c+dir[d][1];
					int mask=cur.mask;
					if (nr>=0&&nr<N&&nc>=0&&nc<M&&arr[nr][nc]!='#'&&!visited[nr][nc][mask]) {
						if (arr[nr][nc]=='X') {
							int m=indexOfNode(nr,nc);
							if ((mask&1<<m)==0) {	// 해당 물건이 없는 경우
								queue.add(new Node (nr,nc,mask|1<<m));
								visited[nr][nc][mask|1<<m]=true;
								continue;
							}
						}
						// X가 아니거나 해당 물건을 갖고 있는 경우
						queue.add(new Node (nr,nc,mask));
						visited[nr][nc][mask]=true;
						
					}
					
				}
			}
			count++;
		}
		
		System.out.println(count);
		br.close();
	}

	private static int indexOfNode(int r, int c) {
		for (int i=0; i<things; i++) {
			if (nodes[i].r==r&&nodes[i].c==c) {
				return i;
			}
		}
		
		return 0;
	}

}
