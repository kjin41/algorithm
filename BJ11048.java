import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11048 {
// Baekjoon 11048. 이동하기
// DFS
// 시간초과...ㅠ
	
	static int N,M,max;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input11048.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr=new int[N][M];
		for (int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0, arr[0][0]);
		
		System.out.println(max);
		
		br.close();
	}
	
	private static void dfs(int r, int c, int sum) {
		if (r==N-1&&c==M-1) {
			if (max<sum) {
				max=sum;
			}
			return;
		}
		
		int[][] dir= {{1,0},{0,1},{1,1}};
		for (int d=0; d<3; d++) {
			int nr=r+dir[d][0];
			int nc=c+dir[d][1];
			if (nr>=0&&nr<N&&nc>=0&&nc<M) {
				dfs(nr,nc,sum+arr[nr][nc]);
			}
		}
	}

}
