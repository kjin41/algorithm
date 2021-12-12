import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14719 {
// Baekjoon 14719. 빗물
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input14719.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int H=Integer.parseInt(st.nextToken());
		int W=Integer.parseInt(st.nextToken());
		int[] arr=new int[W];
		int[][] highest=new int[2][W];
		st=new StringTokenizer(br.readLine());
		for (int i=0; i<W; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int lh=0;
		for (int i=0; i<W; i++) {	// 왼쪽중 제일 큰값
			if (arr[lh]<arr[i]) {
				lh=i;
			}
			highest[0][i]=arr[lh];
		}
		int rh=W-1;
		for (int i=W-1; i>=0; i--) {	// 오른쪽 중 제일 큰값
			if (arr[rh]<arr[i]) {
				rh=i;
			}
			highest[1][i]=arr[rh];
		}
				
		int sum=0;
		for (int i=0; i<W; i++) {	// 왼쪽, 오른쪽 제일 큰값들 중 작은값-현재높이
			sum+=Math.min(highest[0][i], highest[1][i])-arr[i];
		}
		System.out.println(sum);
		
		
		br.close();
	}

}
