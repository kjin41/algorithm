import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10819 {
// Baekjoon 10819. 차이를 최대로
	static int N, max=-10000;
	static int[] arr, temp;
	static boolean[] selected;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input10819.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr=new int[N+1];
		temp=new int[N+1];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		arr[N]=0;
		temp[N]=0;
		selected=new boolean[N]; 
		perm(0, 0);
		
		System.out.println(max);
		br.close();
	}

	private static void perm(int flag, int count) {
		if (count==N) {
			int sum=0;
			for (int i=1; i<N; i++) {
				sum+=Math.abs(temp[i-1]-temp[i]);
			}
			if (max<sum) {
				max=sum;
			}
			return;
		}
		
		for (int i=0; i<N; i++) {
			if ((flag & 1<<i)!=0) {
				continue;
			}
			
			temp[count]=arr[i];
			perm(flag | 1<<i, count+1);
			
		}
	}

}
