import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1541 {
// Baekjoon 1541. 잃어버린 괄호
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1541.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		char[] arr=br.readLine().toCharArray();
		int count=0;
		int temp=0;
		int flag=1;
		for (int i=0; i<arr.length; i++) {
			if (arr[i]=='-') {
				flag=-1;
				count+=temp;
				temp=0;
			} else if(arr[i]=='+') {
				count+=temp;
				temp=0;
			} else {
				temp=temp*10+(arr[i]-'0')*flag;
			}
			
		}
		count+=temp;
		System.out.println(count);
		br.close();
	}

}
