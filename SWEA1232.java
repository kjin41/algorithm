import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA1232 {
// SW Expert Academy 1232. 사칙연산
	static double[][] arr;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1232.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		for (int t=1; t<11; t++) {
			sb.append("#").append(t).append(" ");
			int N=Integer.parseInt(br.readLine());
			arr=new double[N+1][3];
			for (int i=0; i<N; i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				int num=Integer.parseInt(st.nextToken());
				String str=st.nextToken();
				if (str.charAt(0)=='+')	arr[num][0]=-1;
				else if (str.charAt(0)=='-')	arr[num][0]=-2;
				else if (str.charAt(0)=='*')	arr[num][0]=-3;
				else if (str.charAt(0)=='/')	arr[num][0]=-4;
				else {
					arr[num][0]=Double.parseDouble(str);
					continue;
				}
				arr[num][1]=Integer.parseInt(st.nextToken());
				arr[num][2]=Integer.parseInt(st.nextToken());
				
			}
			sb.append((long)calculate(1));
			sb.append("\n");		
		}
		System.out.println(sb);
		
		
		br.close();
	}

	private static double calculate(int i) {
		if (arr[i][0]==-1)	return calculate((int)arr[i][1])+calculate((int)arr[i][2]);
		else if (arr[i][0]==-2)	return calculate((int)arr[i][1])-calculate((int)arr[i][2]);
		else if (arr[i][0]==-3)	return calculate((int)arr[i][1])*calculate((int)arr[i][2]);
		else if (arr[i][0]==-4)	return calculate((int)arr[i][1])/calculate((int)arr[i][2]);
		return arr[i][0];
	}

}
