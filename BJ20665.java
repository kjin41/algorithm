import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ20665 {
// Baekjoon 20665. 독서실 거리두기 
	static class Person implements Comparable<Person>{
		int start, end;

		public Person(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Person o) {
			if (this.start==o.start) {
				return this.end-o.end;
			}
			return this.start-o.start;
		}
		
		
		
	}
	static Person[] people;
	static int[][] table;
	static int N, T, P;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input20665.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		T=Integer.parseInt(st.nextToken());
		P=Integer.parseInt(st.nextToken());
		table=new int[N+1][2];
		people=new Person[T];
		for (int i=0; i<T; i++) {
			char[] time=br.readLine().toCharArray();
			int start=timeToInt(time, 0);	// 0~720 사이 수로
			int end=timeToInt(time, 5);
			people[i]=new Person(start, end);
		}
		
		Arrays.sort(people);
		int total=0;
		int temp=0;
		for (int i=0; i<T; i++) {
			int s=people[i].start;
			int e=people[i].end;
			int seat=findSeat(s, e);
//			System.out.println(seat);
			table[seat][0]=s;
			table[seat][1]=e;
			if (seat==P) {		// P 자리이면
				total+=s-temp;	// 시작 시간 전까지 누적
				temp=e;			// 시작 시간을 끝시간으로 옮김
			} 
		}
		
		total+=720-temp;
		System.out.println(total);
		br.close();
		
	}
	
	private static int findSeat(int s, int e) {
//		if (table[1][1]<=s) {	// 1번 자리 없을 때
//			return 1;
//		} 
		
		int[][] distance=new int[N+1][2];
		
		int left=-10000, right=10000;
		for (int i=1; i<=N; i++) {
			if (table[i][1]>s) {	// 차 있음
				distance[i][0]=0;
				left=i;
			} else {
				distance[i][0]=i-left;
			}
		}
		for (int i=N; i>0; i--) {
			if (table[i][1]>s) {
				distance[i][1]=0;
				right=i;
			} else {
				distance[i][1]=right-i;
			}
		}
		
		int index=0;
		int max=0;
		for (int i=1; i<=N; i++) {
			int temp=Math.min(distance[i][0], distance[i][1]);
			if (max<temp) {
				max=temp;
				index=i;
			}
		}
		
		return index;
	}

	private static int timeToInt(char[] time, int i) {
		return (time[i]-'0')*600+(time[i+1]-'9')*60+(time[i+2]-'0')*10+(time[i+3]-'0');
		
	}


}
