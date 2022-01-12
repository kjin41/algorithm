import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9095 {
// Baekjoon 9095. 1, 2, 3 더하기
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input9095.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
			int N=Integer.parseInt(br.readLine());
			int[] arr=new int[N+3];
			arr[1]=1;
			arr[2]=2;
			arr[3]=4; 
			for (int i=4; i<=N; i++) {
				arr[i]=arr[i-3]+arr[i-2]+arr[i-1];
			}
			System.out.println(arr[N]);
		}
		
		
		br.close();
	}

}
