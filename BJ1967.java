import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1967 {
// Baekjoon 1967. 트리의 지름
	static class Child implements Comparable<Child>{
		int parent, weigth;

		public Child(int parent, int weigth) {
			super();
			this.parent = parent;
			this.weigth = weigth;
		}

		@Override
		public int compareTo(Child o) {
			return o.weigth-this.weigth;	// 가중치 높은 순으로 정렬
		}
		
	}
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1967.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		Child[] childList=new Child[N+1];
		for (int i=0; i<N-1; i++) {
		    StringTokenizer st=new StringTokenizer(br.readLine());
		    int parent=Integer.parseInt(st.nextToken());
		    int child=Integer.parseInt(st.nextToken());
		    int weigth=Integer.parseInt(st.nextToken());
		    childList[child]=new Child(parent, weigth);
		}
	    childList[1]=new Child(0, 0);	// 반복 돌기위한 초기값 세팅
		int parent=childList[N].parent;
	    int max=0;
	    PriorityQueue<Child> pq=new PriorityQueue<>();
	    for (int i=N; i>0; i--) {
	    	Child cur=childList[i];
	        if (cur.parent!=parent) {
	            int weigth=pq.poll().weigth;
	            childList[parent].weigth+=weigth;   // 부모에 자식들의 가중치 중 가장 큰 값 누적
	            if (!pq.isEmpty()) {
	            	weigth+=pq.poll().weigth;	// 부모에 자식들의 가중치 중 두번째로 큰 값 누적
	            }
	            max=Math.max(max, weigth);
	            
	            parent=cur.parent;   // 다음 부모로 변경
	            pq.clear();
	        }
        	pq.add(cur);
	    }
	     
	    System.out.println(max);
	      
	    br.close();
	}

}