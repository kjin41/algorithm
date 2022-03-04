import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ14267 {
// Baekjoon 14267. 회사 문화 1

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input14267.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] boss=new ArrayList[N+1];
		st=new StringTokenizer(br.readLine());
		for (int i=1; i<=N; i++) {
			boss[i]=new ArrayList<>();
			int b=Integer.parseInt(st.nextToken());
			if (b!=-1) {
				boss[b].add(i);
			}
		}
		
		long[] praise=new long[N+1];
		long[] total=new long[N+1];
		
		for (int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int index=Integer.parseInt(st.nextToken());
			long w=Long.parseLong(st.nextToken());
			praise[index]+=w;	// 한 사람이 여러번 칭찬 받을 수도 있다!!!!!!!!!!!
		}
		
		for (int i=2; i<=N; i++) {
			total[i]+=praise[i];
			int size=boss[i].size();
			for (int j=0; j<size; j++) {
				total[boss[i].get(j)]+=total[i];
			}
		}
		
		StringBuilder sb=new StringBuilder();
		for (int i=1; i<=N; i++) {
			sb.append(total[i]).append(" ");
		}
		
		System.out.println(sb);
		br.close();
	}

}
