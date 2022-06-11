import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2468 {
// Baekjoon 2468. 안전 영역
	static int N;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input2468.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr=new int[N][N];
		int max=1;	// 비 안오는 경우도 있음
		for (int i=0; i<N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for (int h=1; h<=100; h++) {
			int count=0;
			boolean[][] visited=new boolean[N][N];
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (!visited[i][j]) {
						visited[i][j]=true;
						if (arr[i][j]>h) 
							count+=safeArea(i, j, h, visited);
						
					}
				}
			}
			if (count==0)	break;
			if (max<count)	max=count;
		}
		
		System.out.println(max);
		br.close();
	}

	private static int safeArea(int r, int c, int h, boolean[][] visited) {
		int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
		Queue<int[]> queue=new LinkedList<int[]>();
		queue.add(new int[] {r, c, arr[r][c]});
		while(!queue.isEmpty()) {
			int[] cur=queue.poll();
			for (int d=0; d<4; d++) {
				int nr=cur[0]+dir[d][0];
				int nc=cur[1]+dir[d][1];
				if (nr>=0&&nr<N&&nc>=0&&nc<N&&!visited[nr][nc]) {
					visited[nr][nc]=true;
					if (arr[nr][nc]>h)
						queue.add(new int[] {nr,nc,arr[nr][nc]});
				}
			}
		}
		
		
		return 1;
		
	}

}
