import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ12851 {
// Baekjoon 12851. 숨바꼭질 2

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input12851.txt"));
		Scanner sc=new Scanner(new InputStreamReader(System.in));
		int N=sc.nextInt();
		int K=sc.nextInt();
		
		if (N>=K) {
			System.out.println(N-K);
			System.out.println(1);
			System.exit(0);
		}
		
		boolean[] visited=new boolean[100001];
		int[] count=new int[100001];
		Queue<Integer> queue=new LinkedList<Integer>();
		queue.add(N);
		visited[N]=true;
		int sum=0;
		while(!queue.isEmpty()) {
			int size=queue.size();
			boolean[] temp=new boolean[100001];		// 현재 큐 사이즈 만큼 방문체크 따로
			for (int s=0; s<size; s++) {
				int cur=queue.poll();
				if (count[cur]==0) {
					count[cur]=1;
				}
				
				if (cur==K) {
					System.out.println(sum);
					System.out.println(count[cur]);
					System.exit(0);
				}
				
				if (cur>0 && (!visited[cur-1] || temp[cur-1])) {	// 아예 나온적 없거나 현재 큐 사이즈 동안 중복해서 나온 경우 
					if (!visited[cur-1]) {
						visited[cur-1]=true;
						queue.add(cur-1);
					}
					temp[cur-1]=true;
					count[cur-1]+=count[cur];
				}
				
				if (cur<100000 && (!visited[cur+1] || temp[cur+1])) {	// 아예 나온적 없거나 현재 큐 사이즈 동안 중복해서 나온 경우 
					if (!visited[cur+1]) {
						visited[cur+1]=true;
						queue.add(cur+1);
					}
					temp[cur+1]=true;
					count[cur+1]+=count[cur];
				}				
				
				if (cur*2<100001 && (!visited[cur*2] || temp[cur*2])) {	// 아예 나온적 없거나 현재 큐 사이즈 동안 중복해서 나온 경우 
					if (!visited[cur*2]) {
						visited[cur*2]=true;
						queue.add(cur*2);
					}
					temp[cur*2]=true;
					count[cur*2]+=count[cur];
				}
				
			}
			
			sum++;
		}
		
	}

}
