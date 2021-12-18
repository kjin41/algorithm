import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BJ2667 {
// Baekjoon 2667. 단지번호붙이기
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input2667.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		char[][] arr=new char[N][N];
		boolean[][] visited=new boolean[N][N];
		ArrayList<Integer> list=new ArrayList<>();
		
		for (int i=0; i<N; i++) {
			arr[i]=br.readLine().toCharArray();
		}
		
		int[][] dir= {{1,0},{-1,0},{0,1},{0,-1}};
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				int sum=1;
				if (!visited[i][j]&&arr[i][j]=='1') {
					visited[i][j]=true;
					Queue<int[]> queue=new LinkedList<int[]>();
					queue.add(new int[] {i,j});
					while(!queue.isEmpty()) {
						int[] cur=queue.poll();
						for (int d=0; d<4; d++) {
							int nr=cur[0]+dir[d][0];
							int nc=cur[1]+dir[d][1];
							if (nr>=0&&nr<N&&nc>=0&&nc<N&&arr[nr][nc]=='1'&&!visited[nr][nc]) {
								visited[nr][nc]=true;
								queue.add(new int[] {nr,nc});
								sum++;
							}
						}
					}
					list.add(sum);
				}
			}
		}
		int size=list.size();
		System.out.println(size);
		Collections.sort(list);
		for (int i=0; i<size; i++) {
			System.out.println(list.get(i));
		}
		
		br.close();
	}

}
