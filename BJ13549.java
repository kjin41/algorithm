import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ13549 {
// Baekjoon 13549. 숨바꼭질3
	static class Point implements Comparable<Point>{
		int x, cnt;

		public Point(int x, int cnt) {
			super();
			this.x = x;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Point o) {
			return this.cnt-o.cnt;
		}
		
	}
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input13549.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		boolean[] visited=new boolean[1000000];
		PriorityQueue<Point> pq=new PriorityQueue<>();
		pq.add(new Point(N, 0));
		int result=0;
		
		while(!pq.isEmpty()) {
			Point cur=pq.poll();
			if (cur.x==M) {
				result=cur.cnt;
				break;
			}
			if (visited[cur.x]) {
				continue;
			}
			visited[cur.x]=true;
			
			if (cur.x<M) {
				pq.add(new Point(cur.x*2, cur.cnt));
				pq.add(new Point(cur.x+1, cur.cnt+1));
			}
			if (cur.x>0) {
				pq.add(new Point(cur.x-1, cur.cnt+1));
			}
		}
		
		System.out.println(result);
		br.close();
	}

}
