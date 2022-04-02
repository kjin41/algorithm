import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14503 {
// Baekjoon 14503. 로봇 청소기
// BFS 말고 구현으로
	static int N, M, count, cr, cc, cd;
	static int[][] arr;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input14503.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr=new int[N][M];
		visited=new boolean[N][M];
		st=new StringTokenizer(br.readLine());
		cr=Integer.parseInt(st.nextToken());
		cc=Integer.parseInt(st.nextToken());
		cd=Integer.parseInt(st.nextToken());
		for (int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
//		1. 현재 위치를 청소한다.
		count++;
		visited[cr][cc]=true;
		
//		2. 현재 위치에서 현재 방향을 기준으로 왼쪽 방향부터 차례대로 인접한 칸을 탐색한다.
		int flag=0;
		while(flag<5) {
			flag=clean(flag);
			
		}
		System.out.println(count);
		br.close();
	}
	
	private static int clean(int cnt) {
		int[][] dir={{-1,0},{0,1},{1,0},{0,-1}};	// 북 동 남 서 
		int nr=cr+dir[(cd+3)%4][0];		// 왼쪽 방향은 -1 이지만 +4 해서 양수가 나오도록
		int nc=cc+dir[(cd+3)%4][1];

//		a. 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
		if (!visited[nr][nc]&&arr[nr][nc]==0) {
			cd=(cd+3)%4;
			visited[nr][nc]=true;
			cr=nr;
			cc=nc;
			count++;
			return 0;
		} else {
//			b. 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
			if (cnt!=4) {
				cd=(cd+3)%4;
				return cnt+1;
			}
			
//			c. 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
			int br=cr+dir[(cd+2)%4][0];
			int bc=cc+dir[(cd+2)%4][1];
			if (arr[br][bc]==0) {
				cr=br;
				cc=bc;
				return 0;
			} 
//			d. 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
			return cnt+1;
			
		}
	}

}
