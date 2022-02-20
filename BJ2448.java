import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2448 {
// Baekjoon 2448. 별찍기

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input2448.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int power=N/3;
		int K=0;
		while(power!=1) {
			power/=2;
			K++;
		}
		StringBuilder[] star=new StringBuilder[N+1];
		for (int i=1; i<=N; i++) {
			star[i]=new StringBuilder();
		}
		star[1].append("  *  ");
		star[2].append(" * * ");
		star[3].append("*****");
		
		for (int k=0; k<K; k++) {
			for (int i=1; i<=3*(int)Math.pow(2, k); i++) {
				star[i+3*(int)Math.pow(2, k)].append(star[i]).append(" ").append(star[i]);
			}
			
			for (int i=1; i<=3*(int)Math.pow(2, k); i++) {
				int L=star[i].length();
				for (int l=0; l<L+1; l++) {
					star[i].append(" ");
				}
			}
		}
		
		for (int n=1; n<N/3; n++) {
			for (int i=1; i<=3*n; i++) {
				star[i].insert(0, "   ");
			}
		}
		
		StringBuilder sb=new StringBuilder();
		for (int i=1; i<=N; i++) {
			sb.append(star[i], 0, 2*N-1).append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
	}

}
