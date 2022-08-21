import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2138 {
// Baekjoon 2138. 전구와 스위치
	static int N;
	static char[] after;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input2138.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		char[] before1=br.readLine().toCharArray();
		char[] before2=before1.clone();
		after=br.readLine().toCharArray();
		int count1=0, count2=1;
		for (int i=1; i<N; i++) {
			if (before1[i-1]!=after[i-1]) {
				change(before1, i);
				count1++;
			}
		}
		
		if (before1[N-1]!=after[N-1])	count1=-1;
		
		
		change(before2, 0);
		for (int i=1; i<N; i++) {
			if (before2[i-1]!=after[i-1]) {
				change(before2, i);
				count2++;
			}
		}
		
		if (before2[N-1]!=after[N-1])	count2=-1;
		
		if (count1==-1 || count2==-1)	System.out.println(Math.max(count1, count2));
		else 	System.out.println(Math.min(count1, count2));
		
		br.close();
	}

	private static void change(char[] before, int i) {
		char sum='0'+'1';
		if (i>0)	before[i-1]=(char) (sum-before[i-1]);
		before[i]=(char) (sum-before[i]);
		if (i+1<N) before[i+1]=(char) (sum-before[i+1]);
	}

}
