import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ17178 {
// Baekjoon 17178. 줄서기
	
	static class Node implements Comparable<Node>{
		char c;
		int n;

		public Node(char c, int n) {
			super();
			this.c = c;
			this.n = n;
		}

		@Override
		public int compareTo(Node o) {
			if (this.c==o.c)	return this.n-o.n;
			return this.c-o.c;
		}

		@Override
		public String toString() {
			return "Node [c=" + c + ", n=" + n + "]";
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input17178.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int N=n*5;
		Node[] input=new Node[N];
		Node[] order=new Node[N];
		
		for (int i=0; i<n; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for (int j=0; j<5; j++) {
				String[] str=st.nextToken().split("-");
				input[i*5+j]=new Node(str[0].charAt(0), Integer.parseInt(str[1]));
				order[i*5+j]=new Node(str[0].charAt(0), Integer.parseInt(str[1]));
			}
		}
		
		Arrays.sort(order);
		
		String ans="GOOD";
		Stack<Node> stack=new Stack<>();
		int i=0, j=0;
		while (i<N&&j<N) {
			if (same(order[i], input[j])) {		// 맞는 순서
				i++; j++;
			} else {	// 다른 순서
				if (!stack.isEmpty()&&same(stack.peek(), order[i])){	// 대기줄에서 빠짐
					stack.pop();
					i++;
				} else if (stack.isEmpty()||isOrder(input[j], stack.peek())) {	// 대기줄로					
					stack.add(input[j]);
					j++;
				} else {
					ans="BAD";
					break;
				}
			}
		}
		
		System.out.println(ans);
		
		br.close();
	}

	private static boolean same(Node node1, Node node2) {
		if (node1.c==node2.c&&node1.n==node2.n)	return true;
		return false;
	}

	private static boolean isOrder(Node before, Node after) {
		if (before.c<after.c)	return true;
		if (before.c==after.c&&before.n<after.n)	return true;
		return false;
	}

}
