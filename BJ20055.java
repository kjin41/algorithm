import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ20055 {
// Baekjoon 20055. 컨베이어 벨트 위의 로봇
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input20055.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] belt=new int[N*2];
		boolean[] robot=new boolean[N];
		for (int i=0; i<2*N; i++) {
			belt[i]=Integer.parseInt(st.nextToken());
		}
		
		int result=0;
		while(true) {
			result++;
//			1. 벨트 회전, 로봇도 같이
			int temp=belt[2*N-1];
			for (int i=2*N-1; i>0; i--) {
				belt[i]=belt[i-1];
			}
			belt[0]=temp;
			
			for (int i=N-1; i>0; i--) {
				robot[i]=robot[i-1];
			}
			robot[0]=false;
			robot[N-1]=false;

//			2. 로봇만 이동
			for (int i=N-1; i>0; i--) {
				if (belt[i]!=0&&!robot[i]&&robot[i-1]) {
					robot[i]=true;
					robot[i-1]=false;
					belt[i]--;
				}
			}
			robot[N-1]=false;
			
//			3. 올리는 위치에 로봇 올리기
			if (belt[0]!=0) {
				robot[0]=true;
				belt[0]--;
			}
			
//			4. 내구도 0인 칸 세기
			int cnt=0;
			for (int i=0; i<2*N; i++) {
				if (belt[i]==0) {
					cnt++;
				}
			}

			if (cnt>=K)	break;
			
		}
		
		System.out.println(result);
		
		
		br.close();
	}

}
