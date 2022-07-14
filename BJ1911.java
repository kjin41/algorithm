import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1911 {
// Baekjoon 1911. 흙길 보수하기
	static class Hole implements Comparable<Hole>{
		int s, e;

		public Hole(int s, int e) {
			super();
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Hole o) {
			return this.s-o.s;
		}
		
	}
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1911.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int L=Integer.parseInt(st.nextToken());
		Hole[] holes=new Hole[N];
		for (int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			holes[i]=new Hole(s, e);
		}
		
		Arrays.sort(holes);
		
		int count=0;
		int end=0;
		int temp=0;
		for (Hole h: holes) {
			if (end<h.s) { 
				temp=(h.e-h.s+L-1)/L;
				end=h.s+temp*L;
			} else	{ 
				temp=(h.e-end+L-1)/L;
				end=end+temp*L;
			}
			count+=temp;
		}
		
		System.out.println(count);
		br.close();
	}

}
