package day211204;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA2383 {
// SW Expert Academy 2383. 점심 식사시간
//	사람을 2그룹으로 나누는 조함
	
	static int N, P, result;
	static int[][] people=new int[10][2];
	static int[][] stairs=new int[2][3];
	static int[] temp;
	static boolean[] flag;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input2383.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for (int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			int N=Integer.parseInt(br.readLine());
			P=0;
			int S=0;
			result=1000000;
			for (int i=0; i<N; i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				for (int j=0; j<N; j++) {
					int num=Integer.parseInt(st.nextToken());
					if (num==1) {
						people[P][0]=i;
						people[P++][1]=j;
					} else if(num>1) {
						stairs[S][0]=i;
						stairs[S][1]=j;
						stairs[S++][2]=num;
					}
				}
			}
			
			for (int r=0; r<=P/2; r++) {
				temp=new int[r];
				comb(0, 0, r);
			}
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);
		
		
		br.close();
	}
	
	private static void comb(int cnt, int start, int r) {
		if (cnt==r) {
			flag=new boolean[P];
			for (int i=0; i<r; i++) {
				flag[temp[i]]=true;
			}
			int dis1=Math.max(distance(0, true, r), distance(1, false, P-r));
			int dis2=Math.max(distance(1, true, r), distance(0, false, P-r));
			if (result>dis1)	result=dis1;
			if (result>dis2)	result=dis2;
			return;
		}
		
		for (int i=start; i<P; i++) {
			temp[cnt]=i;
			comb(cnt+1, i+1, r);
		}
	}

	static class Info{
		int d, s, w;

		public Info(int d, int s, int w) {
			super();
			this.d = d;
			this.s = s;
			this.w = w;
		}
		
	}
	private static int distance(int s, boolean f, int r) {
		Info[] infos=new Info[P];
		for (int i=0; i<P; i++) {
			if (flag[i]==f) {
				infos[i]=new Info(Math.abs(people[i][0]-stairs[s][0])+Math.abs(people[i][1]-stairs[s][1]), stairs[s][2], 1);
			}
		}
		int t=0;
		int p=0;
		ArrayList<Integer> list=new ArrayList<>();
		boolean[] used=new boolean[P];
		while(p<r) {
			for (int i=0; i<P; i++) {
				if (flag[i]==f && !used[i]) {
					if (infos[i].d>0) {
						infos[i].d--;
					} else if (infos[i].w==1) {
						infos[i].w--;
					} else {
						list.add(i);
						used[i]=true;
					}
				}
			}
			for (int i=0; i<list.size(); i++) {
				if (i==3)	break;
				infos[list.get(i)].s--;
			}
			
			for (int i=list.size()-1; i>=0; i--) {
				if (infos[list.get(i)].s==0) {
					list.remove(i);
					p++;
				}
			}
			
			t++;
			if (t>result) break;
		}
		return t;
	}

}
