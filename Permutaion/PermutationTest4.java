package com.ssafy.day2;

import java.util.Arrays;

// n개의 리스트 순열 
// next permutation
public class PermutationTest4 {
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,3,6,9};
		Arrays.sort(arr);		// 먼저 오름차순 정렬
		
		do {
			System.out.println(Arrays.toString(arr));
		} while(np(arr));
		

	}
	
	// 다음 큰 순열이 있으면 true, 없으면 false
	private static boolean np(int[] arr) {
		int n = arr.length-1;
		int i=n;
		// 꼭대기 찾기
		while(i>0 && arr[i-1]>=arr[i]) --i;
		
		// 가장 큰 순열
		if (i==0) return false;
		
		int j=n;
		// i-1번째 다음으로 큰수랑 교환
		while(arr[i-1]>=arr[j]) --j;
		swap(arr, i-1, j);
		
		int k=n;
		// 꼭대기 뒤로는 내림차순 -> 오름차순으로 바꾸기
		while(i<k) {
			swap(arr, i++, k--);
		}
		
		return true;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
}
