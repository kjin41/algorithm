import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ2211 {
// Baekjoon 2211. 네트워크 복구
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input2211.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int[][] arr=new int[N+1][N+1];
		for (int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int A=Integer.parseInt(st.nextToken());
			int B=Integer.parseInt(st.nextToken());
			arr[A][B]=Integer.parseInt(st.nextToken());
			arr[B][A]=arr[A][B];
		}
		
		StringBuilder sb=new StringBuilder();
		Stack<int[]> stack=new Stack<>();
		boolean[] visited=new boolean[N+1];
		int[] distance=new int[N+1];
		for (int i=1; i<=N; i++) {
			distance[i]=1000000;
		}
		distance[1]=0;
		for (int i=0; i<N; i++) {
			int index=0;
			int min=1000000;
			for (int j=1; j<=N; j++) {
				if (!visited[j]&&min>distance[j]) {
					min=distance[j];
					index=j;
				}
			}
			visited[index]=true;
			
			for (int j=1; j<=N; j++) {
				if (!visited[j]&&arr[index][j]!=0&&distance[j]>min+arr[index][j]) {
					distance[j]=min+arr[index][j];
					stack.add(new int[] {index, j});	// 최단거리로 갱신될때 스택에 쌓기
				}
			}
		}
		
		int count=0;
		visited=new boolean[N+1];
		while (!stack.isEmpty()) {
			int[] cur=stack.pop();	// 마지막에 넣은것부터 빼면서
			if (!visited[cur[1]]) {	// 가장 최근에 목적지로 간게 가장 짧은 경로
				visited[cur[1]]=true;
				sb.append(cur[0]).append(" ").append(cur[1]).append("\n");
				count++;
			}
		}
		
		System.out.println(count);
		System.out.println(sb);
		
		br.close();
	}

}
