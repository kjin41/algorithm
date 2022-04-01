import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ19238 {
// Baekjoon 19238. 스마트 택시
	static int N, M, F, tr, tc;
	static int[][] arr;
	static class Customer implements Comparable<Customer>{
		int posr, posc, destr, destc;

		public Customer(int posr, int posc, int destr, int destc) {
			super();
			this.posr = posr;
			this.posc = posc;
			this.destr = destr;
			this.destc = destc;
		}

		@Override
		public int compareTo(Customer o) {
			if (this.posr==o.posr) {
				return this.posc-o.posc;
			}
			return this.posr-o.posr;
		}
		
	}
	static Customer[] customers;
	static int[][] dir={{-1,0},{0,-1},{0,1},{1,0}};		// 상, 좌, 우, 하 -> 예외 발생
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input19238.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		F=Integer.parseInt(st.nextToken());
		arr=new int[N][N];
		customers=new Customer[M+1];
		for (int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				arr[i][j]=-Integer.parseInt(st.nextToken());	// 벽은 -1로 표기
			}
		}
		
		st=new StringTokenizer(br.readLine());
		tr=Integer.parseInt(st.nextToken())-1;
		tc=Integer.parseInt(st.nextToken())-1;
		for (int i=1; i<=M; i++) {
			st=new StringTokenizer(br.readLine());
			int posr=Integer.parseInt(st.nextToken())-1;
			int posc=Integer.parseInt(st.nextToken())-1;
			int destr=Integer.parseInt(st.nextToken())-1;
			int destc=Integer.parseInt(st.nextToken())-1;
			customers[i]=new Customer(posr, posc, destr, destc);
			arr[posr][posc]=i;
		}
		
		for (int i=0; i<M; i++) {
			boolean result=driveToCustomer();
			if (!result) {
				System.out.println(-1);
				System.exit(0);
			}
		}
		
		System.out.println(F);
		
		br.close();
	}

	private static boolean driveToCustomer() {
		PriorityQueue<Customer> pq=new PriorityQueue<>();
		Queue<int[]> queue=new LinkedList<int[]>();
		queue.add(new int[] {tr, tc});
		boolean[][] visited=new boolean[N][N];
		int count=0;
		while(!queue.isEmpty()) {
			int size=queue.size();
			for (int s=0; s<size; s++) {
				int[] cur=queue.poll();
				if (arr[cur[0]][cur[1]]>0) {
					pq.add(customers[arr[cur[0]][cur[1]]]);
				}
				
				for (int d=0; d<4; d++) {
					int nr=cur[0]+dir[d][0];
					int nc=cur[1]+dir[d][1];
					if (inRange(nr,nc)&&!visited[nr][nc]&&arr[nr][nc]!=-1) {
						queue.add(new int[] {nr,nc});
						visited[nr][nc]=true;
					}
				}
			}
			
			if (pq.size()!=0) {
				Customer cus=pq.poll();
				tr=cus.posr;
				tc=cus.posc;
				F-=count;
				if (F<0) {
					return false;
				}
				
				boolean result=driveToDest(arr[tr][tc]);
				arr[cus.posr][cus.posc]=0;
				if (!result) {
					return false;
				}
				return true;
			}
			count++;
		}
		
		return false;
	}

	private static boolean driveToDest(int index) {
		Customer cus=customers[index];
		int dr=cus.destr;
		int dc=cus.destc;
		Queue<int[]> queue=new LinkedList<int[]>();
		queue.add(new int[] {tr, tc});
		boolean[][] visited=new boolean[N][N];
		int count=0;
		while(!queue.isEmpty()) {
			int size=queue.size();
			for (int s=0; s<size; s++) {
				int[] cur=queue.poll();
				if (cur[0]==dr&&cur[1]==dc) {
					tr=cur[0];
					tc=cur[1];
					F-=count;
					if (F<0) {
						return false;
					}
					F+=2*count;
					return true;
				}
				
				
				for (int d=0; d<4; d++) {
					int nr=cur[0]+dir[d][0];
					int nc=cur[1]+dir[d][1];
					if (inRange(nr,nc)&&!visited[nr][nc]&&arr[nr][nc]!=-1) {
						queue.add(new int[] {nr,nc});
						visited[nr][nc]=true;
					}
				}
			}
			count++;
		}
		
		
		return false;
	}
	
	public static boolean inRange(int r, int c) {
		if (r>=0&&r<N&&c>=0&c<N) {
			return true;
		}
		return false;
	}

}
