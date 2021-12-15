import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15651 {
// Baekjoon 15651. N과 M (3)
// 중복순열	
	static int N, M;
	static int[] temp;
	static StringBuilder sb=new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input15651.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		temp=new int[M];
		perm(0);
		System.out.println(sb);
		
		br.close();
	}
	
	private static void perm(int cnt) {
		if (cnt==M) {
			for (int i=0; i<M; i++) {
				sb.append(temp[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i=1; i<=N; i++) {
			temp[cnt]=i;
			perm(cnt+1);
		}
	}

}
