import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ10655 {
// Baekjoon 10655. 마라톤 1
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input10655.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		arr=new int[N][2];
		for (int i=0; i<N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			arr[i][0]=Integer.parseInt(st.nextToken());
			arr[i][1]=Integer.parseInt(st.nextToken());
		}
		
		int total=0;
		int[] sum1=new int[N-1];	// 바로 다음 칸 사이의 거리
//		int[] sum2=new int[N-2];	// 한칸 건너뛰고 다음 칸 사이의 거리
		for (int i=0; i<N-1; i++) {
			sum1[i]=distance(i, i+1);
//			sum2[i]=distance(i, i+2);
			total+=sum1[i];
		}
//		sum1[N-2]=distance(N-2, N-1);
//		total+=sum1[N-2];
		int min=total;
		for (int i=0; i<N-2; i++) {
			min=Math.min(min, total-sum1[i]-sum1[i+1]+distance(i, i+2));
		}
		
		System.out.println(min);
		br.close();
	}
	
	private static int distance(int i, int j) {
		return Math.abs(arr[i][0]-arr[j][0])+Math.abs(arr[i][1]-arr[j][1]);
	}

}
