import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ21315 {
// Baekjoon 21315. 카드 섞기
	static int N;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input21315.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		int[] ans=new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			ans[i]=Integer.parseInt(st.nextToken());
		}
		
		int[] arr=new int[N];
		for (int i=0; i<N; i++) {
			arr[i]=i+1;
		}
		
		int K=(int)((Math.log10(N)-0.000001)/Math.log10(2));
		loop:
		for (int i=1; i<=K; i++) {
			int[] temp1=change(i, arr);
			for (int j=1; j<=K; j++) {
				boolean flag=false;
				int[] temp2=change(j, temp1);
				for (int k=0; k<N; k++) {
					if (temp2[k]!=ans[k]) {
						flag=true;
						break;
					}
				}
				if (flag) {
					continue;
				}
				System.out.println(i+" "+j);
				break loop;
			}
		}
			
		br.close();
	}

	private static int[] change(int K, int[] arr) {
		int[] temp=new int[N];
		int n=(int)Math.pow(2, K);
		int right=N-1;
		int left=0;
		temp[left++]=arr[right];
		for (int i=1; i<=n/2; i*=2) {
			right-=i;
			for (int j=right; j<right+i; j++) {
				temp[left++]=arr[j];
			}
		}
		
		for (int i=0; i<N-n; i++) {
			temp[left++]=arr[i];
		}
		
		return temp;
	}

}
