import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1303 {
// Baekjoon 1303. 전쟁 - 전투
	static int N, M, white, blue;
	static char[][] arr;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1303.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		arr=new char[N][M];
		visited=new boolean[N][M];
		for (int i=0; i<N; i++) {
			arr[i]=br.readLine().toCharArray();
		}
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (!visited[i][j]) {
					bfs(i, j);
				}
			}
		}
		System.out.println(white+ " "+blue);
		br.close();
	}
	
	private static void bfs(int r, int c) {
		char ch=arr[r][c];
		int count=1;
		int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
		visited[r][c]=true;
		Queue<int[]> queue=new LinkedList<int[]>();
		queue.add(new int[] {r,c});
		while(!queue.isEmpty()) {
			int[] cur=queue.poll();
			for (int d=0; d<4; d++) {
				int nr=cur[0]+dir[d][0];
				int nc=cur[1]+dir[d][1];
				if (nr>=0&&nr<N&&nc>=0&&nc<M&&!visited[nr][nc]&&arr[nr][nc]==ch) {
					visited[nr][nc]=true;
					queue.add(new int[] {nr,nc});
					count++;
				}
			}
		}
		
		if (ch=='B') {
			blue+=count*count;
		} else {
			white+=count*count;
		}
		
	}

}
