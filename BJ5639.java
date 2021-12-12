import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ5639 {
// Baekjoon 5639. 이진 검색 트리
	static class Node{
		int value;
		Node left;
		Node right;
		
		public Node(int value) {
			this.value = value;
			this.left=null;
			this.right=null;
		}
		
	}
	
	static Node root;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input5639.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		for(String str=br.readLine(); str!=null; str=br.readLine()) {
			int value=Integer.parseInt(str);
			if (root==null) {
				root=new Node(value);
			} else {
				Node temp=root;
				while(true) {
					if (temp.value<value) {
						if (temp.right==null) {
							temp.right=new Node(value);
							break;
						} else {
							temp=temp.right;
						}
					} else {
						if (temp.left==null) {
							temp.left=new Node(value);
							break;
						} else {
							temp=temp.left;
						}
					}
				}
			}
		}
		postOrder(root);
//		preOrder(root);
//		inOrder(root);	// 크기 순으로 정렬됨.
		
		br.close();
	}
	
	private static void postOrder(Node cur) {
		if (cur==null) {
			return;
		}
		postOrder(cur.left);
		postOrder(cur.right);
		System.out.println(cur.value);
	}
	
	private static void preOrder(Node cur) {
		if (cur==null) {
			return;
		}
		System.out.println(cur.value);
		preOrder(cur.left);
		preOrder(cur.right);
	}
	
	private static void inOrder(Node cur) {
		if (cur==null) {
			return;
		}
		inOrder(cur.left);
		System.out.println(cur.value);
		inOrder(cur.right);
	}

}
