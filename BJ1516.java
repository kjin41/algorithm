import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1516 {
// Baekjoon 1516. 게임 개발
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1516.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		ArrayList<Integer>[] list=new ArrayList[N+1];	// 나 다음 짓는 건물들
		for (int i=1; i<=N; i++) {
			list[i]=new ArrayList<>();
		}
		int[] time=new int[N+1];		// 건축 시간
		int[] precount=new int[N+1];	// 내 앞에 남아있는 건물 수
		int[] result=new int[N+1];
		for (int i=1; i<=N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			time[i]=Integer.parseInt(st.nextToken());
			result[i]=time[i];
			int pre=0;
			int count=0;
			while((pre=Integer.parseInt(st.nextToken()))!=-1) {
				count++;
				list[pre].add(i);
			}
			precount[i]=count;
		}
		
		Queue<Integer>queue=new LinkedList<>();
		for (int i=1; i<=N; i++) {
			if (precount[i]==0) {
				queue.add(i);
			}
		}
		while(!queue.isEmpty()) {
			int cur=queue.poll();
			for (int index: list[cur]) {
				if (--precount[index]==0) {
					queue.add(index);
				}
				result[index]=Math.max(time[index]+result[cur], result[index]);		// 앞에 지어진 건물 + 현재 시간과 결과중 최대값
			}
		}
		
		for (int i=1; i<=N; i++) {
			System.out.println(result[i]);
		}
		
		br.close();
		
	}

}
