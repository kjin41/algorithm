import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ1946 {
// Baekjoon 1946. 신입 사원
// 문제 제대로 이해하기..
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1946.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
			int N=Integer.parseInt(br.readLine());
			int[][] arr=new int[N][2];
			for (int i=0; i<N; i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				arr[i][0]=Integer.parseInt(st.nextToken());
				arr[i][1]=Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0]-o2[0];
				}
				
			});
			
			int count=1;
			int prev=arr[0][1];
			for (int i=1; i<N; i++) {
				if (arr[i][1]<prev) {
					count++;
					prev=arr[i][1];
				}
			}
			System.out.println(count);
		}
		
		br.close();
	}

}
