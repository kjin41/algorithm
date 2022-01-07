import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1182 {
// Baekjoon 1182. 부분수열의 합
// 부분합
// 시간초과 안나넹..
	static int N, S, count;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1182.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		S=Integer.parseInt(st.nextToken());
		arr=new int[N];
		st=new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		for (int i=1; i<=N; i++) {
			comb(0, 0, i, 0);
		}
		 
		System.out.println(count);
		
		br.close();
	}
	
	private static void comb(int start, int cnt, int K, int sum) {
		if (cnt==K) {
			if (sum==S) {
				count++;
			}
			return;
		}
		
		for (int i=start; i<N; i++) {
			comb(i+1, cnt+1, K, sum+arr[i]);
		}
	}

}
