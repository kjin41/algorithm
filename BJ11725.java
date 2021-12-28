import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ11725 {
// Baekjoon 11725. 트리의 부모 찾기
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input11725.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		ArrayList<Integer>[] list=new ArrayList[N+1];
		for (int i=0; i<=N; i++) {
			list[i]=new ArrayList<>();
		}
		
		for (int i=0; i<N-1; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int A=Integer.parseInt(st.nextToken());
			int B=Integer.parseInt(st.nextToken());
			list[A].add(B);
			list[B].add(A);
		}
		
		int[] parent=new int[N+1];
		Queue<Integer> queue=new LinkedList<Integer>();
		queue.add(1);
		while(!queue.isEmpty()) {
			int p=queue.poll();
			for (int c: list[p]) {
				if (parent[c]==0) {
					parent[c]=p;
					queue.add(c);
				}
			}
		}
		
		StringBuilder sb=new StringBuilder();
		for (int i=2; i<=N; i++) {
			sb.append(parent[i]).append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
	}

}
