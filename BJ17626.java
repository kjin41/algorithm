import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ17626 {
// Baekjoon 17626. Four Squares
	static int N, R;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input17626.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		R=(int)Math.pow(N, 0.5);
		
		for (int i=1; i<=4; i++) {
			perm(0, 0, i, 0);
		}
		
		
		br.close();
	}
	
	private static void perm(int start, int count, int K, int sum) {
		
		if (count==K) {
			if (sum==N) {
				System.out.println(K);
				System.exit(0);
			}
			return;
		}
		
		for (int i=1; i<=R; i++) {
			perm(i+1, count+1, K, sum+i*i);
		}
	}

}
