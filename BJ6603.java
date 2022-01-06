import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ6603 {
// Baekjoon 6603. 로또
	static int N;
	static int[] temp, arr;
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input6603.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			if (N==0) {
				break;
			}
			arr=new int[N];
			temp=new int[N];
			
			for (int i=0; i<N; i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			
			comb(0,0);
			sb.append("\n");
					
		}
		
		System.out.println(sb);
		br.close();
	}

	private static void comb(int start, int cnt) {
		if (cnt==6) {
			for (int i=0; i<6; i++) {
				sb.append(temp[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i=start; i<N; i++) {
			temp[cnt]=arr[i];
			comb(i+1, cnt+1);
		}
		
	}

}
