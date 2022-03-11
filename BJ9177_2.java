import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ9177_2 {
// Baekjoon 9177. 단어 섞기
// bfs
	static String word1, word2, word3;
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input9177.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for (int n=1; n<=N; n++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			word1=st.nextToken();
			word2=st.nextToken();
			word3=st.nextToken();
			flag=false;
			bfs();

			if (flag) {
				sb.append("Data set ").append(n).append(": yes").append("\n");
			} else {
				sb.append("Data set ").append(n).append(": no").append("\n");
			}
			
		}
		
		System.out.println(sb);
		br.close();
	}

	private static void bfs() {
		boolean[][] visited=new boolean[word1.length()+1][word2.length()+1];
		Queue<int[]> queue=new LinkedList<int[]>();
		queue.add(new int[] {0, 0});
		visited[0][0]=true;
		while(!queue.isEmpty()){
			int[] cur=queue.poll();
			int len1=cur[0]; 
			int len2=cur[1];
			if (len1+len2==word3.length()) {
				flag=true;
				break;
			}
			if (len1<word1.length() && word1.charAt(len1)==word3.charAt(len1+len2) && !visited[len1+1][len2]) {
				visited[len1+1][len2]=true;
				queue.add(new int[] {len1+1, len2});
			}
			if (len2<word2.length() && word2.charAt(len2)==word3.charAt(len1+len2) && !visited[len1][len2+1]) {
				visited[len1][len2+1]=true;
				queue.add(new int[] {len1, len2+1});
			}
		}
		
	}

}
