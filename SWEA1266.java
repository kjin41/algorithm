import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA1266 {
// SW Expert Academy 1266. 소수 완제품 확률
	static int[][] comb;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1266.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		comb=new int[19][19];
		for (int i=0; i<19; i++) {
			comb[i][0]=1;
		}
		for (int i=1; i<19; i++) {
			for (int j=1; j<=i; j++) {
				comb[i][j]=comb[i-1][j-1]+comb[i-1][j];
			}
		}
		
		StringBuilder sb=new StringBuilder();
		for (int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			double pa=calculate((double)a/100);
			double pb=calculate((double)b/100);
			double ans=1-pa*pb;
			
			int temp=(int) Math.round(ans*1000000);
			int digit=1;
			if (temp!=0)	digit=(int) Math.log10(temp)+1;
			StringBuilder strAns=new StringBuilder();
			strAns.append("0.");
			for (int i=0; i<6-digit; i++) {
				strAns.append("0");
			}
			strAns.append(temp);
			sb.append(strAns).append("\n");
		}
		
		System.out.println(sb);
		br.close();
				
				
	}

	private static double calculate(double a) {
		int[] notPrime={0,1,4,6,8,9,10,12,14,15,16,18};
		double p=0;
		int n=18;
		for (int i=0; i<12; i++) {
			int r=notPrime[i];
			p+=comb[n][r]*Math.pow(a, r)*Math.pow(1-a, n-r);
		}
		return p;
	}

}
