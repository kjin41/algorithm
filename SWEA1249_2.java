import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class SWEA1249_2 {
// SW Expert Academy 1249. 보급로
// 우선순위큐
	
	static class Node implements Comparable<Node>{
		int r, c, sum;

		public Node(int r, int c, int sum) {
			super();
			this.r = r;
			this.c = c;
			this.sum = sum;
		}

		@Override
		public int compareTo(Node o) {	// 총합이 낮은 순으로 정렬
			return this.sum-o.sum;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1249.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for (int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			int N=Integer.parseInt(br.readLine());
			char[][] arr=new char[N][N];
			for (int i=0; i<N; i++) {	// 입력 받기
				arr[i]=br.readLine().toCharArray();
			}
			
			PriorityQueue<Node> pq=new PriorityQueue<>();
			boolean[][] visited=new boolean[N][N];
			visited[0][0]=true;
			pq.add(new Node(0, 0, 0));
			
			int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
			
			while(!pq.isEmpty()) {
				Node cur=pq.poll();
				if (cur.r==N-1&&cur.c==N-1) {	// 목적지 도달
					sb.append(cur.sum).append("\n");
					break;
				}
				for (int d=0; d<4; d++) {	// 사방 탐색
					int nr=cur.r+dir[d][0];
					int nc=cur.c+dir[d][1];
					if (nr>=0&&nr<N&&nc>=0&&nc<N && !visited[nr][nc]) {
						pq.add(new Node(nr, nc, cur.sum+arr[nr][nc]-'0'));
						visited[nr][nc]=true;
					}
				}
			}
		}
		
		System.out.println(sb);
		br.close();
	}

}
