import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ9465 {
// Baekjoon 9465. 스티커
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input9465.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
//		StringBuilder sb = new StringBuilder();
		for (int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int arr[][] = new int[2][N+1];
			for (int i=0; i<2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j=1; j<N+1; j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}				
			}
			
			for (int j=2; j<N+1; j++) {
				for (int i=0; i<2; i++) {
					int max=Math.max(arr[1-i][j-1], arr[1-i][j-2]);	// 다른행 왼쪽, 다른행 더 왼쪽
					max=Math.max(max, arr[i][j-2]);	// 같은 행 더 왼쪽
					arr[i][j]+=max;
				}
			}
			
			int result=Math.max(arr[0][N], arr[1][N]);
			System.out.println(result);
			// 하나는 그냥 프린트하는게 빠른듯?
			
//			sb.append(result).append("\n");
		}
//		System.out.println(sb);
	}

}
