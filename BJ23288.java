package day211025;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ23288 {
// Baekjoon 23288. 주사위 굴리기2
	static int N, M, K, result;
	static int[][] arr, count;
	static int[][] d= {{-1,0},{0,1},{1,0},{0,-1}};
	static int[] dice= {1,6,2,3,5,4, 1,0,0};	// 상 하 북 동 남 서  방향: 북동남서 0123 위치
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input23288.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		arr=new int[N][M];
		count=new int[N][M];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				int cnt=0;
				boolean[][] visited=new boolean[N][M];
				Queue<int[]> queue= new LinkedList<int[]>();
				if (!visited[i][j]) {
					cnt++;
					visited[i][j]=true;
					queue.add(new int[] {i, j, arr[i][j]});
				}
				while(!queue.isEmpty()) {
					int[] cur=queue.poll();
					for (int k=0; k<4; k++) {
						int nr=cur[0]+d[k][0];
						int nc=cur[1]+d[k][1];
						int num=cur[2];
						if (inRange(nr, nc)&&!visited[nr][nc]&&num==arr[nr][nc]) {
							visited[nr][nc]=true;
							queue.add(new int[] {nr,nc,num});
							cnt++;
						}
					}
					
				}
				count[i][j]=cnt;
			}
		}
	
		for (int i=0; i<K; i++) {
			roll();
			int r=dice[7];
			int c=dice[8];
			result+=arr[r][c]*count[r][c];
			rotate();
		}
		
		System.out.println(result);
		br.close();
		
	}

	private static void rotate() {
		if (dice[1]>arr[dice[7]][dice[8]]) {
			dice[6]=(dice[6]+1)%4;
		} else if (dice[1]<arr[dice[7]][dice[8]]) {
			dice[6]=(dice[6]-1+4)%4;
		}
	}

	private static void roll() {
		int dir=dice[6];
		if (dir==0) {	// 북쪽
			if (inRange(dice[7]+d[dir][0], dice[8]+d[dir][1])) {	// 북쪽으로 이동
				swap(0, 4, 1, 2);
			} else {	// 남쪽으로 이동
				swap(0, 2, 1, 4);
				dir=2-dir;
			}
		} else if (dir==1) {	// 동쪽
			if (inRange(dice[7]+d[dir][0], dice[8]+d[dir][1])) {	// 동쪽으로 이동
				swap(0, 5, 1, 3);
			} else {	// 서쪽으로 이동
				swap(0, 3, 1, 5);
				dir=4-dir;
			}
		} else if (dir==2) {	// 남쪽
			if (inRange(dice[7]+d[dir][0], dice[8]+d[dir][1])) {	// 남쪽으로 이동
				swap(0, 2, 1, 4);
			} else {	// 북쪽으로 이동
				swap(0, 4, 1, 2);
				dir=2-dir;
			}
		} else {	// 서쪽
			if (inRange(dice[7]+d[dir][0], dice[8]+d[dir][1])) {	// 동쪽으로 이동
				swap(0, 3, 1, 5);
			} else {	// 동쪽으로 이동
				swap(0, 5, 1, 3);
				dir=4-dir;
			}
		} 
		
		dice[6]=dir;
		dice[7]+=d[dir][0];
		dice[8]+=d[dir][1];
	}


	private static void swap(int a, int b, int c, int d) {
		int temp=dice[a];
		dice[a]=dice[b];
		dice[b]=dice[c];
		dice[c]=dice[d];
		dice[d]=temp;
	}
	
	private static boolean inRange(int nr, int nc) {
		if (nr>=0&&nr<N&&nc>=0&&nc<M) {
			return true;
		}
		return false;
	}

}
