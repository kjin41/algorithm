import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1654 {
// Baekjoon 1654. 랜선 자르기
// 이분 탐색
	
	static int K, N, C;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1654.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		K=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		arr=new int[K];
		long total=0l;
		for (int i=0; i<K; i++) {
			arr[i]=Integer.parseInt(br.readLine());
			total+=arr[i];
		}

		long len=total/N+1;
		binarySearch(1l, len);
		
		
		br.close();
	}
	
	private static void binarySearch(long left, long right) {
		long count=0;
		long mid=(left+right)/2;
		if (left<=0) {
			left=1;
		}
		for (int i=0; i<K; i++) {
			count+=arr[i]/left;
		}
		
		if (left+1==right && count>=N) {
			System.out.println(left);
			return;
		}

		if (count<N) {
			binarySearch(2*left-right-1, left);	// 20~30 -> 9~20
		} else {
			binarySearch(mid, right);		// 20~30 -> 25~30
		}
	}

}
