import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2011_2 {
// Baekjoon 2011. 암호코드
// dp : 꽤 까다로움
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input2011.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		if (str==null) {
			System.out.println(0);
			System.exit(0);
		}
		char[] arr=str.toCharArray();
		
		int N=arr.length;
		
		int[] dp=new int[N+1];
		if (arr[0]=='0') {
			System.out.println(0);
			System.exit(0);
		}
		
		dp[0]=1;
		dp[1]=1;
		
		for (int i=2; i<=N; i++) {
			if (arr[i-1]=='0') {
				if (arr[i-2]!='1'&&arr[i-2]!='2') {
					break;	// 10 20 이 아닌 경우
				} 
			}
			int temp=(arr[i-2]-'0')*10+arr[i-1]-'0';	// 두자리 수
			if (temp==10 || temp==20) {	
				dp[i]=dp[i-2]%1000000;	// 2개 앞에 만큼
			} else if (i>1&&temp<=26&&temp>10) {
				dp[i]=(dp[i-1]+dp[i-2])%1000000;	// 직전 자리 + 2개 앞에 자리
			} else {	// 한 자리만 가능
				dp[i]=dp[i-1]%1000000;
			}
		}
		
		System.out.println(dp[N]);
		
		
		
		br.close();
				
	}

}
