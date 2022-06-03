import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1991 {
// Baekjoon 1991. 트리 순회
	static class Node{
		int left, right;

		public Node(int left, int right) {
			super();
			this.left = left;
			this.right = right;
		}
	}
	
	static Node[] nodes;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1991.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		nodes=new Node[N];
		for (int i=0; i<N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int parent=st.nextToken().charAt(0)-'A';
			char left=st.nextToken().charAt(0);
			char right=st.nextToken().charAt(0);
			nodes[parent]=new Node(left=='.'?-1:left-'A', right=='.'?-1:right-'A');
		}
		printPreorder(0);
		System.out.println();
		printInorder(0);
		System.out.println();
		printPostorder(0);
		System.out.println();
		
		
		
		br.close();
	}
	
	private static void printPreorder(int index) {
		System.out.print((char)(index+'A'));
		if (nodes[index].left!=-1)	printPreorder(nodes[index].left);
		if (nodes[index].right!=-1)	printPreorder(nodes[index].right);
	}
	
	private static void printInorder(int index) {
		if (nodes[index].left!=-1)	printInorder(nodes[index].left);
		System.out.print((char)(index+'A'));
		if (nodes[index].right!=-1)	printInorder(nodes[index].right);
	}
	
	private static void printPostorder(int index) {
		if (nodes[index].left!=-1)	printPostorder(nodes[index].left);
		if (nodes[index].right!=-1)	printPostorder(nodes[index].right);
		System.out.print((char)(index+'A'));
	}

}
