import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ10972 {
// Baekjoon 10972. 다음 순열
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input10972.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int[] arr=new int[N];
		for (int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		boolean flag=false;
		loop:
		for (int i=N-1; i>0; i--) {
			if (arr[i]>arr[i-1]) {	// 뒤에서부터 peek 포인트 찾기
				for (int j=N-1; j>=i; j--) {
					if (arr[i-1]<arr[j]) {	// peek 포인트 하나 앞에 수보다 큰 수중 가장 작은 수 찾기
						int tmp=arr[i-1];	// swap	// ex) 2 6 5 4 3 1 인 경우 2와 3 swap 
						arr[i-1]=arr[j];
						arr[j]=tmp;
						Arrays.sort(arr, i, N);		// 내림차순으로 돼있어서 sort함수 안쓰고 정렬 가능함
						flag=true;
						break loop;
					}
					
				}
			}
		}
		
		StringBuilder sb=new StringBuilder();
		if (!flag) {
			sb.append(-1);
		} else {
			for (int i: arr) {
				sb.append(i).append(" ");
			}	
		}
		
		System.out.println(sb);
		br.close();
	}

}
