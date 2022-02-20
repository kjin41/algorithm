import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ3184 {
// Baekjoon 3184. 양
	static int R, C, lamb, wolf;
	static char[][] arr;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input3184.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		arr=new char[R][C];
		visited=new boolean[R][C];
		
		for (int i=0; i<R; i++) {
			arr[i]=br.readLine().toCharArray();
		}
		
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				if(!visited[i][j]&&arr[i][j]!='#') {
					search(i, j);
				}
			}
		}
		System.out.println(lamb+" "+wolf);
		br.close();
	}

	private static void search(int r, int c) {
		Queue<int[]> queue=new LinkedList<int[]>();
		queue.add(new int[] {r,c});
		visited[r][c]=true;
		int tlamb=0;
		int twolf=0;
		if (arr[r][c]=='o') {
			tlamb++;
		} else if(arr[r][c]=='v') {
			twolf++;
		}
		
		
		int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
		while(!queue.isEmpty()) {
			int[] cur=queue.poll();
			for (int d=0; d<4; d++) {
				int nr=cur[0]+dir[d][0];
				int nc=cur[1]+dir[d][1];
				if (nr>=0&&nr<R&&nc>=0&&nc<C&&!visited[nr][nc]&&arr[nr][nc]!='#') {
					queue.add(new int[] {nr,nc});
					visited[nr][nc]=true;
					if (arr[nr][nc]=='o') {
						tlamb++;
					} else if(arr[nr][nc]=='v') {
						twolf++;
					}
				}
			}
			
		}
		
		if (tlamb>twolf) {
			lamb+=tlamb;
		} else {
			wolf+=twolf;
		}
	}

}
