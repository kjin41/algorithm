import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ11652 {
// Baekjoon 11652. 카드
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input11652.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		long[] arr=new long[N+1];
		for (int i=0; i<N; i++) {
			arr[i]=Long.parseLong(br.readLine());
		}
		arr[N]=Long.MAX_VALUE;
		
		Arrays.sort(arr);
		long before=arr[0];
		int count=1;
		int maxCount=1;
		long max=arr[0];
		for (int i=1; i<=N; i++) {
			if (before==arr[i]) {
				count++;
			} else {
				if (maxCount<count) {
					maxCount=count;
					max=before;
				}
				before=arr[i];
				count=1;
			}
		}
		
		System.out.println(max);
		
		br.close();
	}

}
