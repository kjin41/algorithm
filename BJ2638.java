import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2638 {
// Baekjoon 2638. 치즈
	static int N, M, count=0;
	static int[][] arr;
	static int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input2638.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr=new int[N][M];
		ArrayList<int[]> list=new ArrayList<>();
		for (int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				if (arr[i][j]==1) {
					list.add(new int[] {i,j});
				}
			}
		}

		while(!list.isEmpty()) {
			boolean[][] outside=isOut();
			ArrayList<int[]> erase=new ArrayList<int[]>();
			int size=list.size();
			for (int s=0; s<size; s++) {
				int cnt=0;
				int cr=list.get(s)[0];
				int cc=list.get(s)[1];
				
				for (int d=0; d<4; d++) {
					int nr=cr+dir[d][0];
					int nc=cc+dir[d][1];
					if (nr>=0&&nr<N&&nc>=0&&nc<M&&outside[nr][nc]) {
						cnt++;
					}
				}
				if (cnt>=2) {
					erase.add(new int[] {cr,cc});
					list.remove(s--);
					size--;
				}
			}
			
			for (int[] cur: erase) {
				outside[cur[0]][cur[1]]=true;
				arr[cur[0]][cur[1]]=0;
				
			}
			
			count++;
		}
		
		System.out.println(count);
		
		br.close();
	}
	
	private static boolean[][] isOut() {
		boolean[][] outside=new boolean[N][M];
		Queue<int[]> queue=new LinkedList<int[]>();
		queue.add(new int[] {0,0});
		outside[0][0]=true;
		while(!queue.isEmpty()) {
			int[] cur=queue.poll();
			for (int d=0; d<4; d++) {
				int nr=cur[0]+dir[d][0];
				int nc=cur[1]+dir[d][1];
				if (nr>=0&&nr<N&&nc>=0&&nc<M&&arr[nr][nc]==0&&!outside[nr][nc]) {
					outside[nr][nc]=true;
					queue.add(new int[] {nr,nc});
				}
			}
		}

		return outside;
	}

}
