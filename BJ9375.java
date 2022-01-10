import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;

public class BJ9375 {
// Baekjoon 9375. 패션왕 신해빈
//	static int N;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input9375.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for (int t=0; t<T; t++) {
			int N=Integer.parseInt(br.readLine());
			if (N==0) {
				sb.append(0).append("\n");
				continue;
			}
			HashMap<String, Integer> map=new HashMap<>();
			for (int i=0; i<N; i++) {
				String[] str=br.readLine().split(" ");
				if (map.containsKey(str[1])) {
					map.put(str[1], map.get(str[1])+1);
				} else {
					map.put(str[1], 1);
				}
			}
			
			int sum=1;
			for (Entry<String, Integer> m:map.entrySet()) {
				sum*=(m.getValue()+1);
			}
			sb.append(--sum).append("\n");
		}
				
		System.out.println(sb);
		
		br.close();
	}

}
