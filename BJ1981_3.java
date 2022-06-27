import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1981_3 {
// Baekjoon 1981. 배열에서 이동
// 이분탐색
	
	static int N;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1981.txt"));
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr=new int[N][N];
		for (int i=0; i<N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int l=0, r=200;
		while(l<=r) {
			int mid=(l+r)/2;
			if (reach(mid))	r=mid-1;
			else l=mid+1;
		}
		
		System.out.println(l);
		br.close();
	}

	private static boolean reach(int diff) {
		int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
		
		for (int i=0; i+diff<=200; i++) {
			int min=i;
			int max=i+diff;
			if (arr[0][0]<min||arr[0][0]>max)	continue;
			boolean[][] visited=new boolean[N][N];
			Queue<int[]> queue=new LinkedList<int[]>();
			queue.add(new int[] {0,0});
			visited[0][0]=true;
			while(!queue.isEmpty()) {
				int[] cur=queue.poll();
				if (cur[0]==N-1&&cur[1]==N-1) {
					return true;
				}
				
				for (int d=0; d<4; d++) {
					int nr=cur[0]+dir[d][0];
					int nc=cur[1]+dir[d][1];
					if (nr>=0&&nr<N&&nc>=0&&nc<N&&!visited[nr][nc]
							&&arr[nr][nc]>=min&&arr[nr][nc]<=max) {
						queue.add(new int[] {nr,nc});
						visited[nr][nc]=true;;
					}
				}
			}
		}
		
		return false;
	}

}
