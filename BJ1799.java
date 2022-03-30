import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1799 {
// Baekjoon 1799. 비숍
// 흑, 백칸 나눠서 생각하기
	static int N, max, total;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1799.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		int[][] arr=new int[N][N];
		for (int i=0; i<N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		dfs(arr, 0, -1, 0, 0);
		total=max;
		max=0;
		dfs(arr, 0, -1, 0, 1);
		total+=max;
		System.out.println(total);
		br.close();
	}
	
	private static void dfs(int[][] arr, int r, int c, int cnt, int flag) {
		max=Math.max(max, cnt);
		if (c>=N) {
			c=0;
			r++;
		} else {
			c++;
		}
		
		if (r==N) {
			return;
		}
		
		for (int i=r; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (i==r && j<c) {
					continue;
				}
				if ((i+j)%2!=flag) {	// 흑, 백 나눠서
					continue;
				}
				if (arr[i][j]==1 && !isCrossed(arr, i, j)) {
					arr[i][j]=2;
					dfs(arr, i, j, cnt+1, flag);
					arr[i][j]=1;
				} 
			}
		}
		
		
	}

	private static boolean isCrossed(int[][] arr, int r, int c) {
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (i+j==r+c && arr[i][j]==2) {
					return true;
				}
				if (i-j==r-c && arr[i][j]==2) {
					return true;
				}
			}
		}
		
		return false;
	}

}
