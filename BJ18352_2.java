import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ18352_2 {
// Baekjoon 18352. 특정 거리의 도시 찾기
// Arraylist
// bfs
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input18352.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int X=Integer.parseInt(st.nextToken());
//		int[][] arr=new int[N+1][N+1];
		ArrayList<Integer>[] list=new ArrayList[N+1];
		for (int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int A=Integer.parseInt(st.nextToken());
			int B=Integer.parseInt(st.nextToken());
//			arr[A][B]=1;
			if (list[A]==null) {
				list[A]=new ArrayList<>();
			}
			list[A].add(B);
		}
		
		boolean[] visited=new boolean[N+1];
		visited[X]=true;
		Queue<Integer> queue=new LinkedList<Integer>();
		ArrayList<Integer> answer=new ArrayList<>();
		StringBuilder sb=new StringBuilder();
		queue.add(X);

		for (int i=0; i<K; i++) {
			int size=queue.size();
			for (int s=0; s<size; s++) {
				int cur=queue.poll();
				if (list[cur]==null) {
					continue;
				}
				for (int l: list[cur]) {
					if (!visited[l]) {
						queue.add(l);
						visited[l]=true;
					}
				}
			}
		}
		
		if (queue.size()==0) {
			sb.append(-1);
		} else {
			for (int q: queue) {
				answer.add(q);
			}
			
			Collections.sort(answer);
			
			for (int ans: answer) {
				sb.append(ans).append("\n");
			}
		}
		
		System.out.println(sb);
		
		br.close();
	}

}
