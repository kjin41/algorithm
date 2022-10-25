import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2141 {
// Baekjoon 2141. 우체국
	static class Town implements Comparable<Town>{
		int x, a;

		public Town(int x, int a) {
			super();
			this.x = x;
			this.a = a;
		}

		@Override
		public int compareTo(Town o) {
			return this.x-o.x;
		}
		
	}
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input2141.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		Town[] towns=new Town[N];
		long total=0l;
		long sum=0l;
		for (int i=0; i<N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int a=Integer.parseInt(st.nextToken());
			towns[i]=new Town(x, a);
			total+=a;
		}
		
		Arrays.sort(towns);
		
		for (int i=0; i<N; i++) {
			sum+=towns[i].a;
			if (2*sum>=total) {		// 중간값 찾기
				System.out.println(towns[i].x);
				return;
			}
		}
		br.close();
	}

}
