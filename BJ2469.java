import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2469 {
// Baekjoon 2469. 사다리 타기
	static int N, K, index;
	static char[][] ladder;
	static char[] answer;
	static int[] end;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input2469.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		K=Integer.parseInt(br.readLine());
		N=Integer.parseInt(br.readLine());
		char[] temp=br.readLine().toCharArray();
		end=new int[K];		// A부터 도착 위치
		for (int i=0; i<K; i++) {
			end[temp[i]-'A']=i;
		}
		answer=new char[K];
		ladder=new char[N][];
		boolean flag=true;
		for (int i=0; i<N; i++) {
			ladder[i]=br.readLine().toCharArray();
			if (ladder[i][0]=='?')	index=i;
		}
		
		
		for (int j=0; j<K; j++) {	// 한 사람에 대해, 열
			int before=j;
			for (int i=0; i<index; i++) {	// 위~물음표
				before=cross(i, before);				
			}
			int after=end[j];
			for (int i=N-1; i>index; i--) {	// 아래~물음표
				after=cross(i, after);			
			}
			
			flag=addLadder(before, after);
			if (!flag) break;
			
		}
		
		if (!flag) {
			for (int i=0; i<K-1; i++) {
				answer[i]='x';
			}
		}
		
		for (int i=0; i<K-1; i++) {
			System.out.print(answer[i]);
		}
		
		br.close();
	}

	private static boolean addLadder(int before, int after) {
		int diff=after-before;	// 0, 1, -1만 가능
		
		if (diff==0) {	// 그대로 내려가야 함
			if ((before<K-1&&answer[before]=='-') || (before>0&&answer[before-1]=='-'))	return false;	// 옆으로 빠지면 안 됨
			answer[before]='*';
			if (before>0)	answer[before-1]='*';
			return true;
		}
		
		if (diff==1) {	// 오른쪽으로
			if ((before<K-1&&answer[before]=='*') || (before>0&&answer[before-1]=='-'))	return false;
			answer[before]='-';
			if (before>0)	answer[before-1]='*';
			return true;
		}
		
		if (diff==-1) {	// 왼쪽으로
			if ((before<K-1&&answer[before]=='-') || (before>0&&answer[before-1]=='*'))	return false;
			answer[before]='*';
			if (before>0)	answer[before-1]='-';
			return true;
		}
		
		return false;
	}

	private static int cross(int i, int j) {
		if (j>0&&ladder[i][j-1]=='-')	return j-1;
		if (j<K-1&&ladder[i][j]=='-')	return j+1;
		
		return j;
	}

}
