import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BJ21944_3 {
// Baekjoon 21944. 문제 추천 시스템
// TreeSet

	static class Problem implements Comparable<Problem>{
		int P,L,G;

		public Problem(int p, int l, int g) {
			super();
			P = p;
			L = l;
			G = g;
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
	static TreeSet<Problem>[] treeSet=new TreeSet[101];	// 0: 유형상관없이 문제 정렬, 1~100: 유형별로 문제 정렬
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input21944.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int N=Integer.parseInt(br.readLine());
		for (int i=0; i<=100; i++) {
			treeSet[i]=new TreeSet<>();
		}
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
				int G=Integer.parseInt(st.nextToken());
				int flag=Integer.parseInt(st.nextToken());
				if (flag==1) {
					sb.append(treeSet[G].last().P).append("\n");	// 유형 G중 제일 어려운 문제
				} else {
					sb.append(treeSet[G].first().P).append("\n");	// 유형 G중 제일 쉬운 문제
				}
				
			} else if ("recommend2".equals(cmd)) {
				int flag=Integer.parseInt(st.nextToken());
				if (flag==1) {
					sb.append(treeSet[0].last().P).append("\n");	// 유형 상관없이 제일 쉬운 문제
				} else {
					sb.append(treeSet[0].first().P).append("\n");	// 유형 상관없이 제일 쉬운 문제
				}
				
			} else if ("recommend3".equals(cmd)) {
				int flag=Integer.parseInt(st.nextToken());
				int L=Integer.parseInt(st.nextToken());
				if (flag==1) {
					Problem find=treeSet[0].higher(new Problem(0, L, 0));	// 난이도 L보다 어렵거나 같은 문제
					if (find==null) {
						sb.append(-1).append("\n");
					} else {
						sb.append(find.P).append("\n");
					}
				} else {
					Problem find=treeSet[0].lower(new Problem(0, L, 0));	// 난이도 L보다 쉬운 문제
					if (find==null) {
						sb.append(-1).append("\n");
					} else {
						sb.append(find.P).append("\n");
					}
				}
				
			} else if ("solved".equals(cmd)) {
				int P=Integer.parseInt(st.nextToken());
				Problem find=problemMap.get(P);
				problemMap.remove(P);
				treeSet[0].remove(find);
				treeSet[find.G].remove(find);
			}
		}
		
		System.out.println(sb);
		br.close();
	}


	private static void add(StringTokenizer st) {
		int P=Integer.parseInt(st.nextToken());
		int L=Integer.parseInt(st.nextToken());
		int G=Integer.parseInt(st.nextToken());
		
		problemMap.put(P, new Problem(P, L, G));
		treeSet[0].add(new Problem(P, L, G));
		treeSet[G].add(new Problem(P, L, G));
	}

}
