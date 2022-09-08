import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA9480 {
// SW Expert Academy 9480. 민정이와 광직이의 알파벳 공부
	
	static int[] temp;
	static char[][] words;
	static int N, total;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input9480.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for (int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			N=Integer.parseInt(br.readLine());
			total=0;
			words=new char[N][];
			for (int i=0; i<N; i++) {
				words[i]=br.readLine().toCharArray();
			}
			
			for (int i=1; i<=N; i++) {
				temp=new int[i];
				comb(i, 0, 0);
			}
			sb.append(total).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	private static void comb(int K, int start, int count) {
		if (count==K) {
			if (isSet(K))	total++;
			return;
		}
		
		for (int i=start; i<N; i++) {
			temp[count]=i;
			comb(K, i+1, count+1);
		}
	}
	
	private static boolean isSet(int k) {
		boolean[] alpha=new boolean[26];
		for (int i=0; i<k; i++) {
			char[] word=words[temp[i]];
			for (int j=0; j<word.length; j++) {
				alpha[word[j]-'a']=true;
			}
		}
		
		for (int i=0; i<26; i++) {
			if (!alpha[i]) return false;
		}
		return true;
	}
}
