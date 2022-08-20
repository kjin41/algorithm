import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ20366 {
// Baekjoon 20366. 같이 눈사람 만들래?
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input20366.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		long[] arr=new long[N];
		for (int i=0; i<N; i++) {
			arr[i]=Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);
		
		long min=2000000000;
		long max=arr[N-1];
		for (int i=0; i<N-3; i++) {
			if (arr[i]+max+min<arr[i+1]+arr[i+2])	continue;
			for (int j=i+1; j<N-2; j++) {
				if (arr[i]+max+min<arr[j]+arr[j+1])	break;
				for (int k=j+1; k<N-1; k++) {
					if (arr[i]+max+min<arr[j]+arr[k])	break;
					for (int l=k+1; l<N; l++) {
						long sm1=arr[i]+arr[l];
						long sm2=arr[j]+arr[k];
						if (sm1-sm2>min) break;	//sm1>sm2&&
						min=Math.min(min, Math.abs(sm1-sm2));
					}
				}
			}
		}
		
		System.out.println(min);
		br.close();
	}

}
