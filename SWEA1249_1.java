import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class SWEA1249_1 {
// SW Expert Academy 1249. 보급로
// DFS
// 백트래킹
// 메모이제이션
	
	static char[][] arr;
	static int N, min;
	static int[][] memo;	// 메모이제이션
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1249.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for (int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			N=Integer.parseInt(br.readLine());
			min=100000;
			arr=new char[N][N];
			for (int i=0; i<N; i++) {	// 입력 받기
				arr[i]=br.readLine().toCharArray();
			}
			
			memo=new int[N][N];
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {	// 최대값 세팅
					memo[i][j]=100000;
				}
			}
			
			memo[0][0]=0;
			dfs(0, 0, 0);

			sb.append(min).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	private static void dfs(int r, int c, int sum) {
		if (r==N-1&&c==N-1) {	// 목적지 도달
			min=Math.min(min, sum);
			return;
		}
		
		if (sum>min) {
			return;
		}
		
		if (sum>memo[r][c]) {
			return;
		}

		int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
		for (int d=0; d<4; d++) {	// 사방 탐색
			int nr=r+dir[d][0];
			int nc=c+dir[d][1];
			if (nr>=0&&nr<N&&nc>=0&&nc<N && memo[nr][nc]>arr[nr][nc]-'0'+sum) {
				memo[nr][nc]=arr[nr][nc]-'0'+sum;	// 메모 업데이트
				dfs(nr,nc,memo[nr][nc]);
			}
		}
		
	}

}
