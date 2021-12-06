import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2382 {
// SW Expert Academy 2382. 미생물 격리
	static int N, K, M, total;
	static int[][] arr;
	static Node[] nodes;
	static boolean[] died;
	static class Node{
		int r, c, n, d;

		public Node(int r, int c, int n, int d) {
			super();
			this.r = r;
			this.c = c;
			this.n = n;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", n=" + n + ", d=" + d + "]";
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input2382.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for (int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			total=0;
			arr=new int[N][N];
			nodes=new Node[K+1];
			died=new boolean[K+1];
			for (int i=1; i<=K; i++) {
				st=new StringTokenizer(br.readLine());
				int r=Integer.parseInt(st.nextToken());
				int c=Integer.parseInt(st.nextToken());
				int n=Integer.parseInt(st.nextToken());
				int d=Integer.parseInt(st.nextToken())-1;
				nodes[i]=new Node(r, c, n, d);
			}
			
			for (int i=0; i<M; i++) {
				move();
			}
			for (int i=1; i<=K; i++) {
				if (!died[i]) {
					total+=nodes[i].n;
				}
			}
			sb.append(total).append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
	}

	private static void move() {
		int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
		int[] sum=new int[K+1];
		for (int i=1; i<=K; i++) {
			if (died[i]) {
				continue;
			}
			int nr=nodes[i].r+dir[nodes[i].d][0];
			int nc=nodes[i].c+dir[nodes[i].d][1];
			if (arr[nr][nc]!=0) {	// 겹칠때
				if (nodes[arr[nr][nc]].n>nodes[i].n) {	// 기존값이 큰경우
					died[i]=true;
					sum[arr[nr][nc]]+=nodes[i].n;
				} else {								// 기존값이 작은 경우
					died[arr[nr][nc]]=true;
					sum[i]+=nodes[arr[nr][nc]].n+sum[arr[nr][nc]];
					arr[nr][nc]=i;
					nodes[i].r=nr;
					nodes[i].c=nc;
				}
			} else {
				nodes[i].r=nr;
				nodes[i].c=nc;
				arr[nr][nc]=i;
				if (inBoundary(nr,nc)) {
					nodes[i].n/=2;
					if (nodes[i].n==0) {
						died[i]=true;
						continue;
					}
					if (nodes[i].d<2) {
						nodes[i].d=1-nodes[i].d;		// 상, 하 방향 바꾸기
					} else {
						nodes[i].d=5-nodes[i].d;		// 좌, 우 빙향 바꾸기
					}
				} 
			}
		}
		
		for (int i=1; i<=K; i++) {
			arr[nodes[i].r][nodes[i].c]=0;
			nodes[i].n+=sum[i];
		}
		
	}

	private static boolean inBoundary(int r, int c) {
		if (r==0||r==N-1||c==0||c==N-1) {
			return true;
		}
		return false;
	}

}
