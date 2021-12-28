import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ5014 {
// Baekjoon 5014. 스타트링크
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input5014.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int F=Integer.parseInt(st.nextToken());
		int S=Integer.parseInt(st.nextToken());
		int G=Integer.parseInt(st.nextToken());
		int U=Integer.parseInt(st.nextToken());
		int D=Integer.parseInt(st.nextToken());
		
		StringBuilder sb=new StringBuilder();
		boolean[] visited=new boolean[F+1];
		Queue<Integer> queue=new LinkedList<Integer>();
		queue.add(S);
		int count=0;
		
		if (F<U||(S<G&&U==0)||(S>G&&D==0)) {
			System.out.println("use the stairs");
		} else {
			loop:
			while(!queue.isEmpty()) {
				int size=queue.size();
				for (int s=0; s<size; s++) {
					int cur=queue.poll();
					if (cur==G) {		// 도착
						break loop;
					}
					
					if (cur+U<=F&&!visited[cur+U]) {
						visited[cur+U]=true;
						queue.add(cur+U);
					}
					
					if (cur-D>0&&!visited[cur-D]) {
						visited[cur-D]=true;
						queue.add(cur-D);
					}
				}
				
				if (queue.size()==0) {		// 이동 아예 못함
					System.out.println("use the stairs");
					System.exit(0);
				}
				count++;
			}
			System.out.println(count);
		}
		
		br.close();
		
		
	}

}
