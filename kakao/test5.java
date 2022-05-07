import java.util.*;

public class test5 {
//	{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}	{"ShiftRow", "Rotate", "ShiftRow", "Rotate"}
	public static void main(String[] args) {
		int[][] rc={{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
		String[] operations={"ShiftRow", "Rotate", "ShiftRow", "Rotate"};
		int R=rc.length;
		int C=rc[0].length;
		for (String s:operations) {
			if ("ShiftRow".equals(s)) {
				shiftrow(rc, R, C);
			} else {
				rotation(rc, R, C);
			}
//			for (int i=0; i<R; i++) {
//				System.out.println(Arrays.toString(rc[i]));
//			}
//			System.out.println();
		}
		
		
	}

	private static void rotation(int[][] rc, int R, int C) {
		int temp=rc[0][0];
		int r=0;
		int c=0;
		int i=r;
		int j=c;
		for (i=r; i<R-1; i++) {
			rc[i][c]=rc[i+1][c];
		}
		r=i;
		
		for (j=c; j<C-1; j++) {
			rc[r][j]=rc[r][j+1];
		}
		c=j;
		
		for (i=r; i>0; i--) {
			rc[i][c]=rc[i-1][c];
		}
		r=i;
		
		for (j=c; j>0; j--) {
			rc[r][j]=rc[r][j-1];
		}
		c=j;
		
		rc[0][1]=temp;
	}

	private static void shiftrow(int[][] rc, int R, int C) {
		int[] temp=rc[R-1].clone();
		for (int i=R-1; i>0; i--) {
			rc[i]=rc[i-1].clone();
		}
		rc[0]=temp.clone();
	}

}
