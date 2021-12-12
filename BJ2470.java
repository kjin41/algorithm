import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2470 {
// Baejoon 2470. 두 용액
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input2470.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] arr=new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int sum=2000000000;
		int small=0;
		int big=0;
		int si=0;
		int bi=N-1;
		
		while(si<bi) {
			int temp=arr[si]+arr[bi];
			if (sum>Math.abs(temp)) {
				sum=Math.abs(temp);
				small=arr[si];
				big=arr[bi];
				if (sum==0) {
					break;
				}
			}
			
			if(temp>0) {
				bi--;
			} else {
				si++;
			}
		}
		
		System.out.println(small+" "+big);
		br.close();
	
	}

}
