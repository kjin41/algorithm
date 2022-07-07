import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ14442 {
// Baekjoon 14442. 벽 부수고 이동하기 2
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input14442.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		char[][] arr=new char[N][M];
		boolean[][][] visited=new boolean[N][M][K+1];
		for (int i=0; i<N; i++) {
			arr[i]=br.readLine().toCharArray();
		}
		
		int count=0;
		
		Queue<int[]> queue=new LinkedList<int[]>();
		queue.add(new int[] {0,0,0});	// N, M, K
		visited[0][0][0]=true;
		int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
		while(!queue.isEmpty()) {
			int size=queue.size();
			count++;
			for (int s=0; s<size; s++) {
				int[] cur=queue.poll();
				if (cur[0]==N-1&&cur[1]==M-1) {
					System.out.println(count);
					System.exit(0);
				}
				for (int d=0; d<4; d++) {
					int nr=cur[0]+dir[d][0];
					int nc=cur[1]+dir[d][1];
					int nk=cur[2];
					if (nr>=0&&nr<N&&nc>=0&&nc<M) {
						if (arr[nr][nc]=='0'&&!visited[nr][nc][nk]) {
							visited[nr][nc][nk]=true;
							queue.add(new int[] {nr,nc,nk});
						} else if (nk<K&&!visited[nr][nc][nk+1]){
							visited[nr][nc][nk+1]=true;
							queue.add(new int[] {nr,nc,nk+1});
						}
					}
				}
			}
		}
		
		System.out.println(-1);
		
		
		br.close();
	}

}
