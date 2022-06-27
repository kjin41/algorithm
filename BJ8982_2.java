import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.text.html.MinimalHTMLWriter;

public class BJ8982_2 {
// Baekjoon 8982. 수족관 1
	
	static class Hole implements Comparable<Hole>{
		int x, y;
		
		public Hole(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Hole o) {
			return this.x-o.x;
		}
		
	}
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input8982.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[][] point=new int[N][2];
		for (int i=0; i<N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			point[i][0]=Integer.parseInt(st.nextToken());
			point[i][1]=Integer.parseInt(st.nextToken());
		}
		
		int W=point[N-1][0];	// 가로 개수
		int[] arr=new int[W];
		int[] hole=new int[W];
		
		int index=0;
		for (int i=2; i<N-1; i++) {
			for (int j=index; j<point[i][0]; j++) {
				arr[j]=point[i][1];
			}
			index=point[i][0];
		}
		
		int K=Integer.parseInt(br.readLine());
		Hole[] holes=new Hole[K];
		for (int i=0; i<K; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			holes[i]=new Hole(x, y);
		}
		
		Arrays.sort(holes);
		for(int i=0; i<K; i++) {
			int x=holes[i].x;
			int y=holes[i].y;
			int min=arr[x];
			hole[x]=y;
			for (int j=x+1; j<W; j++) {
				if (min>arr[j])	min=arr[j];
				hole[j]=Math.max(hole[j], min);
			}
			min=arr[x];
			for (int j=x-1; j>=0; j--) {
				if (min>arr[j])	min=arr[j];
				hole[j]=Math.max(hole[j], min);
			}
		}
		
		long result=0;
		for (int i=0; i<W; i++) {
			int diff=arr[i]-hole[i];
			if (diff>0)	result+=diff;
		}
		
		System.out.println(result);
		br.close();		
	}

}

