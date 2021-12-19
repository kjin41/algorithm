import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ21608 {
// Baekjoon 21608. 상어 초등학교
	static class shark{
		int num, a, b, c, d;

		public shark(int num, int a, int b, int c, int d) {
			super();
			this.num = num;
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
		}
	
	}
	
	static class seat implements Comparable<seat>{
		int likes, empty, r, c;

		public seat(int likes, int empty, int r, int c) {
			super();
			this.likes = likes;
			this.empty = empty;
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(seat o) {
			if (this.likes!=o.likes) {
				return o.likes-this.likes;
			} else if (this.empty!=o.empty) {
				return o.empty-this.empty;
			} else if( this.r!=o.r) {
				return this.r-o.r;
			}
			return this.c-o.c;
		}
		
	}
	
	static int N;
	static int[][] arr;
	static int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
	static shark[] sharks;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input21608.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr=new int[N][N];
		sharks=new shark[N*N+1];
		for (int i=0; i<N*N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int num=Integer.parseInt(st.nextToken());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			sharks[num]=new shark(num, a, b, c, d);
			sit(sharks[num]);
		}
		
		int total=0;
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				int sh=arr[i][j];
				int[] likes= {sharks[sh].a, sharks[sh].b, sharks[sh].c, sharks[sh].d};
				int like=0;
				for (int d=0; d<4; d++) {
					int nr=i+dir[d][0];
					int nc=j+dir[d][1];
					if (inRange(nr, nc)) {
						for (int l=0; l<4; l++) {
							if (arr[nr][nc]==likes[l]) {	// 좋아하는 친구가 있을때
								like++;
								break;
							}
						}
					}
				}
				
				total+=(int)Math.pow(10, like-1);
			}
		}
		
		System.out.println(total);
		
		br.close();
	}

	private static void sit(shark s) {
		int[] likes= {s.a, s.b, s.c, s.d};
		PriorityQueue<seat> pq=new PriorityQueue<>();
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (arr[i][j]==0) {				// 비어있는 한 자리에 대해
					int like=0;
					int empty=0;
					for (int d=0; d<4; d++) {	// 상하좌우를 살핀다
						int nr=i+dir[d][0];
						int nc=j+dir[d][1];
						if (inRange(nr, nc)){
							if (arr[nr][nc]==0) {	// 비어있는 자리일 때
								empty++;
							}
							
							for (int l=0; l<4; l++) {
								if (arr[nr][nc]==likes[l]) {	// 좋아하는 친구가 있을때
									like++;
									break;
								}
							}
						}
					}
					pq.add(new seat(like, empty, i, j));	// 비어있는 자리의 정보 넣기
				}
			}
		}
		
		seat ns=pq.poll();
		arr[ns.r][ns.c]=s.num;
	}

	private static boolean inRange(int r, int c) {
		if (r>=0&&r<N&&c>=0&&c<N) {
			return true;
		}
		return false;
	}

}
