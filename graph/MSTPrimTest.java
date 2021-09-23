package com.ssafy.graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MSTPrimTest {
// 최소 신장 트리 프림
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("prim_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int adjMatrix[][] = new int[N][N];
		boolean[] visited = new boolean[N];
		int[] minEdge = new int[N];
		
		StringTokenizer st = null;
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
			minEdge[i] = Integer.MAX_VALUE;
		}
		
		int result=0;
		minEdge[0]=0;
		
		for (int i=0; i<N; i++) {
			// 1. 신장트리에 포함되지 않은 정점중에 최소간선비용의 정점찾기
			int min = Integer.MAX_VALUE;
			int minVertex = -1;	// 최소간선비용의 정점
			for (int j=0; j<N; j++) {
				if (!visited[j] && min>minEdge[j]) {	// 신장트리에 포함되지않고 최소비용일때
					min = minEdge[j];
					minVertex = j;
				}
			}
			
			visited[minVertex]=true;	// 신장트리에 포함.
			result+=min;	// 간선 비용 누적
			
			
			// 2. 선택된 정점 기준으로 신장트리에 연결되지 않은 타 정점과의 간선비용 최소로 업데이트
			for (int j=0; j<N; j++) {
				int temp = adjMatrix[minVertex][j];
				if (!visited[j] && temp!=0 && minEdge[j]>temp) {
					minEdge[j]=temp;
				}
			}
			
		}
		
		System.out.println(result);
		
	}

}
