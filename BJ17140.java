import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ17140 {
// Baekjoon 17140. 이차원 배열과 연산
	
	static int[][] arr=new int[101][101];
	static int R, C, K, timer, rowLen=3, colLen=3;
	static class Node implements Comparable<Node>{
		int num, count;

		@Override
		public int compareTo(Node o) {
			if (this.count==o.count) {
				return this.num-o.num;
			}
			return this.count-o.count;
		}

		public Node(int num, int count) {
			super();
			this.num = num;
			this.count = count;
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input17140.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		for (int i=1; i<=3; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j=1; j<=3; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		while(arr[R][C]!=K && timer<101) {
			timer++;
			compute();
		}
		
		if (timer==101) {
			timer=-1;
		}
		
		System.out.println(timer);
		br.close();
	}
	
	private static void compute() {
		int maxLen=0;
		int[][] after=new int[101][101];
		if (rowLen>=colLen) {	// R 연산
			for (int i=1; i<=100; i++) {
				PriorityQueue<Node> pq=new PriorityQueue<>();
				int[] count=new int[101];
				for (int j=1; j<=100; j++) {
					count[arr[i][j]]++;
				}
				
				for (int j=1; j<=100; j++) {
					if (count[j]!=0) {
						pq.add(new Node(j, count[j]));
					}
				}
				maxLen=Math.max(maxLen, pq.size()*2);
				int index=1;
				while(!pq.isEmpty()) {
					Node cur=pq.poll();
					after[i][index++]=cur.num;
					after[i][index++]=cur.count;
				}
			}
			colLen=maxLen;
		} else {			// C 연산
			for (int j=1; j<=100; j++) {
				PriorityQueue<Node> pq=new PriorityQueue<>();
				int[] count=new int[101];
				for (int i=1; i<=100; i++) {
					count[arr[i][j]]++;
				}
				
				for (int i=1; i<=100; i++) {
					if (count[i]!=0) {
						pq.add(new Node(i, count[i]));
					}
				}
				maxLen=Math.max(maxLen, pq.size()*2);
				int index=1;
				while(!pq.isEmpty()) {
					Node cur=pq.poll();
					after[index++][j]=cur.num;
					after[index++][j]=cur.count;
				}
			}
			rowLen=maxLen;
		}
		arr=after;
	}

}
