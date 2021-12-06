import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1012 {
// Baekjoon 1012. 유기농 배추
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1012.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int M=Integer.parseInt(st.nextToken());
			int N=Integer.parseInt(st.nextToken());
			int K=Integer.parseInt(st.nextToken());
			boolean[][] arr=new boolean[N][M];
			for (int i=0; i<K; i++) {
				st=new StringTokenizer(br.readLine());
				int c=Integer.parseInt(st.nextToken());
				int r=Integer.parseInt(st.nextToken());
				arr[r][c]=true;
			}
			
			int total=0;
			int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					if (!arr[i][j]) {
						continue;
					}
					Queue<int[]> queue=new LinkedList<int[]>();
					queue.add(new int[] {i, j});
					while(!queue.isEmpty()) {
						int[] cur=queue.poll();
						for (int k=0; k<4; k++) {
							int nr=cur[0]+d[k][0];
							int nc=cur[1]+d[k][1];
							if (nr>=0&&nr<N&&nc>=0&&nc<M&&arr[nr][nc]) {
								queue.add(new int[] {nr,nc});
								arr[nr][nc]=false;
							}
						}
					}
					total++;
				}
			}
			System.out.println(total);
		}
		
		br.close();
	}

}
