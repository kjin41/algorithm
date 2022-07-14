import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ1339 {
// Baekjoon 1339. 단어 수학
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1339.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] words=new int[26];
		for (int i=0; i<N; i++) {
			char[] word=br.readLine().toCharArray();
			int len=word.length;
			for (int j=0; j<len; j++) {
				words[word[len-1-j]-'A']+=Math.pow(10, j);	// 일의 자리 부터 해당 알파벳 위치에 10^자릿수 만큼 더하기
			}
		}

		Arrays.sort(words);
//		System.out.println(Arrays.toString(words));
		int count=0;
		for (int i=0; i<10; i++) {
			count+=i*words[i+16];
		}
		
		System.out.println(count);
		br.close();
	}

}
