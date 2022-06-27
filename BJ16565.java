import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class BJ16565 {
// Baekjoon 16565. N포커
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input16565.txt"));
		Scanner sc=new Scanner(new InputStreamReader(System.in));
		int N=sc.nextInt();
		long result=0l;
		long mod=10007;
		
		int T=52;
		long[][] comb=new long[T+1][T+1];	// nCr = n-1Cr + n-1Cr-1
		for (int i=0; i<=T; i++)	comb[i][0]=1;
		
		for (int i=1; i<=T; i++) {
			for (int j=1; j<=i; j++) {
				comb[i][j]=(comb[i-1][j]+comb[i-1][j-1]);
			}
		}
		
		for (int i=1; i<=N/4; i++) {	// 포함과 배제의 원리
			result+=Math.pow(-1, i+1)*comb[13][i]*comb[52-4*i][N-4*i];
		}
		
		System.out.println(result%mod);
		
	}
}
