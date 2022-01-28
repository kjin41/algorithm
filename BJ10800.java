import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ10800 {
// baekjoon 10800. 컬러볼
	static class Ball implements Comparable<Ball>{
		int n, c, s;

		public Ball(int n, int c, int s) {
			super();
			this.n = n;
			this.c = c;
			this.s = s;
		}

		@Override
		public int compareTo(Ball o) {
			if (this.s==o.s) {
				return this.c-o.c;
			}
			return this.s-o.s;
		}

		
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input10800.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		Ball[] balls=new Ball[N];
		for (int i=0; i<N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int c=Integer.parseInt(st.nextToken());
			int s=Integer.parseInt(st.nextToken());
			balls[i]=new Ball(i, c, s);
		}
		
		long[] result=new long[N+1];
		long[] temp=new long[N+1];		// 누적합
		long total=0l;
		int beforeSize=0;
		int beforeColor=0;
		int beforeCount=1;
		long beforeResult=0l;
		
		Arrays.sort(balls);
		StringBuilder sb=new StringBuilder();
		
		for (int i=0; i<N; i++) {
			int c=balls[i].c;
			int s=balls[i].s;
			int n=balls[i].n;
			result[n]=total-temp[c];
			if (beforeSize==s) {
				if (beforeColor==c) {	// 색, 크기 동일한 공인 경우 직전 결과 가져오기
					result[n]=beforeResult;
				} else {	// 크키가 중복되는 공들 개수*크기만큼 빼기
					result[n]-=s*beforeCount;
				}
				beforeCount++;
			} else {
				beforeCount=1;
			}
			temp[c]+=s;
			total+=s;
			beforeSize=s;
			beforeColor=c;
			beforeResult=result[n];
			
		}
		
		for (int i=0; i<N; i++) {
			sb.append(result[i]).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

}
