import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA11593 {
// SW Expert Academy 11593. 애너그램 랭킹
	static char[] word;
	static int[] alpha;
	static long[] fac;
	static int len;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input11593.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		fac=new long[21];
		fac[0]=1;
		for (int i=1; i<21; i++) {
			fac[i]=fac[i-1]*i;
		}
		
		StringBuilder sb=new StringBuilder();
		for (int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			word=br.readLine().toCharArray();
			len=word.length;
			alpha=new int[26];
			for (int i=0; i<len; i++) {
				alpha[word[i]-'A']++;
			}
			
			long count=0l;
			for (int i=0; i<len-1; i++) {
				for (int j=0; j<26; j++) {
					if (alpha[j]==0)	continue;
					if (word[i]==j+'A') {
						alpha[j]--;
						break;
					}
					count+=calculate(j);
				}
			}
			sb.append(count).append("\n");
			
		}
		System.out.println(sb);
		br.close();
	}

	private static long calculate(int j) {
		alpha[j]--;
		int n=0;
		ArrayList<Integer> list=new ArrayList<>();
		for (int i=0; i<26; i++) {
			if (alpha[i]!=0) n+=alpha[i];
			if (alpha[i]>1)	list.add(alpha[i]);	// 중복 개수
		}
		long ans=fac[n];
		for (int i: list) {
			ans/=fac[i];
		}
		alpha[j]++;
		return ans;
	}

}
