import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ19942 {
// Baekjoom 19942. 다이어트
	static int N, price=100000;
	static int[] temp, components;
	static int[][] arr;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input19942.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		components=new int[4];
		temp=new int[N+1];
		arr=new int[N+1][5];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for (int i=0; i<4; i++) {
			components[i]=Integer.parseInt(st.nextToken());
		}
		
		for (int i=1; i<=N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j=0; j<5; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		comb(1, 0, new int[] {0, 0, 0, 0, 0});
		
		if (price==100000) {
			System.out.println(-1);
		} else {
			System.out.println(price);
			System.out.println(sb);
		}
		br.close();
	}


	private static void comb(int start, int cnt, int[] sum) {
		if (price<=sum[4]) {
			return;
		}
		boolean flag=true;
		for (int i=0; i<4; i++) {
			if (components[i]>sum[i]) {
				flag=false;
				break;
			}
		}
		
		if (flag) {
			price=sum[4];
			sb=new StringBuilder();
			for (int i=0; i<cnt; i++) {
				sb.append(temp[i]).append(" ");
			}
			return;
		}
		
		if (cnt==N) {
			return;
		}
		
		for (int i=start; i<=N; i++) {
			temp[cnt]=i;
			comb(i+1, cnt+1, new int[] {sum[0]+arr[i][0], sum[1]+arr[i][1], sum[2]+arr[i][2], sum[3]+arr[i][3], sum[4]+arr[i][4]});
		}
	}

}
