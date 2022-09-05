import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA10965 {
// SW Expert Academy 10965. 제곱수 만들기
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input10965.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		int N=10000000;
		int sqrtN=(int) Math.pow(N, 0.5)+1;
		boolean[] comp=new boolean[N+1];	// 합성수
		ArrayList<Integer> primeList=new ArrayList<>();		// 소수만, 뒤에서 제곱할거라 소수*소수 < N 인 범위까지만
		for (int i=2; i<sqrtN; i++) {
			if (!comp[i])	primeList.add(i);
			else continue;
			for (int j=i*2; j<sqrtN; j+=i) {
				comp[j]=true;
			}
		}
		
		StringBuilder sb=new StringBuilder();
		for (int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			int num=Integer.parseInt(br.readLine());
			for (int p: primeList) {
				while (true) {
					if (num%(p*p)==0)	num/=(p*p);
					else break;
				}
			}
			sb.append(num).append("\n");
		}
		System.out.println(sb);
		
		br.close();
	}

}
