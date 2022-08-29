import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SWEA1221 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("GNS_test_input.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		HashMap<String, Integer> map=new HashMap<>();
		String[] num={"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
		for (int i=0; i<10; i++) {
			map.put(num[i],	i);
		}
		for (int t=1; t<=T; t++) {
			StringBuilder sb=new StringBuilder();
			sb.append("#").append(t).append(" ");
			StringTokenizer st=new StringTokenizer(br.readLine());
			st.nextToken();
			int[] count=new int[10];
			int N=Integer.parseInt(st.nextToken());
			st=new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				count[map.get(st.nextToken())]++;
			}
			for (int i=0; i<10; i++) {
				for (int j=0; j<count[i]; j++) {
					sb.append(num[i]).append(" ");
				}
			}
			System.out.println(sb);
		}
		
		br.close();
	}

}
