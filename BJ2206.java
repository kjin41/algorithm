import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2206 {
// Baekjoon 2206. 벽 부수고 이동하기
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input2206.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		char[][] arr=new char[N][M];
		for (int i=0; i<N; i++) {
			arr[i]=br.readLine().toCharArray();
		}
		int count=1;
		boolean flag=false;
		boolean[][][] visited=new boolean[N][M][2];
		Queue<int[]> queue=new LinkedList<>();
		queue.add(new int[] {0,0,0});
		visited[0][0][0]=true;
		int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
		loop:
		while(!queue.isEmpty()) {
			int size=queue.size();
			for (int s=0; s<size; s++) {
				int[] cur=queue.poll();
				if (cur[0]==N-1&&cur[1]==M-1) {
					flag=true;
					break loop;
				}
				for (int d=0; d<4; d++) {
					int nr=cur[0]+dir[d][0];
					int nc=cur[1]+dir[d][1];
					if (nr>=0&&nr<N&&nc>=0&&nc<M&&!visited[nr][nc][cur[2]]) {
						if (arr[nr][nc]=='0') {
							queue.add(new int[] {nr, nc, cur[2]});
							visited[nr][nc][cur[2]]=true;
						} else if (cur[2]==0&&!visited[nr][nc][1]) {
							queue.add(new int[] {nr, nc, 1});
							visited[nr][nc][1]=true;
						}
					}
				}
			}
			count++;
		}
		
		if (!flag) {
			count=-1;
		}
		System.out.println(count);
		br.close();
	}

}
