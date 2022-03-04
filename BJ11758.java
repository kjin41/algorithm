import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BJ11758 {
// Baekjoon 11758. CCW
	static double x1, y1, x2, y2, x3, y3;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input11758.txt"));
		Scanner sc=new Scanner(new InputStreamReader(System.in));
		x1=sc.nextDouble();
		y1=sc.nextDouble();
		x2=sc.nextDouble();
		y2=sc.nextDouble();
		x3=sc.nextDouble();
		y3=sc.nextDouble();
		
		System.out.println(calculate());
	}
	
	private static int calculate() {
		double x12=x2-x1;
		double y12=y2-y1;
		double x13=x3-x1;
		double y13=y3-y1;
		
		if (x12==0 && x13==0) {		// 수직
			return 0;
		}
		
		if (y12/x12 == y13/x13) {	// 일직선상 위
			return 0;
		}
		
		double cos=(x12*x13+y12*y13) / ( Math.sqrt(y12*y12+x12*x12) * Math.sqrt(y13*y13+x13*x13) );	// 내적 / 두변의 길이의 곱
		double sin=Math.sqrt(1-cos*cos);
		
		double[] ccw=rotate(x12, y12, cos, sin, 1);		// 12번 기준 반시계 방향으로 회전
		double[] cw=rotate(x12, y12, cos, sin, -1);		// 12번 기준 시계 방향으로 회전
		
		if ((ccw[0]-x13)*(ccw[0]-x13) + (ccw[1]-y13)*(ccw[1]-y13) < (cw[0]-x13)*(cw[0]-x13) + (cw[1]-y13)*(cw[1]-y13)) {	// 13과 오차가 적은거 기준
			return 1;
		}
		return -1;
	}

	private static double[] rotate(double x, double y, double cos, double sin, int flag) {	// 회전행렬
		double[] result=new double[2];
		result[0]=cos*x-sin*flag*y;
		result[1]=sin*flag*x+cos*y;
		
		return result;
	}

}
