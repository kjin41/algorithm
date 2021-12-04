package day211204;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11660 {
// BJ.11660 구간 합 구하기5
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input11660.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringBuilder sb=new StringBuilder();
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int[][] arr=new int[N+1][N+1];
		for (int i=1; i<=N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j=1; j<=N; j++) {
				arr[i][j]=arr[i][j-1]+Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int x1=Integer.parseInt(st.nextToken());
			int y1=Integer.parseInt(st.nextToken());
			int x2=Integer.parseInt(st.nextToken());
			int y2=Integer.parseInt(st.nextToken());
			int sum=0;
			for (int r=x1; r<=x2; r++) {
				sum+=arr[r][y2]-arr[r][y1-1];
			}
			sb.append(sum).append("\n");
			
		}
		System.out.println(sb);
		
		br.close();
	}

}
