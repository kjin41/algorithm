import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA5658 {
// SW Expert Academy 5658. 보물상자 비밀번호
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input5658.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for (int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int K=Integer.parseInt(st.nextToken());
			char[] arr=br.readLine().toCharArray();
			int[] nums=new int[N];
			int n=0;
			for(int i=0; i<N; i++) {
				int num=0;
				int k=N/4-1;
				for (int j=i; j<i+N/4; j++) {
					num+=toDecimal(arr[j%N], k--);
				}
				nums[n++]=num;
			}
			Arrays.sort(nums);
			int k=1;
			int num=nums[N-1];
			for (int i=N-2; i>=0; i--) {
				if (k==K) {
					break;
				}
				if (num>nums[i]) {
					num=nums[i];
					k++;
				}
			}
			sb.append(num).append("\n");
			
		}
		System.out.println(sb);
		
		
		br.close();
	}

	private static int toDecimal(char c, int k) {
		if(c>='0'&&c<='9') {
			return (c-'0')*(int)Math.pow(16, k);
		} else {
			return (c-'A'+10)*(int)Math.pow(16, k);
		}
	}

}
