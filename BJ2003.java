import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2003 {
//Baekjoon 2003. 수들의 합2
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input2003.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int[] arr=new int[N+1];
		st=new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int sum=arr[0];
		int count=0;
		int left=0, right=0;
		while(left<=right&&right<N) {
			if (sum==M) {
				count++;
				sum+=arr[++right];
			} else if (sum<M) {
				sum+=arr[++right];
			} else {
				sum-=arr[left++];
				if (left>right) {
					sum+=arr[++right];
				}
			}
		
		}
		System.out.println(count);
		br.close();
	}

}
