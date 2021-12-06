import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ7795 {
// Baekjoon 7795. 먹을 것인가 먹힐 것인가
// 정렬 후 비교
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input7795.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			int[] A=new int[N];
			int[] B=new int[M];
			st=new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				A[i]=Integer.parseInt(st.nextToken());
			}
			st=new StringTokenizer(br.readLine());
			for (int i=0; i<M; i++) {
				B[i]=Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(A);
			Arrays.sort(B);
			int count=0;
			for (int i=N-1; i>=0; i--) {
				for (int j=0; j<M; j++) {
					if(A[i]>B[j]) {
						count++;
					} else {
						break;
					}
				}
			}
			
			System.out.println(count);
			
		}
		
		br.close();
	}

}
