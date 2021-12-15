import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ4963 {
// Baekjoon 4963. 섬의 개수
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input4963.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int W=Integer.parseInt(st.nextToken());
			int H=Integer.parseInt(st.nextToken());
			if (W==0&&H==0) {
				break;
			}
			
			int[][] arr=new int[H][W];
			boolean[][] visited=new boolean[H][W];
			Queue<int[]> queue=new LinkedList<int[]>();
			for (int i=0; i<H; i++) {
				st=new StringTokenizer(br.readLine());
				for (int j=0; j<W; j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] dir={{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
			int count=0; 
			for (int i=0; i<H; i++) {
				for (int j=0; j<W; j++) {
					if (arr[i][j]==1&&!visited[i][j]) {
						visited[i][j]=true;
						queue.add(new int[] {i,j});
						while(!queue.isEmpty()) {
							int[] cur=queue.poll();
							for (int k=0; k<8; k++) {
								int nr=cur[0]+dir[k][0];
								int nc=cur[1]+dir[k][1];
								if (nr>=0&&nr<H&&nc>=0&&nc<W&&!visited[nr][nc]&&arr[nr][nc]==1) {
									queue.add(new int[] {nr,nc});
									visited[nr][nc]=true;
								}
							}
						}
						count++;
					}
				}
			}
			
			System.out.println(count);
		}
		
		br.close();
	}

}
