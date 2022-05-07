import java.util.Arrays;
import java.util.HashMap;

public class test1 {

	public static void main(String[] args) {
//		["TR", "RT", "TR"]	[7, 1, 3]
		String[] survey= {"TR", "RT", "TR"};
		int[] choices= {7, 1, 3};
		int[] scores= {0,3,2,1,0,1,2,3};
		HashMap<Character, Integer>map=new HashMap<>();
		map.put('A', 6);
		map.put('N', 7);
		map.put('C', 2);
		map.put('F', 3);
		map.put('M', 5);
		map.put('J', 4);
		map.put('R', 0);
		map.put('T', 1);
		
		int[] total=new int[8];
		for (int i=0; i<survey.length; i++) {
			char[] letter=survey[i].toCharArray();
			if (choices[i]>4) {
				total[map.get(letter[1])]+=choices[i]-4;
			} else {
				total[map.get(letter[0])]+=4-choices[i];
			}
		}
		StringBuilder sb=new StringBuilder();
		if (total[0]>=total[1]) {
			sb.append('R');
		} else {
			sb.append('T');
		}
		if (total[2]>=total[3]) {
			sb.append('C');
		} else {
			sb.append('F');
		}
		if (total[4]>=total[5]) {
			sb.append('J');
		} else {
			sb.append('M');
		}
		if (total[6]>=total[7]) {
			sb.append('A');
		} else {
			sb.append('N');
		}
		
		String answer="";
		answer=sb.toString();
		System.out.println(answer);
		
	}

}
