import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2252 {
// Baekjoon 2252. 줄 세우기
// 위상행렬
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input2252.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int[] order=new int[N+1];
		ArrayList<Integer>[] list=new ArrayList[N+1];
		for (int i=1; i<=N; i++) {
			list[i]=new ArrayList<>();
		}
		for (int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int A=Integer.parseInt(st.nextToken());
			int B=Integer.parseInt(st.nextToken());
			order[B]++;		// 높을수록 순서가 늦음
			list[A].add(B);	// 뒤에 오는 수들
		}
		
		int count=0;
		StringBuilder sb=new StringBuilder();
		while(count!=N) {
			Queue<Integer> queue=new LinkedList<>();
			for (int i=1; i<=N; i++) {
				if (order[i]==0) {	// 0순위
					order[i]--;		
					queue.add(i);	// 큐에 추가
					count++;
					sb.append(i).append(" ");
				}
			}
			
			while(!queue.isEmpty()) {
				int A=queue.poll();
				for (int B:list[A]) {
					order[B]--;		// 앞 수가 빠졌기 때문에 순서 하나씩 앞으로
				}
			}
		}
		
		System.out.println(sb);
		br.close();
	}

}
