import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10836 {
// Baekjoon 10836. 여왕벌
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input10836.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int M=Integer.parseInt(st.nextToken());
		int N=Integer.parseInt(st.nextToken());
		int[][] arr=new int[M][M];
		
		for (int i=0; i<M; i++) {
			for (int j=0; j<M; j++) {
				arr[i][j]=1;
			}
		}
		
		for (int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			int[] num=new int[2*M-1];
			int k=0;
			for (int n=0; n<3; n++) {
				int t=Integer.parseInt(st.nextToken());
				for (int j=0; j<t; j++) {
					num[k++]=n;
				}
			}
			
			k=0;
			for (int j=M-1; j>0; j--) {
				arr[j][0]+=num[k++];
			}
			for (int j=0; j<M; j++) {
				arr[0][j]+=num[k++];
			}
		}
		
		for (int i=1; i<M; i++) {
			for (int j=1; j<M; j++) {
				arr[i][j]=Math.max(Math.max(arr[i-1][j-1], arr[i-1][j]), arr[i][j-1]);
			}
		}
		
		StringBuilder sb=new StringBuilder();
		for (int i=0; i<M; i++) {
			for (int j=0; j<M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		br.close();
		
	}

}
