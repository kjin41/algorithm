import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ6588 {
// Baekjoon 6588. 골드바흐의 추측
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input6588.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int num=0;
		int N=1000001;
		int k=0;
		StringBuilder sb=new StringBuilder();
		boolean[] com=new boolean[N];
		for (int i=2; i<=Math.sqrt(N); i++) {	// sqrt(n) 까지만 하면 소수 판별 가능, 그 뒤로 false인 애들은 다 소수
			if (!com[i]) {
				for (int j=i*2; j<N; j+=i) {
					com[j]=true;
				}
			} 
		}

		while((num=Integer.parseInt(br.readLine()))!=0) {
			int left=2;	
			int right=num;
			boolean flag=false;
			while(left<=right) {
				if (com[left])	{	// 소수 아니면 패스
					left++;
					continue;
				}
				right=num-left;		// 다른 소수는 무조건 num-left -> O(n)=N
				if (!com[right]) {	// 소수면
					flag=true;
					sb.append(num).append(" = ").append(left).append(" + ").append(right).append("\n");
					break;
				}
				left++;
			}
			if (!flag)
				sb.append("Goldbach's conjecture is wrong.").append("\n");
			
		}
		System.out.println(sb);
		
		br.close();
	}

}
