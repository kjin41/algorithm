import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ20302 {
// Baekjoon 20302. 민트 초코
	static int[] prime, arr;
	static boolean[] comp;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input20302.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		comp=new boolean[100001];
		for (int i=2; i<318; i++) {		// sqrt(100000)=316.xx
			if (comp[i])	continue;
			for (int j=i*2; j<100001; j+=i) {
				comp[j]=true;
			}
		}
		int count=0; 
		for (int i=2; i<100001; i++) {
			if (!comp[i]) {
				count++;
			}
		}
//		System.out.println(count);
		prime=new int[count];
		int index=0;
		for (int i=2; i<100001; i++) {
			if (!comp[i]) {
				prime[index++]=i;
			}
		}
		arr=new int[100001];
		getPrime(Integer.parseInt(st.nextToken()), '*');
		
		for (int i=0; i<N-1; i++) {
			char oper=st.nextToken().charAt(0);
			int num=Integer.parseInt(st.nextToken());
			num=Math.abs(num);
			if (num==0) {
				System.out.println("mint chocolate");
				return;
			}
			getPrime(num, oper);
		}
		
//		System.out.println(Arrays.toString(arr));
		for (int i=2; i<100001; i++) {
			if (arr[i]<0) {
				System.out.println("toothpaste");
				return;
			}
		}
		System.out.println("mint chocolate");
		
		br.close();
	}

	private static void getPrime(int num, char oper) {
		if (num==0)	{
			System.out.println("mint chocolate");
			System.exit(0);
		}
		int i=0;
		while (num>1) {
			if (!comp[num]) {
				if (oper=='*') arr[num]++;
				else arr[num]--;
				return;
			}
			if (num%prime[i]==0) {
				num/=prime[i];
				if (oper=='*') arr[prime[i]]++;
				else arr[prime[i]]--;
			} else {
				i++;
			}
		}
		
	}

}
