package com.ssafy.lis;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DPLISTest2 {
// n^2
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("inputlis.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] lis = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int max=0;
		for (int i=0; i<N; i++) {
			lis[i]=1;
			for (int j=0; j<i; j++) {
				if (arr[j]<arr[i] && lis[i]<lis[j]+1) {
					lis[i]=lis[j]+1;
				}
			}
			if (max<lis[i])	max=lis[i];
		}
		System.out.println(max);
	}

}
