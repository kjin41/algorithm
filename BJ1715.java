import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BJ1715 {
// Baekjoon 1715. 카드 정렬하기
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1715.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		int[] arr=new int[N];
		PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		});
		
		for (int i=0; i<N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		int count=0;
		while(pq.size()!=1) {
			int temp=pq.poll()+pq.poll();
			count+=temp;
			pq.add(temp);
		}
		
		System.out.println(count);
		
		
		br.close();
	}

}
