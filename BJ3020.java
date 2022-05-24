import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ3020 {
// Baekjoon 3020. 개똥벌레
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input3020.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int H=Integer.parseInt(st.nextToken());
		int[] arr1=new int[H+1];	// 종유석		해당 높이에 걸쳐진 장애물 개수
		int[] arr2=new int[H+1];	// 석순
		for (int i=0; i<N/2; i++) {
			arr1[Integer.parseInt(br.readLine())]++;
			arr2[Integer.parseInt(br.readLine())]++;
		}

		for (int i=H; i>1; i--) {
			arr1[i-1]+=arr1[i];		// 높은 높이 개수만큼 낮은 높이에도 더하기
			arr2[i-1]+=arr2[i];
		}

		for (int i=1; i<=H; i++) {
			arr1[i]+=arr2[H-i+1];	// 석순 뒤집어서 종유석에 합치기
		}

		int min=N;
		ArrayList<Integer> list=new ArrayList<>();
		for (int i=1; i<=H; i++) {
			if (min>arr1[i]) {
				list=new ArrayList<>();
				list.add(i);
				min=arr1[i];
			} else if (min==arr1[i]) {
				list.add(i);
			}
		}
		
		System.out.println(min+" "+list.size());
		
		
		br.close();
	}

}
