import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1756 {
// Baekjoon 1756. 피자 굽기
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1756.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int D=Integer.parseInt(st.nextToken());
		int N=Integer.parseInt(st.nextToken());
		int[] depth=new int[D+1];
		depth[0]=2000000000;
		st=new StringTokenizer(br.readLine());
		for (int i=1; i<=D; i++) {
			int d=Integer.parseInt(st.nextToken());
			if (depth[i-1]>d) {		// 이전보다 지름이 작으면
				depth[i]=d;			// 작은 지름 넣고
			} else {				// 아니면
				depth[i]=depth[i-1];	// 이전 지름 넣고
			}
		}
		int d=D+1;
		st=new StringTokenizer(br.readLine());
		for (int i=1; i<=N; i++) {
			d--;	// 다음 피자를 위해
			int pizza=Integer.parseInt(st.nextToken());
			while(d>0 && depth[d]<pizza) {	// 들어갈 수 있는 최대 깊이까지
				d--;
			}
			// 빠져나오면 현재 d 위치에 피자 넣기
		}
		
		if (d>0) {
			System.out.println(d);
		} else {
			System.out.println(0);
		}
		
		
		
		
		br.close();
	}

}
