import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ4991_2 {
// Baekjoon 4991. 로봇청소기
	static class Dust{
		int r, c;

		public Dust(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
	static int W, H, dCount, min;
	static char[][] arr;
	static Dust[] dusts;
	static int success;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input4991.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			W=Integer.parseInt(st.nextToken());
			H=Integer.parseInt(st.nextToken());
			if (W+H==0) {
				break;
			}
			dCount=0;
			min=40000;
			success=0;
			arr=new char[H][W];
			dusts=new Dust[10];
			int vr=0;
			int vc=0;
			for (int i=0; i<H; i++) {
				arr[i]=br.readLine().toCharArray();
				for (int j=0; j<W; j++) {
					if (arr[i][j]=='*') {
						dusts[dCount++]=new Dust(i, j);
					} else if(arr[i][j]=='o') {
						vr=i;
						vc=j;
					}
				}
			}
			
			perm(0, 0, vr, vc, 0);
			if (success==-1) {
				System.out.println(-1);
			} else {
				System.out.println(min);
			}
			
			
		}
		
		br.close();
	}

	private static void perm(int flag, int cnt, int cr, int cc, int sum) {	// 먼지 순서 정하기
		if (success==-1) {
			return;
		}
		if (min<sum) {
			return;
		}
		if (cnt==dCount) {
			min=Math.min(min, sum);
			return;
		}
		
		for (int i=0; i<dCount; i++) {
			if ((flag&1<<i)!=0) {
				continue;
			}
			int dist=cleanToDust(cr, cc, dusts[i].r, dusts[i].c);
			if (dist==-1) {
				success=-1;
			}
			perm(flag|1<<i, cnt+1, dusts[i].r, dusts[i].c, sum+dist);
					
		}
	}

	private static int cleanToDust(int cr, int cc, int fr, int fc) {
		Queue<int[]> queue=new LinkedList<int[]>();
		queue.add(new int[] {cr, cc});
		boolean[][] visited=new boolean[H][W];
		visited[cr][cc]=true;
		
		int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
		int count=0;
		boolean flag=false;
		loop:
		while(!queue.isEmpty()) {
			int size=queue.size();
			for (int s=0; s<size; s++) {
				int[] cur=queue.poll();
				if (cur[0]==fr&&cur[1]==fc) {
					flag=true;
					break loop;
				}
				for (int d=0; d<4; d++) {
					int nr=cur[0]+dir[d][0];
					int nc=cur[1]+dir[d][1];
					if (nr>=0&&nr<H&&nc>=0&&nc<W&&!visited[nr][nc]&&arr[nr][nc]!='x') {
						visited[nr][nc]=true;
						queue.add(new int[] {nr,nc});
					}
				}
			}
			count++;
		}

		if (!flag) {
			return -1;
		}
		return count;
	}

}
