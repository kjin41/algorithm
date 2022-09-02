import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA8898_4 {
// SW Expert Academy 8898. 3차원 농부 
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input8898.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		StringBuilder sb=new StringBuilder();
		for (int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			st=new StringTokenizer(br.readLine());
			int c1=Integer.parseInt(st.nextToken());
			int c2=Integer.parseInt(st.nextToken());
			int[] arr1=new int[N];
			int[] arr2=new int[M];
			st=new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				arr1[i]=Integer.parseInt(st.nextToken());
			}
			st=new StringTokenizer(br.readLine());
			for (int i=0; i<M; i++) {
				arr2[i]=Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr1);
			Arrays.sort(arr2);
			
			int n=0, m=0;
			int count=0;
			int min=Integer.MAX_VALUE;
			
			while(n<N&&m<M) {
				int d=Math.abs(arr1[n]-arr2[m]);
				if (min>d) {
					min=d;
					count=1;
				} else if (min==d) {
					count++;
				}
				if (arr1[n]>arr2[m])	m++;
				else n++;
			}
			
			
			sb.append(min+Math.abs(c1-c2)).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
		
		
		br.close();
	}

}
