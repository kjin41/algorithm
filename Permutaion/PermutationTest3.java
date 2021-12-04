package com.ssafy.day2;

import java.util.Arrays;

// n개의 리스트 순열 
// 비트 마스크 사용
public class PermutationTest3 {
	static int R=3;
	static int[] input;
	static int[] nums;
	
	public static void main(String[] args) {
		input = new int[] {1,3,6,9};
		nums  = new int[R];
		perm(0, 0);	// 아무것도 안뽑아서 0부터 시작.

	}
	
	private static void perm(int cnt, int flag) {
		if (cnt == R) {
			System.out.println(Arrays.toString(nums));
			return;
		}
		
		for (int i=0; i<input.length; i++) {
			if ((flag & 1<<i)!=0) {	// 현재 자리에 선택했으면
				continue;			// 다음 자리
			}
			
			nums[cnt] = input[i];
			
			perm(cnt+1, flag | 1<<i);	// 현재 자리 선택하고 넘김.
		}
	}
}
