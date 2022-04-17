import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ20058 {
// Baekjoon 20058. 마법사 상어와 파이어스톰
	
	static int N, Q, NS, total, max;
	static int[][] arr;
	static int[] level;
	static int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input20058.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		Q=Integer.parseInt(st.nextToken());
		NS=(int)Math.pow(2, N);
		arr=new int[NS][NS];
		for (int i=0; i<NS; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j=0; j<NS; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		level=new int[Q];
		st=new StringTokenizer(br.readLine());
		for (int i=0; i<Q; i++) {
			level[i]=Integer.parseInt(st.nextToken());
		}
		
		for (int i=0; i<Q; i++) {
			firestorm(i);				
		}
		
		// 빙하 총합 계산
		for (int i=0; i<NS; i++) {
			for (int j=0; j<NS; j++) {
				total+=arr[i][j];
			}
		}

		// 가장 큰 덩어리 찾기
		boolean[][] visited=new boolean[NS][NS];
		for (int i=0; i<NS; i++) {
			for (int j=0; j<NS; j++) {
				if (!visited[i][j]&&arr[i][j]!=0) {
					int temp=findConnect(visited, i, j);
					max=Math.max(max, temp);
				}
			}
		}
		
		System.out.println(total);
		System.out.println(max);
		
		
		br.close();
	}
	
	private static void firestorm(int l) {
		int ls=(int)Math.pow(2, level[l]);
		for (int i=0; i<NS; i+=ls) {
			for (int j=0; j<NS; j+=ls) {
				rotation(i, j, ls);
			}
		}
		
		// 빙하 녹기
		ArrayList<int []> melt=new ArrayList<>();	// 녹는 부분 저장
		for (int i=0; i<NS; i++) {
			for (int j=0; j<NS; j++) {
				int flag=0;
				if (arr[i][j]==0) {
					continue;
				}
				for (int d=0; d<4; d++) {
					int nr=i+dir[d][0];
					int nc=j+dir[d][1];
					
					if (inRange(nr, nc)&&arr[nr][nc]!=0) {
						flag++;
					}
				}
				if (flag<3) {
					melt.add(new int[] {i, j});
				}
			}
		}
		
		
		for (int[] m: melt) {	// 한번에 녹이기
			arr[m[0]][m[1]]--;
		}
		
	}

	private static int findConnect(boolean[][] visited, int r, int c) {
		Queue<int[]> queue=new LinkedList<int[]>();
		queue.add(new int[] {r,c});
		visited[r][c]=true;
		int count=1;
		while(!queue.isEmpty()) {
			int[] cur=queue.poll();
			for (int d=0; d<4; d++) {
				int nr=cur[0]+dir[d][0];
				int nc=cur[1]+dir[d][1];
				
				if (inRange(nr, nc)&&arr[nr][nc]!=0&&!visited[nr][nc]) {
					queue.add(new int[] {nr,nc});
					visited[nr][nc]=true;
					count++;
				}
			}
		}
		
		return count;
	}

	private static boolean inRange(int nr, int nc) {
		if (nr>=0&&nr<NS&&nc>=0&&nc<NS) {
			return true;
		}
		return false;
	}

	private static void rotation(int r, int c, int ls) {
		if (ls<2) {
			return;
		}
		
		int[][] pos={{r,c},{r,c+ls-1},{r+ls-1,c+ls-1},{r+ls-1,c}};
		for (int i=0; i<ls-1; i++) {
			int temp=arr[pos[0][0]][pos[0][1]];
			arr[pos[0][0]][pos[0][1]]=arr[pos[3][0]][pos[3][1]];
			arr[pos[3][0]][pos[3][1]]=arr[pos[2][0]][pos[2][1]];
			arr[pos[2][0]][pos[2][1]]=arr[pos[1][0]][pos[1][1]];
			arr[pos[1][0]][pos[1][1]]=temp;
			pos[0][1]++;
			pos[1][0]++;
			pos[2][1]--;
			pos[3][0]--;
		}
		rotation(r+1, c+1, ls-2);	// 한칸 안쪽 부분
	}

}
