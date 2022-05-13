import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1806 {
// Baekjoon 1806. 부분합
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1806.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		long S=Integer.parseInt(st.nextToken());
		long[] arr=new long[N];
		st=new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i]=Long.parseLong(st.nextToken());
		}
		
		long sum=0l;
		int count=0;
		int min=1000000;
		int left=0;
		for (int i=0; i<N; i++) {
//			long temp=sum+arr[i];
			sum+=arr[i];
			if (sum>=S) {
//				System.out.println(sum+" "+count);
				while(sum>=S) {
					min=Math.min(min, count+1);
					sum-=arr[left++];
					count--;
				}
			}
			count++;
			
//			System.out.println(sum);
		}
				
		if (min==1000000) {
			min=0;
		}
		System.out.println(min);
		
		
		br.close();
	}

}
