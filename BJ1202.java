import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1202 {
// Baekjoon 1202. 보석 도둑
// 보석은 무게기준 오름차순, 가방도 오름차순으로 정렬
// 우선순위큐에서 보석 가격기준 내림차순으로 넣기
// 무게가 작은 가방부터 넣어보기
	
	static class Node implements Comparable<Node>{
		int M, V;

		public Node(int m, int v) {
			super();
			M = m;
			V = v;
		}

		@Override
		public int compareTo(Node o) {
			return this.M-o.M;	// 무게기준 오름차순
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1202.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		Node[] nodes=new Node[N];
		int[] bag=new int[K];
		for (int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			int m=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			nodes[i]=new Node(m, v);
		}
		
		for (int i=0; i<K; i++) {
			bag[i]=Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(nodes);
		Arrays.sort(bag);	// 오름차순
		long total=0;
		PriorityQueue<Node> pq=new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return o2.V-o1.V;	// 가격기준 내림차순
			}
		});
		
		int index=0;
		
		for (int i=0; i<K; i++) {	// 무게가 작은 가방부터
			while (index<N&&bag[i]>=nodes[index].M) {
				pq.add(nodes[index++]);
			}
			if (!pq.isEmpty()) {
				total+=pq.poll().V;
			}
		}
		
		
		System.out.println(total);
		
		
		br.close();
	}

}
