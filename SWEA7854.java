import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA7854 {
// SW Expert Academy 7854. 최약수
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input7854.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		// 1, 2, 5
		// 10, 20, 25, 50
		// 100, 125, 200, 250, 500
		// 1000, 1250, 2000, 2500, 5000
		// 10000, 12500, 20000, 25000, 50000 
		// ...
		
		int[] num1={1,2,5,10,20,25,50};
		int[] num2={100,125,200,250,500};
		ArrayList<Integer> numList=new ArrayList<>();
		for (int i=0; i<7; i++) {
			numList.add(num1[i]);
		}
		for (int i=0; i<8; i++) {
			for (int j=0; j<5; j++) {
				numList.add(num2[j]*(int)Math.pow(10, i));
			}
		}
		
		int size=numList.size();
		for (int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			int N=Integer.parseInt(br.readLine());
			int ans=0;
			for (int i=0; i<size; i++) {
				if (N>=numList.get(i))	ans++;
				else break;
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

}
