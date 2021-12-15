import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ16953 {
// Baekjoon 16953. A -> B
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input16953.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int A=Integer.parseInt(st.nextToken());
		int B=Integer.parseInt(st.nextToken());
		int count=0;
		boolean flag=false;
		boolean[] visited=new boolean[B+1];
		Queue<Integer> queue=new LinkedList<Integer>();
		queue.add(A);
		visited[A]=true;
		loop:
		while(!queue.isEmpty()) {
			int size=queue.size();
			count++;
			for (int s=0; s<size; s++) {
				int cur=queue.poll();
				if (cur==B) {
					flag=true;
					break loop;
				}
				if (cur*2<=B&&!visited[cur*2]) {
					queue.add(cur*2);
					visited[cur*2]=true;
				}
				if ((long)cur*10+1<=(long)B&&!visited[cur*10+1]) {
					queue.add(cur*10+1);
					visited[cur*10+1]=true;
				}
			}
		}
		
		if (!flag) {
			count=-1;
		}
		System.out.println(count);
		br.close();
	}

}
