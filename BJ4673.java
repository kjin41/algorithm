import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ4673 {
// Baekjoon 4673. 셀프 넘버
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input4673.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		boolean[] arr=new boolean[10001];
		
		for (int i=1; i<=10000; i++) {
			int num=i;
			int temp=i;
			int len=(num+"").length();
			for (int j=0; j<len; j++) {
				num+=temp%10;
				temp/=10;
			}
			if (num<=10000) {
				arr[num]=true;
			}
		}
		
		for(int i=1; i<=10000; i++) {
			if (!arr[i]) {
				sb.append(i).append("\n");
			}
		}

		System.out.println(sb);
		br.close();
	}

}
