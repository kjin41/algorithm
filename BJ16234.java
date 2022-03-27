import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ16234 {
// Baekjoon 16234. 인구 이동
	static int N, L, R;
	static int[][] arr;
	static int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input16234.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		L=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		arr=new int[N][N];
		
		for (int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int count=0;
		while(true) {
			boolean[][] visited=new boolean[N][N];
			int temp=0;
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					boolean[][] open=new boolean[N][N];
					if (!visited[i][j]) {
						visited[i][j]=true;
						open[i][j]=true;
						temp+=move(visited, i, j, open);
					}
				}
			}
			if (temp==0) {
				break;
			}
			count++;
		}
		
		System.out.println(count);
		
		br.close();
	}
	
	private static int move(boolean[][] visited, int r, int c, boolean[][] open) {
		Queue<int[]> queue=new LinkedList<int[]>();
		Queue<int[]> area=new LinkedList<int[]>();
		queue.add(new int[] {r,c});
		area.add(new int[] {r,c});
		int sum=arr[r][c];
		int count=1;
		while(!queue.isEmpty()) {
			int[] cur=queue.poll();
			for (int d=0; d<4; d++) {
				int nr=cur[0]+dir[d][0];
				int nc=cur[1]+dir[d][1];
				if (inRange(nr, nc)&&!visited[nr][nc]) {
					int diff=Math.abs(arr[cur[0]][cur[1]]-arr[nr][nc]);
					if (diff<L || diff>R) {
						 continue;
					}
					visited[nr][nc]=true;
					open[nr][nc]=true;
					queue.add(new int[] {nr,nc});
					area.add(new int[] {nr,nc});
					sum+=arr[nr][nc];
					count++;
				}
			}
		}
		
		if (count==1) {
			return 0;
		}
		
		int change=sum/count;
		while(!area.isEmpty()) {
			int[] cur=area.poll();
			arr[cur[0]][cur[1]]=change;
		}
		
		return 1;
	}

	private static boolean inRange(int r, int c) {
		if (r>=0&&r<N&&c>=0&&c<N) {
			return true;
		}
		return false;
	}

}
