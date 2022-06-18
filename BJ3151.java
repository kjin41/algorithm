import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ3151 {
// Baekjoon 3151. 합이 0
	static int N;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input3151.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		int[] arr=new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		long count=0;
		for (int i=0; i<N-2; i++) {
			for (int j=i+1; j<N-1; j++) {
				int num=-(arr[i]+arr[j]);
				int left=bsLeft(arr, j+1, N-1, num);
				int right=bsRight(arr, j+1, N-1, num);
				if (left<=right) {
					count+=right-left+1;
				}
			}
		}
				
		System.out.println(count);
		br.close();
	}

	private static int bsLeft(int[] arr, int left, int right, int num) {	
		// 해당 값중 가장 작은 인덱스
		// 없으면 바로 다음 큰 인덱스
		int mid=left;
		while (left<=right) {
			mid=(left+right)/2;
			if (arr[mid]<num) {
				left=mid+1;
			} else {
				right=mid-1;
			}
		}
		
		return left;
	}
	
	private static int bsRight(int[] arr, int left, int right, int num) {	
		// 해당 값중 가장 큰 인덱스
		// 없으면 바로 다음 작은 인덱스
		int mid=left;
		while (left<=right) {
			mid=(left+right)/2;
			if (arr[mid]<=num) {
				left=mid+1;
			} else {
				right=mid-1;
			}
		}
		
		return right;
	}

}
