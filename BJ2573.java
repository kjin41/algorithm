import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2573 {
// Baekjoon 2573. 빙산
	
	static int N,M, count=0, result=0;
	static int[][] arr;
	static class Point {
		int r,c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
	static ArrayList<Point> list=new ArrayList<>();
	static boolean ice[][];
	static int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input2573.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr=new int[N][M];
		for (int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				if (arr[i][j]!=0) {
					list.add(new Point(i, j));
					count++;
					
				}
			}
		}
		
		while(count!=0&&count==countIce()) {	// 전체 빙산수와 연결된 빙산수가 같으면 진행
			result++;
			melting();
		}
		
		if (count==0) {		// 연결된 빙산이 계속 한개였다가 다 녹음
			result=0;
		}
		
		System.out.println(result);
		
		
		
		br.close();
	}

	private static void melting() {
		int[] amount=new int[list.size()];	// 녹는 높이 담는 배열
		for (int i=0; i<list.size(); i++) {
			int temp=0;
			for (int d=0; d<4; d++) {
				int nr=list.get(i).r+dir[d][0];
				int nc=list.get(i).c+dir[d][1];
				if (inRange(nr,nc)&&arr[nr][nc]<=0) {
					temp++;
				}
			}
			amount[i]=temp;
		}
		
		for (int i=list.size()-1; i>=0; i--) {	// 뒤에서부터 다 녹으면 리스트에서 지우기
			Point cur=list.get(i);
			arr[cur.r][cur.c]-=amount[i];
			if (arr[cur.r][cur.c]<=0) {
				list.remove(i);
				count--;
			}
		}
		
	}

	private static int countIce() {
		Point start=list.get(0);	// 최초 빙산으로부터
		Queue<Point> queue=new LinkedList<Point>();
		boolean[][] visited=new boolean[N][M];
		queue.add(start);
		visited[start.r][start.c]=true;
		int cnt=1;
		while(!queue.isEmpty()) {
			Point cur=queue.poll();
			for (int d=0; d<4; d++) {
				int nr=cur.r+dir[d][0];
				int nc=cur.c+dir[d][1];
				if (inRange(nr,nc)&&!visited[nr][nc]&&arr[nr][nc]>0) {	// 연결되어있는 빙산 수 세기
					queue.add(new Point(nr, nc));
					visited[nr][nc]=true;
					cnt++;
				}
			}
			
		}
		return cnt;
	}

	private static boolean inRange(int nr, int nc) {
		if (nr>=0&&nr<N&&nc>=0&&nc<M) {
			return true;
		}
		return false;
	}

}
