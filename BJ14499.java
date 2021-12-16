import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14499 {
// Baekjoon 14499. 주사위 굴리기
	static int N,M,r,c,K;
	static int[][] arr;
	static int[] dice=new int[7];
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input14499.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		arr=new int[N][M];
		for (int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}

		st=new StringTokenizer(br.readLine());
		for (int i=0; i<K; i++) {
			roll(Integer.parseInt(st.nextToken()));
		}
		
		br.close();
	}

	private static void roll(int d) {
		int[][] dir= {{},{0,1},{0,-1},{-1,0},{1,0}};
		int nr=r+dir[d][0];
		int nc=c+dir[d][1];
		if (inRange(nr,nc)) {
			if (d==1) {
				rollDice(1,3,6,4);
			} else if (d==2) {
				rollDice(1,4,6,3);
			} else if (d==3) {
				rollDice(1,2,6,5);
			} else if (d==4) {
				rollDice(1,5,6,2);
			}
			
			if (arr[nr][nc]==0) {
				arr[nr][nc]=dice[6];
			} else {
				dice[6]=arr[nr][nc];
				arr[nr][nc]=0;
			}
			System.out.println(dice[1]);
			r=nr;
			c=nc;
		}
		
	}

	private static void rollDice(int a, int b, int c, int d) {
		int temp=dice[a];
		dice[a]=dice[d];
		dice[d]=dice[c];
		dice[c]=dice[b];
		dice[b]=temp;
	}

	private static boolean inRange(int r, int c) {
		if (r>=0&&r<N&&c>=0&&c<M) {
			return true;
		}
		return false;
	}

}
