import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ17386 {
// Baekjoon 17386. 선분 교차 2
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input13411.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		long ax1=Long.parseLong(st.nextToken());
		long ay1=Long.parseLong(st.nextToken());
		long ax2=Long.parseLong(st.nextToken());
		long ay2=Long.parseLong(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		long bx1=Long.parseLong(st.nextToken());
		long by1=Long.parseLong(st.nextToken());
		long bx2=Long.parseLong(st.nextToken());
		long by2=Long.parseLong(st.nextToken());
		
		long answer=0;
		long d1=discriminant(ax2-ax1, ay2-ay1, bx1-ax1, by1-ay1);
		long d2=discriminant(ax2-ax1, ay2-ay1, bx2-ax1, by2-ay1);
		long d3=discriminant(bx2-bx1, by2-by1, ax1-bx1, ay1-by1);
		long d4=discriminant(bx2-bx1, by2-by1, ax2-bx1, ay2-by1);
		
		if ((d1*d2<0)&&(d3*d4)<0)	answer=1;
		System.out.println(answer);
		br.close();
	}

	private static long discriminant(long a, long b, long c, long d) {
		if (a*d-b*c>0) return 1;
		else if (a*d-b*c<0) return -1;
		return 0;
	}


}
