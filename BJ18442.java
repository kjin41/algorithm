import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ18442 {
// Baekjoon 18442. 우체국 1
	static int V, P;
	static long L, min=Long.MAX_VALUE;
	static long[] arr, temp;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input18442.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		V=Integer.parseInt(st.nextToken());
		P=Integer.parseInt(st.nextToken());
		L=Long.parseLong(st.nextToken());
		arr=new long[V];
		st=new StringTokenizer(br.readLine());
		for (int i=0; i<V; i++) {
			arr[i]=Long.parseLong(st.nextToken());
		}
		temp=new long[P];
		comb(0, 0);
		System.out.println(min);
		System.out.println(sb);
		br.close();
	}
	
	private static void comb(int start, int count) {
		if (count==P) {
			long dist=distance();
			if (min>dist) {
				min=dist;
				sb=new StringBuilder();
				for (int i=0; i<P; i++) {
					sb.append(temp[i]).append(" ");
				}
			}
			return;
		}
		
		for (int i=start; i<V; i++) {
			temp[count]=arr[i];
			comb(i+1, count+1);
		}
	}

	private static long distance() {
		long total=0l;
		for (int i=0; i<V; i++) {
			long dist=Long.MAX_VALUE;
			for (int j=0; j<P; j++) {
				long d=Math.abs(arr[i]-temp[j]);
				dist=Math.min(dist, Math.min(d, L-d));
			}
			total+=dist;
		}
		
		return total;
	}

}
