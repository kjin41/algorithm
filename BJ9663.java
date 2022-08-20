import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BJ9663 {
// Baekjoon 9663. N-Queen
	static int N, total;
	static boolean[][] visited;
	static boolean[] visitedC;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input9663.txt"));
		Scanner sc=new Scanner(new InputStreamReader(System.in));
		N=sc.nextInt();
		visited=new boolean[N][N];
		visitedC=new boolean[N];
		dfs(0, 0, 0);
		System.out.println(total);
	}

	private static void dfs(int r, int c, int count) {
		if (count==N) {
			total++;
			return;
		}

		for (int j=0; j<N; j++) {
			if (count<r)	return;
			if (visitedC[j] || isCrossed(r, j)) continue;
			visitedC[j]=true;
			visited[r][j]=true;
			dfs(r+1, j+1, count+1);
			visitedC[j]=false;
			visited[r][j]=false;
		}
	}


	private static boolean isCrossed(int r, int c) {	// 대각선
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if ((i-j==r-c||i+j==r+c) && visited[i][j])	return true;
			}
		}
		
		return false;
	}

}
