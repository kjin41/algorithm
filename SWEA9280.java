import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA9280 {
// SW Expert Academy 9280. 용진이네 주차타워
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input9280.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for (int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			
			int[] price=new int[N];
			int[] place=new int[N];
			for (int i=0; i<N; i++) {
				price[i]=Integer.parseInt(br.readLine());
			}
			int[] weight=new int[M+1];
			for (int i=1; i<=M; i++) {
				weight[i]=Integer.parseInt(br.readLine());
			}
			Queue<Integer> queue=new LinkedList<Integer>();
			int total=0;
			loop:
			for (int i=0; i<2*M; i++) {
				int num=Integer.parseInt(br.readLine());
				if (num>0) {
					for (int j=0; j<N; j++) {
						if (place[j]==0) {
							place[j]=num;
							total+=price[j]*weight[num];
							continue loop;
						}
					}
					queue.add(num);
				} else {
					num*=-1;
					int empty=0;
					for (int j=0; j<N; j++) {
						if (place[j]==num) {
							place[j]=0;
							empty=j;
							break;
						}
					}
					if (!queue.isEmpty()) {
						num=queue.poll();
						place[empty]=num;
						total+=price[empty]*weight[num];
					}
				}
			}
			sb.append(total).append("\n");
			
			
		}
		System.out.println(sb);
		br.close();
	}

}
