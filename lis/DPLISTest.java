package com.ssafy.lis;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DPLISTest {
// nlogn
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("inputlis.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];	// 모든 원소의 값은 다르다
		int[] lis = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum=0;
		int size=0;
		for (int i=0; i<N; i++) {
			int index=Arrays.binarySearch(lis, 0, size, arr[i]);	// 항상 음수
			if (index<0)	{
				index=-1*index-1;
				lis[index]=arr[i];
				if (index==size)	size++;
			} else sum++;
		}
		System.out.println(size+sum);
	}

}
