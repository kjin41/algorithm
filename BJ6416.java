import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class BJ6416 {
// Baekjoon 6416. 트리인가?
	
	static class Node {
		int n, p;	// 자기자신, 부모

		public Node(int n, int p) {
			super();
			this.n = n;
			this.p = p;
		}
		
	}
	static HashMap<Integer, Integer>map=new HashMap<>();
	static boolean flag=true;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input6416.txt"));
		StringBuilder sb=new StringBuilder();
		Scanner sc=new Scanner(new InputStreamReader(System.in));
		int i=1;
		while(true) {
			int p=sc.nextInt();
			int n=sc.nextInt();
			if (p==-1)	break;
			else if (p==0) {
				if (flag&&isTree()) {
					sb.append("Case ").append(i++).append(" is a tree.\n");
				} else {
					sb.append("Case ").append(i++).append(" is not a tree.\n");
				}
				map=new HashMap<>();
				flag=true;
			} else {
				if (map.put(n, p)!=null) {
					flag=false;
				}
			}
		}
		System.out.println(sb);
		sc.close();
	}
	
	static int find(int a, int o, int count) {
		if (!flag)	return o;
		if (a==o)	count++;	// 자기자신이 부모로 나올 경우 
		if (count>1)	flag=false;		// 사이클 방지
		if (map.get(a)==null)	return a;
		int p=find(map.get(a), o, count);
		if (map.get(a)!=p)	map.put(a, p);
		return p;
	}
	
	private static boolean isTree() {
		int root=0;
		for (Entry<Integer, Integer> node: map.entrySet()) {
			root=find(node.getKey(), node.getKey(), 0);
		}
		if (!flag)	return false;
		
		for (Entry<Integer, Integer> node: map.entrySet()) {
			if (root!=node.getValue())	return false;
		}
		
		return true;
	}

}
