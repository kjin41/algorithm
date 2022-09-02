import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA7584 {
// SW Expert Academy 7584. 자가 복제 문자열
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input7584.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		long L=(long) Math.pow(10, 18);
		long a=0l;
		while(a<=L) {
			a=a*2+1;
		}
		// P(N+1) = P(N)0P'(N)
		// P'(N+1) = P(N)1P'(N)
		StringBuilder sb=new StringBuilder();
		for (int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			long K=Long.parseLong(br.readLine());
			long mid=a+1;
			int flag=0;
			while (mid>0) {
				if (K==mid) {
					sb.append(flag).append("\n");
					break;
				} else if (K>mid) {
					flag=1;
					K-=mid;
				} else {
					flag=0;
				}
				mid/=2;					
				
			}
		}
		System.out.println(sb);
		
		br.close();
	}

}
