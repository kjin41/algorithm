import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ4577 {
// Baekjoon 4577. 소코반
	static char[][] arr;
	static char[] order;
	static int R, C, wr, wc;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input4577.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=1;
		while (true) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			R=Integer.parseInt(st.nextToken());
			C=Integer.parseInt(st.nextToken());
			if (R==0)	break;
			arr=new char[R][C];
			for (int i=0; i<R; i++) {
				arr[i]=br.readLine().toCharArray();
				for (int j=0; j<C; j++) {
					if (arr[i][j]=='w' || arr[i][j]=='W') {
						wr=i;
						wc=j;
						if (arr[i][j]=='w')	arr[i][j]='.';
						else arr[i][j]='+';
					}
				}
			}
			order=br.readLine().toCharArray();
			HashMap<Character, Integer> map=new HashMap<>();	// 상하좌우
			map.put('U', 0);
			map.put('D', 1);
			map.put('L', 2);
			map.put('R', 3);
			for (int i=0; i<order.length; i++) {
				move(map.get(order[i]));
				boolean finish=true;
				for (int r=0; r<R; r++) {
					for (int c=0; c<C; c++) {
						if (arr[r][c]=='b')	finish=false;
					}
				}
				if (finish) break;
			}
			
			if (arr[wr][wc]=='.')	arr[wr][wc]='w';
			else arr[wr][wc]='W';
			
			StringBuilder sb=new StringBuilder();
			boolean flag=true;
			for (int i=0; i<R; i++) {
				for (int j=0; j<C; j++) {
					sb.append(arr[i][j]);
					if (arr[i][j]=='b')	flag=false;
				}
				sb.append("\n");
			}
			if (flag)	System.out.println("Game "+n+": complete");
			else 	System.out.println("Game "+n+": incomplete");
			System.out.print(sb);
			n++;
			
		}
		
		
		br.close();
		
		
	}
	
//	private static void printArr(char o) {
//		System.out.println(o+" "+wr+" "+wc);
//		for (int i=0; i<R; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
//		System.out.println();
//	}

	private static void move(int d) {
		int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};	// 상하좌우
		int nr=wr+dir[d][0];
		int nc=wc+dir[d][1];
		if (isWall(nr,nc))	return;		// 못 움직임
		if (nothing(nr,nc) || destination(nr,nc)) {
			wr=nr;	wc=nc;
			return;
		}
		// 박스가 있음
		int tr=nr+dir[d][0];
		int tc=nc+dir[d][1];
		if (isWall(tr,tc) || isBox(tr,tc))	return;		// 못 움직임
		
		if (nothing(tr,tc)) 	arr[tr][tc]='b';	// 박스 이동
		else	arr[tr][tc]='B';
		
		if (arr[nr][nc]=='b')	arr[nr][nc]='.';	// 박스 이동된 자리 복구
		else 	arr[nr][nc]='+';
		
		wr=nr;	wc=nc;	// 사람 이동
	}


	private static boolean destination(int r, int c) {
		if (arr[r][c]=='+')	return true;
		return false;
	}

	private static boolean isBox(int r, int c) {
		if (arr[r][c]=='b' || arr[r][c]=='B')	return true;
		return false;
	}

	private static boolean nothing(int r, int c) {
		if (arr[r][c]=='.')	return true;
		return false;
	}

	private static boolean isWall(int r, int c) {
		if (arr[r][c]=='#')	return true;
		return false;
	}

}
