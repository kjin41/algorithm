import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BJ15652 {
// Baekjoon 15652. N과 M (4)
// 중복 조합
	
	static int N, M;
	static int[] temp;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input15652.txt"));
		Scanner sc=new Scanner(new InputStreamReader(System.in));
		N=sc.nextInt();
		M=sc.nextInt();
		temp=new int[M];
		comb(1,0);
		
		
		sc.close();
	}

	private static void comb(int start, int count) {
		if (count==M) {
			for (int i=0; i<M; i++) {
				System.out.print(temp[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for (int i=start; i<=N; i++) {
			temp[count]=i;
			comb(i, count+1);
		}
		
	}

}
