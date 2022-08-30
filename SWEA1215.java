import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA1215 {
// SW Expert Academy 1215. 회문1
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1215.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=10;
		StringBuilder sb=new StringBuilder();
		for (int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			int N=Integer.parseInt(br.readLine());
			char[][] arr1=new char[8][8];
			char[][] arr2=new char[8][8];
			for (int i=0; i<8; i++) {
				arr1[i]=br.readLine().toCharArray();
				for (int j=0; j<8; j++) {
					arr2[j][i]=arr1[i][j];
				}
			}
			int count=repeat(arr1, N);
			count+=repeat(arr2, N);
			
			sb.append(count).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	private static int repeat(char[][] arr, int N) {
		int count=0;
		for (int i=0; i<8; i++) {
			loop:
			for (int j=0; j<9-N; j++) {
				for (int k=0; k<N/2; k++) {
					if (arr[i][j+k]!=arr[i][j+N-1-k]) continue loop; 
				}
				count++;
			}
		}
		return count;
	}

}
