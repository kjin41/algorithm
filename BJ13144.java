import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ13144 {
// Baekjoon 13144. List of Unique Numbers
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input13144.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] arr=new int[100001];	// 해당 숫자에 인덱스 대입
		long count=0l;
		Queue<int[]> queue=new LinkedList<int[]>();
		StringTokenizer st=new StringTokenizer(br.readLine());
		for (int i=1; i<=N; i++) {
			int num=Integer.parseInt(st.nextToken());
			if (arr[num]!=0) {
				int n=0; 
				int size=queue.size();
				while(true) {
					int[] cur=queue.poll();
					n++;
					arr[cur[1]]=0;		// 인덱스 0으로 초기화
					if (cur[1]==num) {
						break;
					}
				}
				count+=sum(size)-sum(size-n);
			}

			arr[num]=i;
			queue.add(new int[] {i, num});
			
		}
		
		count+=sum(queue.size());
		
		System.out.println(count);
		
		
		
		br.close();
	}

	private static long sum(int n) {
		return (long)n*(n+1)/2;
	}	

}
