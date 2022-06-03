import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ17490 {
// Baekjoon 17490. 일감호에 다리 놓기
	static int[] dist, construct;
	static int N, M;
	static long K, sum;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input17490.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		if (M<=1) {		// 공사중이 1이하이면 전부 연결
			System.out.println("YES");
			System.exit(0);
		}
		K=Long.parseLong(st.nextToken());
		dist=new int[N];
		construct=new int[M+1];
		st=new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			dist[i]=Integer.parseInt(st.nextToken());
		}
		for (int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken())-1;
			int b=Integer.parseInt(st.nextToken())-1;
			if (a<b&&b-a==1)	construct[i]=b;	// 큰 값을 넣어서 이어지는 돌의 시작점 저장
			else if (a>b&&a-b==1)	construct[i]=a;
			else construct[i]=0;
		}
		construct[M]=N;
		Arrays.sort(construct);
		construct[M]=construct[0]+N;	// 처음 인덱스를 마지막에 추가
		for (int i=0; i<M; i++) {
			sum+=addStone(i);
			if (sum>K) {
				System.out.println("NO");
				System.exit(0);
			}	
		}
		
		System.out.println("YES");
		
		br.close();
	}

	private static int addStone(int index) {
		int min=10000000;
		for (int i=construct[index]; i<construct[index+1]; i++) {
			min=Math.min(dist[i%N], min);
		}
		if (min==10000000)	return 0;
		return min;
	}

}
