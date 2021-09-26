import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ14889 {
// Baekjoon 14889. 스타트와 링크
// N/2로 나누는 조합
// 나눈뒤 능력치 합한 후 차이 비교	
	static int N, min=10000;
	static int[] temp;
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input14889.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		temp = new int[N/2];
		arr=new int[N][N];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		comb(0, 0);
		System.out.println(min);
	}
	
	private static void comb(int start, int cnt) {
		if (cnt==N/2) {
			boolean team[]=new boolean[N];
			for (int i=0; i<N/2; i++) {
				team[temp[i]]=true;
			}
			
			// 각 팀마다 능력치 합 구하기
			int sum1=sinergy(team, true); 
			int sum2=sinergy(team, false);
				
			min=Math.min(min, Math.abs(sum1-sum2));
			
			return;
		}
		
		for (int i=start; i<N; i++) {
			temp[cnt]=i;
			comb(i+1, cnt+1);
		}
		
		
	}

	private static int sinergy(boolean[] team, boolean flag) {
		int sum=0;
		for (int i=0; i<N; i++) {
			if (team[i]==flag) {
				for (int j=i+1; j<N; j++) {
					if (team[j]==flag) {
						sum+=arr[i][j];
						sum+=arr[j][i];
					}
				}
			}
		}
		
		return sum;
	}

	
}
