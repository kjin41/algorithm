import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ10825 {
// Baekjoon 10825.국영수
// comparable
	
	static class Score implements Comparable<Score>{
		String name;
		int k, e, m;
		
		public Score(String name, int k, int e, int m) {
			super();
			this.name = name;
			this.k = k;
			this.e = e;
			this.m = m;
		}

		@Override
		public int compareTo(Score o) {
			if (this.k!=o.k) {
				return o.k-this.k;
			} else if (this.e!=o.e) {
				return this.e-o.e;
			} else if (this.m!=o.m) {
				return o.m-this.m;
			} else {
				return this.name.compareTo(o.name);
			} 
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input10825.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		Score[] scores=new Score[N];
		for (int i=0; i<N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			String name=st.nextToken();
			int k=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			scores[i]=new Score(name, k, e, m);
		}
		
		Arrays.sort(scores);
		StringBuilder sb=new StringBuilder();
		for (int i=0; i<N; i++) {
			sb.append(scores[i].name).append("\n");
		}
		System.out.println(sb);
		
		br.close();
	}

}
