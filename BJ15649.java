import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15649 {
// Baekjoon 15649. N과 M(1)
	static int N, M;
	static int[] temp;
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input15649.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		temp=new int[M];
		
		perm(0, 0);
		System.out.println(sb);
		
		br.close();
	}
	
	private static void perm(int flag, int count) {
		if (count==M) {
			for (int i=0; i<M; i++) {
				sb.append(temp[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i=1; i<=N; i++) {
			if ((flag&1<<i)!=0) {
				continue;
			}
			temp[count]=i;
			perm(flag|1<<i, count+1);
		}
		
		
	}

}
