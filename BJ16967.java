import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16967 {
// Baekjoon 16967. 배열 복원하기
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input16967.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int H=Integer.parseInt(st.nextToken());
		int W=Integer.parseInt(st.nextToken());
		int X=Integer.parseInt(st.nextToken());
		int Y=Integer.parseInt(st.nextToken());
		int[][] A=new int[H][W];
		int[][] B=new int[H+X][W+Y];
		for (int i=0; i<H+X; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j=0; j<W+Y; j++) {
				B[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i=0; i<X; i++) {
			for (int j=0; j<W; j++) {
				A[i][j]=B[i][j];
			}
		}
		
		for (int i=0; i<H; i++) {
			for (int j=0; j<Y; j++) {
				A[i][j]=B[i][j];
			}
		}
		
		for (int i=X; i<H; i++) {
			for (int j=Y; j<W; j++) {
				A[i][j]=B[i][j]-A[i-X][j-Y];
			}
		}
		
		StringBuilder sb=new StringBuilder();
		for (int i=0; i<H; i++) {
			for (int j=0; j<W; j++) {
				sb.append(A[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}

}
