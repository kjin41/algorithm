import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11403 {
// Baekjoon 11403. 경로 찾기
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input11403.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		int[][] arr=new int[N][N];
		for (int i=0; i<N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		for (int k=0; k<N; k++) {
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (i==k || j==k) {
						continue;
					}
					if (arr[i][k]==1 && arr[k][j]==1) {
						arr[i][j]=1;
					}
				}
			}
		}
		
		StringBuilder sb=new StringBuilder();
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}

}
