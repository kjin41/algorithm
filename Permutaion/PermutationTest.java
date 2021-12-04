package com.ssafy.day2;

import java.util.Arrays;

//1, 2, 3 의 순열
public class PermutationTest {
	static int N=5, R=3;
	static int[] nums;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		nums  = new int[R];
		isSelected = new boolean[N+1];	// 1, 2, 3 인덱스 사용
		perm(0);	// 아무것도 안뽑아서 0부터 시작.

	}
	
	private static void perm(int cnt) {
		if (cnt == R) {
			System.out.println(Arrays.toString(nums));
			return;
		}
		
		for (int i=1; i<=N; i++) {
			if (isSelected[i]) {	// 사용중인 수면 다음수로.
				continue;
			}
			
			nums[cnt] = i;
			isSelected[i] = true;
			
			perm(cnt+1);			
			isSelected[i] = false;	// 다 채워지면 리셋
		}
	}
}
