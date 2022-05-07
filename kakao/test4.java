import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class test4 {
//	6	{{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}}	{1, 3}	{5}
	
//	static int n;
//	static int{}{} paths;
	
//	static int max=0;
	static int min=100000000;
	static ArrayList<Path>[] list;
	
	static class Path implements Comparable<Path>{
		int from, to, weight;


		public Path(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}


		@Override
		public int compareTo(Path o) {
			return this.weight-o.weight;
		}


		@Override
		public String toString() {
			return "Path [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}
		
		
		
	}
	
	public static void main(String[] args) {
//		{{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}}	{1, 3}	{5}
//		7, {{1, 4, 4}, {1, 6, 1}, {1, 7, 3}, {2, 5, 2}, {3, 7, 4}, {5, 6, 6}}, {1}, {2, 3, 4}
		int n=6;
		int[][] paths= {{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}};
		int[] gates= {1,3};
		int[] summits= {5};
		
		Arrays.sort(summits);
		
		
		int[] result= {0, 100000000};
		list=new ArrayList[n+1];
		
		for (int i=1; i<=n; i++) {
			list[i]=new ArrayList<>();
		}
		
		for (int i=0; i<paths.length; i++) {
			list[paths[i][0]].add(new Path(paths[i][0], paths[i][1], paths[i][2]));
			list[paths[i][1]].add(new Path(paths[i][1], paths[i][0], paths[i][2]));
		}
		
//		for (int i=1; i<=n; i++) {
//			System.out.println(i+" "+list[i]);
//		}
//		
//		System.out.println();
		for (int i=0; i<gates.length; i++) {
			for (int j=0; j<summits.length; j++) {
				int temp=climb(n, gates[i], summits[j], gates, summits);
				if (result[1]>temp) {
					min=temp;
					result[0]=summits[j];
					result[1]=temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(result));
		
	}
	
	private static int climb(int n, int gate, int summit, int[] gates, int[] summits) {
		int max=0;
		boolean flag=false;
		PriorityQueue<Path> pq=new PriorityQueue<>();
		boolean[] visited=new boolean[n+1];
		for (int g: gates) {
			visited[g]=true;
		}
		for (int s: summits) {
			visited[s]=true;
		}
		visited[gate]=false;
		visited[summit]=false;
		pq.add(new Path(0, gate, 0));
		while(!pq.isEmpty()){
			Path cur=pq.poll();
			if (visited[cur.to]) {
				continue;
			}
			visited[cur.to]=true;
			max=Math.max(max, cur.weight);
			if (max>min) {
				return 100000000;
			}
			if (cur.to==summit) {
				flag=true;
				break;
			}
			for (Path p: list[cur.to]) {
				pq.add(p);
			}
		}
		if (!flag) {
			return 100000000;
		}
		return max;
	}

}
