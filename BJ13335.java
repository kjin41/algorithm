import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ13335 {
// Baekjoon 13335. 트럭
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input13335.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int W=Integer.parseInt(st.nextToken());
		int L=Integer.parseInt(st.nextToken());
		int[] truck=new int[N+1];
		int[] bridge=new int[W];
		int count=0;
		
		st=new StringTokenizer(br.readLine());
		for (int i=1; i<=N; i++) {
			truck[i]=Integer.parseInt(st.nextToken());
		}
		
		int weight=0;
		int index=1;
		while(index<=N) {
			weight-=truck[bridge[W-1]];
			for (int i=W-2; i>=0; i--) {
				bridge[i+1]=bridge[i];
			}
			
			if (weight+truck[index]<=L) {
				bridge[0]=index;
				weight+=truck[index++];
			} else {
				bridge[0]=0;
			}
			count++;
		}
		count+=W;
		
		System.out.println(count);
		
		br.close();
	}

}
