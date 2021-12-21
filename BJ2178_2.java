import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2178_2 {
// Baekjoon 2178. 미로 탐색
// bfs
	
//	static int N, M, min=100000;
//	static char[][] arr;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input2178.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		char[][] arr=new char[N][M];
		boolean[][] visited=new boolean[N][M];
		for (int i=0; i<N; i++) {
			arr[i]=br.readLine().toCharArray();
		}

		int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
		Queue<int[]> queue=new LinkedList<int[]>();
		queue.add(new int[] {0, 0});
		visited[0][0]=true;
		int count=1;
		
		loop:
		while(!queue.isEmpty()) {
			count++;
			int size=queue.size();
			for (int s=0; s<size; s++) {
				int[] cur=queue.poll();
				for (int d=0; d<4; d++) {
					int nr=cur[0]+dir[d][0];
					int nc=cur[1]+dir[d][1];
					if (nr==N-1&&nc==M-1) {
						break loop;
					}
					if (nr>=0&&nr<N&&nc>=0&&nc<M&&!visited[nr][nc]&&arr[nr][nc]=='1') {
						queue.add(new int[] {nr,nc});
						visited[nr][nc]=true;
					}
				}
			}
		}
		
		System.out.println(count);
		
		br.close();
	}


}
