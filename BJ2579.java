import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ2579 {
// Baekjoon 2579. 계단 오르기
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input2579.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[][] arr=new int[2][N+2];	// 현재값 포함한 최대값
		for (int i=2; i<N+2; i++) {
			int temp=Integer.parseInt(br.readLine());
			arr[0][i]=Math.max(arr[0][i-2], arr[1][i-2])+temp;	// 바로 앞값 제외
			arr[1][i]=arr[0][i-1]+temp;		// 바로 앞값 포함
		}
		
		System.out.println(Math.max(arr[0][N+1], arr[1][N+1]));
		br.close();
	}

}
