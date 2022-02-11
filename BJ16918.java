import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ16918 {
// Baekjoon 16918. 봄버맨
	static int R, C, N;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input16918.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		char[][] arr=new char[R][C];
		
		for (int i=0; i<R; i++) {
			arr[i]=br.readLine().toCharArray();
		}
		
		
		StringBuilder sb=new StringBuilder();
		int count=1;
		if (N%2==0) {
			for (int i=0; i<R; i++) {
				for (int j=0; j<C; j++) {
					arr[i][j]='O';
				}
			}
		} else {
			while(count!=N) {
				bomb(arr);
				count+=2;
			}
		}
		
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	private static void bomb(char[][] arr) {
		ArrayList<int[]> list=new ArrayList<>();
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				if (arr[i][j]=='O') {
					list.add(new int[] {i, j});
					
				}
			}
		}
		
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				arr[i][j]='O';
				
			}
		}
		
		int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
		
		for (int[] cur:list) {
			arr[cur[0]][cur[1]]='.';
			for (int d=0; d<4; d++) {
				int nr=cur[0]+dir[d][0];
				int nc=cur[1]+dir[d][1];
				if (nr>=0&&nr<R&&nc>=0&&nc<C) {
					arr[nr][nc]='.';
				}
			}
		}
		
		
		for (int i=0; i<R; i++) {
			
		}
	}

}
