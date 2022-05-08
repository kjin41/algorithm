import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ22953 {
// Baekjoon 22953. 도도의 음식 준비
// 중복 조합
// 이분 탐색
	static int N, K, C;
	static long MAX=1000000000000l;
	static long min=MAX;
	static int[] arr, temp;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input22953.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		arr=new int[N];
		temp=new int[C];
		for (int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}

		comb(0, 0);
		System.out.println(min);
		br.close();
	}

	private static void comb(int start, int count) {
		if (count==C) {
			int[] after=arr.clone();
			for (int i=0; i<C; i++) {
				if (--after[temp[i]]==0) {
					after[temp[i]]++;	// 1초 미만으로 불가
				}
			}
			
			long left=1;
			long right=MAX;
			while(left<=right) {
				long mid=(left+right)/2;	// 시간
				long cook=0l;
				for (int i=0; i<N; i++) {
					cook+=mid/after[i];
				}
				if (cook<K) {	// 요리를 다 못함 -> 시간을 늘려야함
					left=mid+1;
				} else {	// 요리 가능 -> 최소값 넣고 시간 더 줄이기
					right=mid-1;
					min=Math.min(min, mid);
				}
			}
			
			
			return;
			
		}
		
		for (int i=start; i<N; i++) {
			temp[count]=i;
			comb(i, count+1);
		}
	}

}
