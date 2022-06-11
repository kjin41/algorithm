import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ2295 {
// Baekjoon 2295. 세 수의 합
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] arr=new int[N];
		for (int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		int last=arr[N-1];
		int max=0;
		for (int i=N-1; i>=0; i--) {
			if (arr[i]*3<arr[max])	break;
			loop1:
			for (int j=i; j>=0; j--) {
				if (arr[i]+arr[j]*2<arr[max])	break;
				for (int k=j; k>=0; k--) {
					int sum=arr[i]+arr[j]+arr[k];
					if (sum<arr[max])	continue loop1;
					if (sum>last)	continue;
					int result=Arrays.binarySearch(arr, sum);
					if (result>=0) {
						max=Math.max(max, result);
						continue loop1;
					}
				}
			}
		}
		
		System.out.println(arr[max]);
		br.close();
	}

}