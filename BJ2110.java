import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2110 {
// Baekjoon 2110. 공유기 설치
// 이분 탐색
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input2110.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int C=Integer.parseInt(st.nextToken());
		int[] house=new int[N];
		for (int i=0; i<N; i++) {
			house[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(house);		
		int start=0;
		int end=house[N-1]-house[0];	// 최대 거리
		int result=0;
		
		while(start<=end) {
			int mid=(start+end)/2;
			int count=1;
			int before=house[0];
			for (int i=1; i<N; i++) {
				if (house[i]-before>=mid) {
					count++;
					before=house[i];
				}
			}
			
			if (count>=C) {
				result=mid;
				start=mid+1;
			} else {
				end=mid-1;
			}
		}
		
		System.out.println(result);
		br.close();
	}

}
