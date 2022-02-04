import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2668 {
// Baekjoon 2668. 숫자고르기
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input2668.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		int[] arr=new int[N+1];
		int[] used=new int[N+1];
		boolean[] erased=new boolean[N+1];
		for (int i=1; i<=N; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		for (int n=1; n<=100; n++) {
			for (int i=1; i<=N; i++) {
				if (!erased[i]) {
					used[arr[i]]=n;
				}
			}
			for (int i=1; i<=N; i++) {
				if (used[i]!=n) {
					erased[i]=true;
				}
			}
		}
		
		int count=0;
		StringBuilder sb=new StringBuilder();
		for (int i=1; i<=N; i++) {
			if (!erased[i]) {
				count++;
				sb.append(i).append("\n");
			}
		}
		System.out.println(count);
		System.out.println(sb);
		br.close();
	}

}
