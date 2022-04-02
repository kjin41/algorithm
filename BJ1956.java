import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1956 {
// Baekjoon 1956. 운동
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1956.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int V=Integer.parseInt(st.nextToken());
		int E=Integer.parseInt(st.nextToken());
		int[][] arr=new int[V+1][V+1];
		for (int i=1; i<=V; i++) {
			for (int j=1; j<=V; j++) {
				arr[i][j]=100000000;
			}
		}
		
		for (int i=0; i<E; i++) {
			st=new StringTokenizer(br.readLine());
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			int dist=Integer.parseInt(st.nextToken());
			arr[from][to]=dist;
		}
		
		for (int k=1; k<=V; k++) {
			for (int i=1; i<=V; i++) {
				for (int j=1; j<=V; j++) {
					arr[i][j]=Math.min(arr[i][j], arr[i][k]+arr[k][j]);
				}
			}
		}
		
		int min=100000000;
		for (int i=1; i<V; i++) {
			for (int j=i+1; j<=V; j++) {
				min=Math.min(min, arr[i][j]+arr[j][i]);
			}
		}
		if (min==100000000) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
		
		br.close();
	}

}
