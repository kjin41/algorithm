import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ16938 {
// Baekjoon 16938. 캠프 준비
	
	static int N, L, R, X, count;
	static int[] arr, temp;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input16938.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		L=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		X=Integer.parseInt(st.nextToken());
		arr=new int[N];
		st=new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for (int i=2; i<=N; i++) {
			temp=new int[i];
			comb(0, 0, 0, i);
		}
		System.out.println(count);
		br.close();
	}
	
	private static void comb(int start, int cnt, int sum, int K) {
		if (sum>R) {
			return;
		}
		
		if (cnt==K) {
			if (sum>=L&&sum<=R&&temp[K-1]-temp[0]>=X) {
				count++;
			}
			
			return;
		}
		
		for (int i=start; i<N; i++) {
			temp[cnt]=arr[i];
			comb(i+1, cnt+1, sum+arr[i], K);
		}
	}

}
