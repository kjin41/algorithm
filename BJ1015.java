import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1015 {
// Baekjoon 1015. 수열 정렬
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1015.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] arr=new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int[] clone=arr.clone();
		Arrays.sort(clone);
		int[] result=new int[N];
		Arrays.fill(result, -1);
		boolean[] used=new boolean[N];
		for (int i=0; i<N; i++) {	// 정렬된 배열
			for (int j=0; j<N; j++) {
				if (clone[i]==arr[j]&&result[j]==-1) {
					result[j]=i;
					break;
				}
			}
		}
		
		StringBuilder sb=new StringBuilder();
		for (int i=0; i<N; i++) {
			sb.append(result[i]).append(" ");
		}
		
		System.out.println(sb);
		br.close();
	}

}
