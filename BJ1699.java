import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1699 {
// Baekjoon 1699. 제곱수의 합
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1699.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] arr=new int[N+1];
		for (int i=1; i*i<=N; i++) {
			arr[i*i]=1;
		}
		
		for (int i=1; i<=N; i++) {
			if (arr[i]==0) {
				int min=1000000;
				for (int j=1; j*j<=i; j++) {
					min=Math.min(min, arr[j*j]+arr[i-j*j]);
					if (min==2) {
						break;
					}
				}
				arr[i]=min;
			}
		}
		
		System.out.println(arr[N]);
		br.close();
	}

}
