import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ1034_2 {
// Baekjoon 1034. 램프
// 1. 한 행에 꺼져있는 불의 개수 <= k
// 2. 한 행에 꺼져있는 불의 개수 %2 == k%2 중
// 3. 일치하는 행의 최대값

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1034.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		char[][] arr=new char[N][M];
		int[] count=new int[N];		// 행별 1 개수 카운트
		for (int i=0; i<N; i++) {
			arr[i]=br.readLine().toCharArray();
			for (int j=0; j<M; j++) {
				count[i]+=arr[i][j]-'0';
			}
		}
		int K=Integer.parseInt(br.readLine());
		HashMap<String, Integer> map=new HashMap<>();
		
		for (int i=0; i<N; i++) {
			if (M-count[i]>K || (M-count[i])%2!=K%2) {
				continue;
			}
			
			StringBuilder sb=new StringBuilder();
			for (int j=0; j<M; j++) {
				sb.append(arr[i][j]);
			}
			
			String key=sb.toString();
			if (map.containsKey(key)) {
				int value=map.get(sb.toString());
				map.put(key, value+1);
			} else {
				map.put(key, 1);
			}	
		}
		
		int result=0;
		for (String key: map.keySet()) {
			System.out.println(key+" "+map.get(key));
			result=Math.max(result, map.get(key));
		}
		
		System.out.println(result);
		
		br.close();
	}

}
