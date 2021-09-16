import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ14501 {
// Baekjoon 14501. 퇴사
	static class Work implements Comparable<Work>{
		int s, e, p;

		public Work(int s, int e, int p) {
			super();
			this.s = s;
			this.e = e;
			this.p = p;
		}

		@Override
		public int compareTo(Work o) {
			if (this.e==o.e)	return o.p-this.p;
			return this.e-o.e;
		}
		
	}
	
	static int N, max;
	static Work[] arr;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input14501.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new Work[N];
		visited = new boolean[N];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			arr[i] = new Work(i+1, i+d, p);
			
		}
		
		Arrays.sort(arr);	// 끝나는 날짜 기준 오름차순
		
		for (int i=0; i<N; i++) {
			if (arr[i].e<=N) {
				dfs(i, arr[i].p);
			}
		}
		System.out.println(max);
		
	}
	
	private static void dfs(int index, int p) {
		if (max<p) {
			max=p;
		}
		
		for (int i=index+1; i<N; i++) {
			if (arr[index].e<arr[i].s && arr[i].e<=N) {
				dfs(i, arr[i].p+p);
			}
		}
		
	}

}
