import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1068 {
// Baekjoon 1068. 트리
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1068.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		ArrayList<Integer>[] list=new ArrayList[N];	// 자식을 담는 리스트
		boolean[] deleted=new boolean[N];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			int parent=Integer.parseInt(st.nextToken());
			if (parent==-1) {	// 부모가 없을 경우
				continue;
			}
			if (list[parent]==null) {
				list[parent]=new ArrayList<>();
			}
			list[parent].add(i);		// 부모인덱스에 자식 추가
		}
		
		
		int delete=Integer.parseInt(br.readLine());
		int leaf=0;
		
			Queue<Integer> queue=new LinkedList<Integer>();
			queue.add(delete);
			while(!queue.isEmpty()) {
				int cur=queue.poll();
				deleted[cur]=true;
				if (list[cur]!=null) {
					for (int i: list[cur]) {
						queue.add(i);
					}
				}
				
			}
		
		for (int i=0; i<N; i++) {
			boolean flag=false;
			if (!deleted[i]) {
				if (list[i]==null) {	// 지워지지 않았고 널이면 자식이 없는 것
					flag=true;
				} else {
					flag=true;
					for (int index: list[i]) {	    // 자식들이 있는데 다 지워진 경우
						if (!deleted[index]) {
							flag=false;
							break;
						}
					}
				}
			}
			if (flag) {
				leaf++;
			}
		}
		
		System.out.println(leaf);
		
		br.close();
	}

}
