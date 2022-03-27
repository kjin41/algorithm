import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1932 {
// Baekjoon 1932. 정수 삼각형
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1932.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[][] arr=new int[N+1][N+1];
		for (int i=1; i<=N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for (int j=1; j<=i; j++) {
				int num=Integer.parseInt(st.nextToken());
				arr[i][j]=num+Math.max(arr[i-1][j-1], arr[i-1][j]);
			}
		}
		
		int max=0;
		for (int i=1; i<=N; i++) {
			max=Math.max(arr[N][i], max);
		}
		
		System.out.println(max);
		
		br.close();
	}

}
