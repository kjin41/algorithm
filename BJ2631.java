import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2631 {
// Baekjoon 2631. 줄 세우기
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input2631.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] arr=new int[N];
		for (int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		int[] lis=new int[N];
		lis[0]=arr[0];
		int len=1;
		for (int i=1; i<N; i++) {
			int k=0;
			while(lis[k]<=arr[i]&&k<len) k++;
			lis[k]=arr[i];
			if (k==len)		len++;
			
		}
		
		System.out.println(N-len);
		br.close();
	}

}
