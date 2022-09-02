import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA10966 {
// SW Expert Academy 10966. 물놀이를 가자
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input10966.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for (int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			char[][] arr=new char[N][];
			int[][] visited=new int[N][M];
			int wCount=0;
			Queue<int[]> queue=new LinkedList<int[]>();
			for (int i=0; i<N; i++) {
				arr[i]=br.readLine().toCharArray();
				for (int j=0; j<M; j++) {
					if (arr[i][j]=='W') {
						queue.add(new int[] {i,j,0});
						visited[i][j]=1;
						wCount++;
					}
				}
			}
			
			int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
			while(!queue.isEmpty()) {
				int[] cur=queue.poll();
				for (int d=0; d<4; d++) {
					int nr=cur[0]+dir[d][0];
					int nc=cur[1]+dir[d][1];
					if (nr>=0&&nr<N&&nc>=0&&nc<M&&visited[nr][nc]==0&&arr[nr][nc]=='L') {
						visited[nr][nc]=cur[2]+1;
						queue.add(new int[] {nr,nc,cur[2]+1});
					}
				}
			}
			
			int total=-wCount;
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					total+=visited[i][j];
				}
			}
			sb.append(total).append("\n");
		}
		System.out.println(sb);
		br.close();
		
	}

}
