import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ4949 {
// Baekjoon 4949. 균형잡힌 세상
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input4949.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			boolean flag=false;
			char[] str=br.readLine().toCharArray();
			int len=str.length;
			if (len==1&&str[0]=='.') {
				break;
			}
			Stack<Character> stack=new Stack<>();
			for (int i=0; i<len; i++) {
				char c=str[i];
				if (c=='(' || c=='[') {
					stack.add(c);
				} else if (c==')' && (stack.isEmpty()||stack.pop()!='(')) {
					flag=true;
					break;
				} else if (c==']' && (stack.isEmpty()||stack.pop()!='[')) {
					flag=true;
					break;
				}
			}
			if (!stack.isEmpty()) {
				flag=true;
			}
			if (!flag) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
		
		
		br.close();
	}

}
