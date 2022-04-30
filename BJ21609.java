import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ21609 {
// Baekjoon 21609. 상어 중학교
	
	static int N, M, total;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input21609.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr=new int[N][N];
		for (int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			if (!autoPlay()) {
				break;
			}
		}
		
		System.out.println(total);
		br.close();
	}
	
	private static boolean autoPlay() {
		boolean[][] visited=new boolean[N][N];
		int[] max={0,0};
		int[] maxIndex=new int[2];
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (!visited[i][j]&&arr[i][j]>0) {		// 기준 블록 (i,j)
					int[] count=calculate(visited, i, j);
					if ((max[1]<count[1]) 	// 총합 순
							|| (max[1]==count[1]&&max[0]<count[0])	// 무지개블록 순 
							|| (max[1]==count[1]&&max[0]==count[0]&&maxIndex[0]<i)	// 행이 큰 순
							|| (max[1]==count[1]&&max[0]==count[0]&&maxIndex[0]==i&&maxIndex[1]<j)) {	// 열이 큰순
						max=count;
						maxIndex=new int[] {i, j};
					} 
				}
			}
		}
		
		if (max[1]==0) {
			return false;
		}
		total+=max[1]*max[1];

		remove(maxIndex[0], maxIndex[1]);
		gravity();
		rotate();
		gravity();
		
		
		return true;
	}

	private static void rotate() {
		int[][] after=new int[N][N];
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				after[i][j]=arr[j][N-1-i];
			}
		}
		arr=after;
	}

	private static void remove(int r, int c) {
		int num=arr[r][c];
		arr[r][c]=-2;
		boolean[][] visited=new boolean[N][N];
		visited[r][c]=true;
		int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
		Queue<int[]> queue=new LinkedList<int[]>();
		queue.add(new int[] {r, c});
		while(!queue.isEmpty()) {
			int[] cur=queue.poll();
			for (int d=0; d<4; d++) {
				int nr=cur[0]+dir[d][0];
				int nc=cur[1]+dir[d][1];
				if (nr>=0&&nr<N&&nc>=0&&nc<N&&!visited[nr][nc]&&(arr[nr][nc]==num||arr[nr][nc]==0)) {
					queue.add(new int[] {nr,nc});
					visited[nr][nc]=true;
					arr[nr][nc]=-2;
				}
			}
		}
		
	}

	private static void gravity() {
		for (int j=0; j<N; j++) {
			int index=N-1;	// 내려갈 곳
			for (int i=N-1; i>=0; i--) {
				if (arr[i][j]==-1) {	// 검은색 블록은 안움직임
					index=i-1;
				} else if (arr[i][j]>=0){
					if (index==i) {		// 자기 자리일때
						index--;
					} else {			// 이동
						arr[index--][j]=arr[i][j];
						arr[i][j]=-2;
					}
				}
			}
		}
	}

	private static int[] calculate(boolean[][] visited, int r, int c) {
		int count=1;
		int rainbow=0;
		int num=arr[r][c];
		visited[r][c]=true;
		int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
		Queue<int[]> queue=new LinkedList<int[]>();
		Queue<int[]> rainbowQueue=new LinkedList<>();
		queue.add(new int[] {r, c});
		while(!queue.isEmpty()) {
			int[] cur=queue.poll();
			for (int d=0; d<4; d++) {
				int nr=cur[0]+dir[d][0];
				int nc=cur[1]+dir[d][1];
				if (nr>=0&&nr<N&&nc>=0&&nc<N&&(!visited[nr][nc])&&(arr[nr][nc]==num||arr[nr][nc]==0)) {
					queue.add(new int[] {nr,nc});
					visited[nr][nc]=true;
					count++;
					if (arr[nr][nc]==0) {
						rainbow++;
						rainbowQueue.add(new int[] {nr,nc});
					} 
				}
			}
		}
		
		while(!rainbowQueue.isEmpty()) {	// 무지개블록은 재방문 가능
			int[] cur=rainbowQueue.poll();
			visited[cur[0]][cur[1]]=false;
		}
		
		if (count<2) {
			return new int[] {0, 0};
		}
		
		return new int[] {rainbow, count};
	}

}
