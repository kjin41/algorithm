import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1743 {
// Baekjoon 1743.음식물 피하기
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1743.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		
		boolean[][] arr=new boolean[N][M];
		int[][] foods=new int[K][2];
		for (int i=0; i<K; i++) {
			st=new StringTokenizer(br.readLine());
			int r=Integer.parseInt(st.nextToken())-1;
			int c=Integer.parseInt(st.nextToken())-1;
			arr[r][c]=true;
			foods[i][0]=r;
			foods[i][1]=c;
		}
		
		int max=0;
		int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
		boolean[][] visited=new boolean[N][M];
		Queue<int[]> queue=new LinkedList<int[]>();
		
		for (int i=0; i<K; i++) {
			if (visited[foods[i][0]][foods[i][1]]) {
				continue;
			}
			
			queue.add(foods[i]);
			visited[foods[i][0]][foods[i][1]]=true;
			int cnt=1;
			while(!queue.isEmpty()) {
				int[] cur=queue.poll();
				for (int d=0; d<4; d++) {
					int nr=cur[0]+dir[d][0];
					int nc=cur[1]+dir[d][1];
					if (nr>=0&&nr<N&&nc>=0&&nc<M&&arr[nr][nc]&&!visited[nr][nc]) {
						queue.add(new int[] {nr,nc});
						visited[nr][nc]=true;
						cnt++;
					}
				}
			}
			if (max<cnt) {
				max=cnt;
			}
		}
		
		System.out.println(max);
		
		br.close();
	}

}
