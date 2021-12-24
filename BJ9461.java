import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9461 {
// Baekjoon 9461. 파도반 수열
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input9461.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
			int N=Integer.parseInt(br.readLine());
		
			long[] arr=new long[N+5];
			for (int i=0; i<3; i++) {
				arr[i]=1;
			}
			arr[3]=2;
			arr[4]=2;
			for (int i=5; i<N; i++) {
				arr[i]=arr[i-5]+arr[i-1];
			}
			System.out.println(arr[N-1]);
		}
		
		br.close();
	}

}
