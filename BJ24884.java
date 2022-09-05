import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ24884 {
// Baekjoon 24884. 장작 넣기
	static int N, W, T, K, total;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input24884.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		int W=Integer.parseInt(st.nextToken());
		T=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		int[] arr=new int[N];
		st=new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		
		int count=reduce(-1, arr);
		if (T==1&&count>=K) {
			System.out.println(1);
		} else {
			if (W>0)	dfs(W-1, 1, count, arr);
			dfs(W, 1, N, arr);
			if (W<N-1) 	dfs(W+1, 1, count, arr);
			System.out.println(total);
		}
		br.close();
	}

	private static void dfs(int w, int t, int count, int[] arr) {
		int[] clone=arr.clone();
		count=reduce(w, clone);
		if (count<K)	return;
		if (t==T-1) {
			total++;
			return;
		}
		
		if (w>0)	dfs(w-1, t+1, count, clone);
		dfs(w, t+1, count, clone);
		if (w<N-1)	dfs(w+1, t+1, count, clone);
	}

	private static int reduce(int w, int[] arr) {
		int[] diff=new int[N];
		int count=0;
		for (int i=0; i<N; i++) {
			diff[i]=3;
			if (i>0&&arr[i-1]!=0)	diff[i]--;
			if (i<N-1&&arr[i+1]!=0)	diff[i]--;
		}
		
		for (int i=0; i<N; i++) {
			if (w==-1 || w!=i)	arr[i]-=diff[i];
			if (arr[i]<=0)	{
				arr[i]=0;
				count++;
			}
		}
		
		return N-count;
	}

}
