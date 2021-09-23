package com.ssafy.graph;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MSTKruskalTest {
// 최소신장트리 크루스칼
	static class Edge implements Comparable<Edge>{
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
//			return this.weight-o.weight;
			return Integer.compare(this.weight, o.weight);	// 음수도 커버 가능
		}
		
	}
	
	static int V, E;
	static Edge[] edgeList;
	
	static int[] parents;

	private static void make() {
		parents = new int[V];
		for (int i=0; i<V; i++) {
			parents[i]=i;
		}
	}
	
	private static int find(int a) {
		if(a==parents[a])	return a;	// 자신이 대표자
		return parents[a] = find(parents[a]);	// 자신이 속한 집합의 대표자를 자신의 부모로: path compression
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot==bRoot)	return false;
		parents[bRoot]=aRoot;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input_kruskal.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		edgeList = new Edge[E];	// 간선리스트 작성
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(start, end, weight);
			
		}
		
		Arrays.sort(edgeList);	// 정렬이 동반되므로 간선이 많으면 시간이 오래걸림.
		make();	// 모든 정점을 각각 집합으로 만들고 출발
		
		int cnt=0, result=0; 
		for (Edge e: edgeList) {
			if (union(e.start, e.end)) {
				result+=e.weight;
				if (++cnt==V-1)	break;	// 신장 트리 완성
				
			}
		}
		System.out.println(result);
		
		
		
	}

}
