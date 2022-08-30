import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA7675 {
// SW Expert Academy 7675. 통역사 성경이
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input7675.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for (int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			int N=Integer.parseInt(br.readLine());
			StringTokenizer st=new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				String word="";
				int count=0;
				while(true) {
					word=st.nextToken();
					char last=word.charAt(word.length()-1);
					if (last=='.' || last=='?' || last=='!') {
						if (isName(word, word.length()-1))	count++;
						break;
					}
					if (isName(word, word.length()))	count++;	
				}
				sb.append(count).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	private static boolean isName(String word, int len) {
		if (word.charAt(0)<'A' || word.charAt(0)>'Z') return false;
		for (int i=1; i<len; i++) {
			if (word.charAt(i)<'a' || word.charAt(i)>'z') return false;
		}
//		System.out.println(word);
		return true;
	}

}
