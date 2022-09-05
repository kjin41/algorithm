import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA10726 {
// SW Expert Academy 10726. 이진수 표현
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input10726.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for (int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int num=Integer.parseInt(st.nextToken());
			
			boolean flag=true;
			for (int i=0; i<N; i++) {
				if ((num&1<<i)==0) {
					flag=false;
					break;
				}
				
			}
			
			if (flag)	sb.append("ON").append("\n");
			else 	sb.append("OFF").append("\n");
		}
		System.out.println(sb);
		
		br.close();
	}

}
