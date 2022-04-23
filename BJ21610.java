import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ21610 {
// Baekjoon 21610. 마법사 상어와 비바라기
	static int[][] arr;
	static int[][] dir={{0,0},{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
	static int N, M;
	static int[] D, S;
	static Queue<int []> cloud=new LinkedList<int[]>();
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input21610.txt"));
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
		
		D=new int[M];
		S=new int[M];
		for (int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			D[i]=Integer.parseInt(st.nextToken());
			S[i]=Integer.parseInt(st.nextToken());
		}
		
		cloud.add(new int[] {N-1, 0});
		cloud.add(new int[] {N-1, 1});
		cloud.add(new int[] {N-2, 0});
		cloud.add(new int[] {N-2, 1});
		
		for (int i=0; i<M; i++) {
			bibaragi(D[i], S[i]);
		}
		
		int result=0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				result+=arr[i][j];
			}
		}
		
		System.out.println(result);
		br.close();
	}

	private static void bibaragi(int d, int s) {
		int size=cloud.size();
//		구름 이동 및 물 양 증가
		for (int i=0; i<size; i++) {
			int[] cur=cloud.poll();
			int nr=(cur[0]+dir[d][0]*s+50*N)%N;
			int nc=(cur[1]+dir[d][1]*s+50*N)%N;
			cloud.add(new int[] {nr,nc});
			arr[nr][nc]++;
		}
		
//		물복사버그
		int[][] curCloud=new int[size][2];	// 이동한 구름 위치 저장을 위해
		for (int i=0; i<size; i++) {
			int[] cur=cloud.poll();
			curCloud[i]=cur;
			int count=0;
			for (d=2; d<=8; d+=2) {		// 대각선 방향만
				int nr=cur[0]+dir[d][0];
				int nc=cur[1]+dir[d][1];
				if (nr>=0&&nr<N&&nc>=0&&nc<N&&arr[nr][nc]>0) {
					count++;
				}
			}
			cloud.add(new int[] {cur[0], cur[1], count});	// 배열 위치와 증가할 물의 양
		}
		
//		바구니에 물 증가
		for (int i=0; i<size; i++) {
			int[] cur=cloud.poll();
			arr[cur[0]][cur[1]]+=cur[2];
		}
		
//		구름 있는 곳 채우기 
		for (int i=0; i<N; i++) {
			loop:
			for (int j=0; j<N; j++) {
				if (arr[i][j]>=2) {
					for (int k=0; k<size; k++) {
						if (curCloud[k][0]==i&&curCloud[k][1]==j) {	// 이동한 구름이 있는 곳 제외
							continue loop;
						}
					}
					cloud.add(new int[] {i,j});
					arr[i][j]-=2;
				}
			}
		}
	}

}
