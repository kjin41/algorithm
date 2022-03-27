import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BJ21939 {
// Baekjoon 21944. 문제 추천 시스템
// TreeSet

	static class Problem implements Comparable<Problem>{
		int P,L;

		public Problem(int p, int l) {
			super();
			P = p;
			L = l;
		}

		@Override
		public int compareTo(Problem o) {	// 난이도, 번호순 정렬
			if (this.L==o.L) {
				return this.P-o.P;
			}
			return this.L-o.L;
		}
		
	}
	
	static HashMap<Integer, Problem> problemMap=new HashMap<>();
	static TreeSet<Problem> treeSet=new TreeSet<>();
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input21939.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int N=Integer.parseInt(br.readLine());
		for (int i=0; i<N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			add(st);
		}
		
		int M=Integer.parseInt(br.readLine());
		for (int i=0; i<M; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			String cmd=st.nextToken();
			if ("add".equals(cmd)) {
				add(st);
				
			} else if ("recommend".equals(cmd)) {
				int flag=Integer.parseInt(st.nextToken());
				if (flag==1) {
					sb.append(treeSet.last().P).append("\n");
				} else {
					sb.append(treeSet.first().P).append("\n");
				}
				
			} else if ("solved".equals(cmd)) {
				int P=Integer.parseInt(st.nextToken());
				Problem find=problemMap.get(P);
				problemMap.remove(P);
				treeSet.remove(find);
			}
		}
		
		System.out.println(sb);
		br.close();
	}


	private static void add(StringTokenizer st) {
		int P=Integer.parseInt(st.nextToken());
		int L=Integer.parseInt(st.nextToken());
		
		problemMap.put(P, new Problem(P, L));
		treeSet.add(new Problem(P, L));
	}

}
