package day211204;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1865 {
// SW Expert Academy 1965. 동철이의 일 분배
// 순열, 백트래킹
	static int N;
	static double result;
	static int[][] arr;
	
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1865.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for (int t=1; t<=T; t++) {
			StringBuilder sb=new StringBuilder();
			sb.append("#").append(t).append(" ");
			N=Integer.parseInt(br.readLine());
			arr=new int[N][N];
			result=0.0;
			for (int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j=0; j<N; j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			perm(0, 0, 1.0);
			String str=(int)Math.round(result*100*1000000)/1000000.0+"";
			sb.append(str);
			String[] list=str.split("\\.");
			for(int i=0; i<6-list[1].length(); i++) {
				sb.append(0);
			}
			System.out.println(sb);
		}
		
		br.close();
	}


	private static void perm(int cnt, int flag, double mul) {
		if (mul<result || mul==0.0) {
			return;
		}
		if (cnt==N) {
			if (result<mul) {
				result=mul;
			}
			return;
		}
		
		for (int i=0; i<N; i++) {
			if ((flag&1<<i)!=0) {
				continue;
			}
			perm(cnt+1, flag|1<<i, mul*arr[cnt][i]/100.0);
		}
	}

}
