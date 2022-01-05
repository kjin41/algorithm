import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1976 {
// Baekjoon 1976. 여행 가자
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1976.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int M=Integer.parseInt(br.readLine());
		int[][] arr=new int[N+1][N+1];
		for (int i=1; i<=N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for (int j=1; j<=N; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for (int k=1; k<=N; k++) {
			for (int i=1; i<=N; i++) {
				for (int j=1; j<=N; j++) {
					if (arr[i][j]==0&&arr[i][k]==1&&arr[k][j]==1) {
						arr[i][j]=1;
					}
				}
			}
		}
		
//		for (int i=1; i<=N; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		int A=Integer.parseInt(st.nextToken());
		String ans="YES";
		for (int i=1; i<M; i++) {
			int B=Integer.parseInt(st.nextToken());
			if (A==B) {
				continue;
			}
			if (arr[A][B]==0) {
				ans="NO";
				break;
			}
			A=B;
		}
		
		System.out.println(ans);
		br.close();
	}

}
