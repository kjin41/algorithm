import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1240 {
// SW Expert Academy 1240. 단순 2진 암호코드
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1240.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for (int t=1; t<=T; t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			char[][] arr=new char[N][M];
			for (int i=0; i<N; i++) {
				arr[i]=br.readLine().toCharArray();
			}
			int ans=0;
			loop:
			for (int i=0; i<N; i++) {
				for (int j=0; j<M-56; j++) {
					ans=isCode(arr[i], j);
					if (ans!=0) {
						break loop;
					}
				}
			}
			System.out.println("#"+t+" "+ans);
		}
		
		br.close();
		
	}

	private static int isCode(char[] arr, int index) {
		String[] code={"0001101", "0011001", "0010011", "0111101", "0100011", 
				"0110001", "0101111", "0111011", "0110111", "0001011"};
		int[] answer=new int[8];
		int k=0;
		while (k<8) {
			boolean flag=false;
			for (int i=0; i<10; i++) {
				int count=0;
				for (int j=0; j<7; j++) {
					if (code[i].charAt(j)==arr[index+j]) {
						count++;
					} 
				}
				if (count==7) {
					answer[k++]=i;
					index+=7;
					flag=true;
					break;
				}
			}
			if (!flag)	return 0;
		}
		
		int total=0;
		int ans=0;
		for (int i=0; i<8; i+=2) {
			total+=answer[i]*3;
			total+=answer[i+1];
			ans+=answer[i]+answer[i+1];
		}
		if (total%10==0)	return ans; 
		else 	return 0;
	}

}
