package com.ssafy.day2;

import java.util.Arrays;

// n개의 리스트 순열 
public class PermutationTest2 {
	static int R=2;
	static int[] input;
	static int[] nums;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		input = new int[] {1,3,6,9};
		nums  = new int[R];
		isSelected = new boolean[input.length];	// 숫자의 인덱스 사용
		perm(0);	// 아무것도 안뽑아서 0부터 시작.

	}
	
	private static void perm(int cnt) {
		if (cnt == R) {
			System.out.println(Arrays.toString(nums));
			return;
		}
		
		for (int i=0; i<input.length; i++) {
			if (isSelected[i]) {	// 사용중인 수면 다음수로.
				continue;
			}
			
			nums[cnt] = input[i];
			isSelected[i] = true;
			
			perm(cnt+1);			
			isSelected[i] = false;	// 다 채워지면 리셋
		}
	}
}
