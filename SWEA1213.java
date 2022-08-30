import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1213 {
// SW Expert Academy 1213. String
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1213.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		for (int t=1; t<11; t++) {
			br.readLine();
			char[] str=br.readLine().toCharArray();
			char[] sentence=br.readLine().toCharArray();
			int len1=str.length;
			int len2=sentence.length;
			
			int count=0;
			loop:
			for (int i=0; i<len2-len1+1; i++) {
				for (int j=0; j<len1; j++) {
					if (str[j]!=sentence[i+j])	continue loop;
				}
				count++;
			}
			System.out.println("#"+t+" "+count);
		}
		
		br.close();
	}

}
