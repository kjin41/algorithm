import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ15685 {
// Baekjoon 15685. 드래곤 커브
	static int N;
	static boolean[][] arr=new boolean[101][101];
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input15685.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		for (int i=0; i<N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			int g=Integer.parseInt(st.nextToken());
			curve(x, y, d, g);
		}
		
		int count=0;
		
		for (int i=0; i<100; i++) {
			for (int j=0; j<100; j++) {
				if (arr[i][j]&&arr[i+1][j]&&arr[i][j+1]&&arr[i+1][j+1]) {
					count++;
				}
			}
		}
		
		System.out.println(count);
		br.close();
	}
	
	private static void curve(int x, int y, int d, int g) {
		int[][] dir=new int[][] {{0,1},{-1,0},{0,-1},{1,0}};
		arr[y][x]=true;
		ArrayList<Integer> list=new ArrayList<>();
		list.add(d);
		y+=dir[d][0];
		x+=dir[d][1];
		arr[y][x]=true;	
		
		for (int i=0; i<g; i++) {
			int size=list.size()-1;
			for (int j=size; j>=0; j--) {
				d=(list.get(j)+1)%4;
				y+=dir[d][0];
				x+=dir[d][1];
				arr[y][x]=true;
				list.add(d);
			}
		}
	}

}
