import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ16496 {
// Baekjoon 16496. 큰 수 만들기
	static class Node implements Comparable<Node>{
//		int num;
		char[] num;
		long fill;

		public Node(char[] num, long fill) {
			super();
			this.num = num;
			this.fill = fill;
		}

		@Override
		public int compareTo(Node o) {	// 내림차순
			if (this.fill>o.fill)	return -1;
			else return 1;
		}
	}
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input16496.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		Node[] nodes=new Node[N];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			char[] num=st.nextToken().toCharArray();
			long fill=0l;
			for (int j=0; j<10; j++) {
				fill+=(num[j%num.length]-'0')*Math.pow(10, 9-j);
			}
			nodes[i]=new Node(num, fill);
		}
		Arrays.sort(nodes);
		if (nodes[0].num[0]=='0') {
			System.out.println(0);
			return;
		}
		StringBuilder sb=new StringBuilder();
		for (Node node: nodes) {
			for (Character c: node.num) {
				sb.append(c);
			}
		}
		
		System.out.println(sb);
		br.close();
	}
	

}
