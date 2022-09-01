import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ13701 {
// Baekjoon 13701. 중복 제거
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input13701.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringBuilder sb=new StringBuilder();
		boolean[] arr=new boolean[33554433];
		while(st.hasMoreTokens()) {
			int num=Integer.parseInt(st.nextToken());
			if (!arr[num]) {
				sb.append(num).append(" ");
				arr[num]=true;
			}
		}
		System.out.println(sb);
		
		br.close();
	}

}
