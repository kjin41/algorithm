import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1007 {
// Baekjoon 1007. 벡터 매칭
	static int N;
	static int[] temp;
	static int[][] arr;
	static double min;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1007.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
			N=Integer.parseInt(br.readLine());
			arr=new int[N][2];
			temp=new int[N/2];
			for (int i=0; i<N; i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				arr[i][0]=Integer.parseInt(st.nextToken());
				arr[i][1]=Integer.parseInt(st.nextToken());
				
			}
			min=100000000;
			comb(0, 0);
			System.out.println(min);
		}
		
		br.close();
	}

	private static void comb(int start, int cnt) {
		if (cnt==N/2) {
//			double sum=sumVector();
			min=Math.min(min, sumVector());
			
			return;
		}
		
		for (int i=start; i<N; i++) {
			temp[cnt]=i;
			comb(i+1, cnt+1);
		}
	}

	private static double sumVector() {
		boolean[] plus=new boolean[N];
		for (int i=0; i<N/2; i++) {
			plus[temp[i]]=true;
		}
		
		double[] sum=new double[2];
		for (int i=0; i<N; i++) {
			if (plus[i]) {
				sum[0]+=arr[i][0];
				sum[1]+=arr[i][1];
			} else {
				sum[0]-=arr[i][0];
				sum[1]-=arr[i][1];
			}
		}
		
		return Math.sqrt(sum[0]*sum[0]+sum[1]*sum[1]);
		
	}

}
