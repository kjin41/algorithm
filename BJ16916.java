import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ16916 {
// Baekjoon 16916. 부분 문자열
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input16916.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		char[] S=br.readLine().toCharArray();
		char[] P=br.readLine().toCharArray();
		int pLen=P.length;
		int[] pi=new int[pLen];
		// i: 접미사 포인터(i=1부터 시작: 부분일치데이블을 만드는게 목적이므로 첫글자 틀리면 0위치로) 
		// j: 접두사 포인터
		for (int i=1, j=0; i<pLen; i++) {
			while (j>0&&P[i]!=P[j])	j=pi[j-1];
	
			// j==0 or P[i]==P[j]
			if (P[i]==P[j])	pi[i]=++j;
		}

		// i: S 포인터
		// j: P 포인터
		for (int i=0, j=0; i<S.length; i++) {
			while (j>0&&S[i]!=P[j])	j=pi[j-1];
			
			if (S[i]==P[j])	{
				if (j==pLen-1) {	// 패턴 모두 일치
					System.out.println(1);
					System.exit(0);
				} else 	j++;	// 패턴 중간 일치
			}
		}
		
		System.out.println(0);
		br.close();
	}

}
