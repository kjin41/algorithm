package day220119;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ1935 {
// Baekjoon 1935. 후위 표기식2
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1935.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		char[] arr=br.readLine().toCharArray();
		double[] num=new double[N];
		for (int i=0; i<N; i++) {
			num[i]=Double.parseDouble(br.readLine());
		}
		
		Stack<Double> stack=new Stack<>();
		for (int i=0; i<arr.length; i++) {
			char c=arr[i];
			if (c>='A'&&c<='Z') {
				stack.push(num[c-'A']);
			} else {
				double y=stack.pop();
				double x=stack.pop();
				double cal=0.0;
				if (c=='+') {
					cal=x+y;
				} else if (c=='-') {
					cal=x-y;
				} else if (c=='*') {
					cal=x*y;
				} else {
					cal=x/y;
				} 
				stack.push(cal);
			}
		}
		
		double result=stack.pop();
		String str=(long)(result*100)+"";
		
		System.out.println((long)result+"."+str.charAt(str.length()-2)+str.charAt(str.length()-1));
		
		br.close();
	}

}
