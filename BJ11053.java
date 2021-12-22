import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11053 {
// Baekjoon 11053. 가장 긴 증가하는 부분 수열
// Baekjoon 12015. 가장 긴 증가하는 부분 수열2
// Baekjoon 12738. 가장 긴 증가하는 부분 수열3
// lis
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input11053.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		int[] arr=new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int[] lis=new int[N];
		int size=0;
		for (int i=0; i<N; i++) {
			lis[i]=-1000000001;
			int index=Arrays.binarySearch(lis, 0, size, arr[i]);
			if (index<0) { // 해당 원소가 없음
				index=-index-1;
				lis[index]=arr[i];
				
				if (index==size) {
					size++;
				}
			}
		}
		System.out.println(size);
		br.close();
		
	}

}
