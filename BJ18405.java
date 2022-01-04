import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ18405 {
// Baekjoon 18405. 경쟁적 전염
	static class Node{
		int r,c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input18405.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int[][] arr=new int[N][N];
		Queue<Node>[] queue=new Queue[K+1];
		for (int i=0; i<=K; i++) {
			queue[i]=new LinkedList<>();
		}
		
		for (int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				int num=Integer.parseInt(st.nextToken());
				arr[i][j]=num;
				if (num!=0) {
					queue[num].add(new Node(i, j));
				}
			}
		}
		st=new StringTokenizer(br.readLine());
		int S=Integer.parseInt(st.nextToken());
		int X=Integer.parseInt(st.nextToken());
		int Y=Integer.parseInt(st.nextToken());
		
		int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
		
		for (int t=0; t<S; t++) {
			for (int i=1; i<=K; i++) {
				int size=queue[i].size();
				for (int s=0; s<size; s++) {
					Node cur=queue[i].poll();
					for (int d=0; d<4; d++) {
						int nr=cur.r+dir[d][0];
						int nc=cur.c+dir[d][1];
						if (nr>=0&&nr<N&&nc>=0&&nc<N&&arr[nr][nc]==0) {
							arr[nr][nc]=i;
							queue[i].add(new Node(nr, nc));
						}
					}
				}
			}
		}
		
		System.out.println(arr[X-1][Y-1]);
		
		br.close();
	}

}
