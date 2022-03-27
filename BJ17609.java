import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ17609 {
// Baekjoon 17609. 회문
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input17609.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for (int t=0; t<T; t++) {
			String word=br.readLine();
			int ans=0;
			int len=word.length();
			for (int i=0; i<len/2; i++) {
				if (word.charAt(i)!=word.charAt(len-1-i)) {
					ans++;
					int flag=0;
					int right=len-1;
					for (int j=0; j<(len+1)/2; j++) {
						if (j==i) {	// 다음 j, right는 고정 비교
							j++;
						} 
						if (word.charAt(j)!=word.charAt(right--)) {
							flag++;
							break;
						}
					}
					
					right=len-1;
					for (int j=0; j<(len-1)/2; j++) {
						if (right==len-1-i) {	// j는 고정, 다음 right 비교
							right--;
						} 
						if (word.charAt(j)!=word.charAt(right--)) {
							flag++;
							break;
						}
					}
					
					if (flag>1) {
						ans++;
					} 
					break;
				}
			}
			
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

}
