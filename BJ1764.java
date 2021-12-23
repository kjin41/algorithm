import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1764 {
// Baekjoon 1764. 듣보잡
// set
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1764.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		HashSet<String> set=new HashSet<>();
		StringBuilder sb=new StringBuilder();
		PriorityQueue<String> pq=new PriorityQueue<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		
		for (int i=0; i<N; i++) {
			set.add(br.readLine());
		}
		
		for (int i=0; i<M; i++) {
			String s=br.readLine();
			if (set.contains(s)) {
				pq.add(s);
			}
		}
		
		sb.append(pq.size()).append("\n");
		while(!pq.isEmpty()) {
			sb.append(pq.poll()).append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
		

	}

}
