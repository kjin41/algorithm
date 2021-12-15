import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ7569 {
// Baekjoon 7569. 토마토
	static int M,N,H;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input7569.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		H=Integer.parseInt(st.nextToken());
		int[][][] arr=new int[H][N][M];
		boolean[][][] visited=new boolean[H][N][M];
		Queue<int[]> queue=new LinkedList<int[]>();
		for (int k=0; k<H; k++) {
			for (int i=0; i<N; i++) {
				st=new StringTokenizer(br.readLine());
				for (int j=0; j<M; j++) {
					int num=Integer.parseInt(st.nextToken());
					arr[k][i][j]=num;
					if (num==1) {
						queue.add(new int[] {k, i, j});
						visited[k][i][j]=true;
					}
				}
			}
		}
		int count=-1;
		int[][] dir=new int[][] {{0,1,0},{0,-1,0},{0,0,1},{0,0,-1},{1,0,0},{-1,0,0}};
		while(!queue.isEmpty()) {
			int size=queue.size();
			for (int s=0; s<size; s++) {
				int[] cur=queue.poll();
				for (int d=0; d<6; d++) {
					int nh=cur[0]+dir[d][0];
					int nr=cur[1]+dir[d][1];
					int nc=cur[2]+dir[d][2];
					if (inRange(nh,nr,nc)&&!visited[nh][nr][nc]&&arr[nh][nr][nc]==0) {
						arr[nh][nr][nc]=1;
						visited[nh][nr][nc]=true;
						queue.add(new int[] {nh,nr,nc});
					}
				}
			}
			count++;
		}
		
		loop:
		for (int k=0; k<H; k++) {
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					if (arr[k][i][j]==0) {
						count=-1;
						break loop;
					}
				}
			}
		}
		
		System.out.println(count);
		br.close();
	}

	private static boolean inRange(int nh, int nr, int nc) {
		if(nh>=0&&nh<H&&nr>=0&&nr<N&&nc>=0&&nc<M) {
			return true;
		}
		return false;
	}

}
