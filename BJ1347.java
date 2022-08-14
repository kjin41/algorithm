import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1347 {
// Baekjoon 1347. 미로 만들기
	static boolean[][] miro=new boolean[100][100];
	static int r=50, c=50, d=0;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1347.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int L=Integer.parseInt(br.readLine());
		char[] order=br.readLine().toCharArray();
		miro[r][c]=true;
		for (int i=0; i<L; i++) {
			move(order[i]);
		}
		
		int sr=100, sc=100, er=0, ec=0;
		for (int i=0; i<100; i++) {
			for (int j=0; j<100; j++) {
				if (miro[i][j]) {
					sr=Math.min(sr, i);
					sc=Math.min(sc, j);
					er=Math.max(er, i);
					ec=Math.max(ec, j);
				}
			}
		}
		StringBuilder sb=new StringBuilder();
		for (int i=sr; i<=er; i++) {
			for (int j=sc; j<=ec; j++) {
				if (miro[i][j])	sb.append(".");
				else 	sb.append("#");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	private static void move(char o) {
		int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};	// 남쪽부터 반시계
		if (o=='F') {
			r+=dir[d][0];
			c+=dir[d][1];
			miro[r][c]=true;
		} else if (o=='R') {
			d=(d+3)%4;
		} else if (o=='L') {
			d=(d+1)%4;
		}
	}

}
