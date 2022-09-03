import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ10971 {
// Baekjoon 10971. 외판원 순회 2
	static int N, min=Integer.MAX_VALUE;
	static int[][] arr;
	static int[] temp;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input10971.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr=new int[N][N];
		temp=new int[N]
;		for (int i=0; i<N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		perm(0, 0, 0);
		System.out.println(min);
		
		br.close();
	}

	private static void perm(int flag, int count, int sum) {
		if (min<sum)	return;
		if (count==N) {
			if (arr[temp[N-1]][temp[0]]==0)	return; 
			min=Math.min(min, sum+arr[temp[N-1]][temp[0]]);
			
			return;
		}
		
		for (int i=0; i<N; i++) {
			if ((flag & 1<<i)!=0)	continue;
			temp[count]=i;
			if (count==0)	perm(flag|1<<i, count+1, sum);
			else if (arr[temp[count-1]][i]!=0)	perm(flag|1<<i, count+1, sum+arr[temp[count-1]][i]);
			
		}
	}

}
