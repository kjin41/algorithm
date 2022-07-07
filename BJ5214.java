import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ5214 {
// Baekjoon 5214. 환승
	static int N, K, M;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input5214.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr=new int[M][K];
		boolean[] visitedN=new boolean[N+1];
		boolean[] visitedM=new boolean[M];
		for (int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j=0; j<K; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr[i]);
		}
		
		int count=0;
		Queue<Integer> queue=new LinkedList<Integer>();
		queue.add(1);
		visitedN[1]=true;
		while(!queue.isEmpty()) {
			count++;
			int size=queue.size();
			for (int s=0; s<size; s++) {
				int cur=queue.poll();
				if (cur==N) {
					System.out.println(count);
					System.exit(0);
				}
				for (int i=0; i<M; i++) {
					if (visitedM[i] || !exist(cur, i))	continue;
					visitedM[i]=true;
					for (int j=0; j<K; j++) {
						if (!visitedN[arr[i][j]]) {
							queue.add(arr[i][j]);
							visitedN[arr[i][j]]=true;
						}
					}
					
				}
			}
		}
		
		System.out.println(-1);
		
		br.close();
	}

	private static boolean exist(int cur, int i) {
		int l=0, r=K-1;
		while (l<=r) {
			int mid=(l+r)/2;
			if (arr[i][mid]==cur) {
				return true;
			} else if (arr[i][mid]<cur) {
				l=mid+1;
			} else {
				r=mid-1;
			}
		}
		
		return false;
	}

}
