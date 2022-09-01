import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1231 {
// SW Expert Academy 1231. 중위순회
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1231.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		for (int t=1; t<11; t++) {
			sb.append("#").append(t).append(" ");
			int N=Integer.parseInt(br.readLine());
			char[] arr=new char[N+1];
			for (int i=1; i<=N; i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				st.nextToken();
				arr[i]=st.nextToken().charAt(0);
			}
			
			printInOrder(1, N, arr);
			sb.append("\n");		
		}
		System.out.println(sb);
		
		
		br.close();
	}

	private static void printInOrder(int i, int N, char[] arr) {
		if (i>N) {
			return;
		}
		printInOrder(i*2, N, arr);
		sb.append(arr[i]);
		printInOrder(i*2+1, N, arr);
	}

}
