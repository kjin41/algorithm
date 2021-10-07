import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1929 {
// Baekjoon 1929. 소수 구하기
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1929.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int M=Integer.parseInt(st.nextToken());
		int N=Integer.parseInt(st.nextToken());
//		int[] prime=new int[1000001];
		boolean[] comp=new boolean[1000001];
		int n=(int)Math.pow(N, 0.5)+1;
		if (n==1001) {
			n--;
		}
		
		comp[1]=true;
		
		
		for (int i=2; i<=n; i++) {
			if (comp[i])	continue;
			for (int j=i*i; j<=N; j++) {
				if (j%i==0&&!comp[j]) {
					comp[j]=true;
				}
			}
		}
		
		for (int i=M; i<=N; i++) {
			if (!comp[i]) {
				sb.append(i).append("\n");
			}
		}
		
		System.out.println(sb);
		
		br.close();
	}

}
