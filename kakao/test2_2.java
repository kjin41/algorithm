
public class test2_2 {
	public static void main(String[] args) {
		int answer=0;
		int[] queue1= {3, 2, 7, 2};
		int[] queue2= {4,6,5,1};
		
		int length=queue1.length;
		int[] queue=new int[length*2];
		long total=0;
		long total1=0;
		for (int i=0; i<length; i++) {
			queue[i]=queue1[i];
			queue[i+length]=queue2[i];
			total+=queue1[i]+queue2[i];
			total1+=queue1[i];
		}
		
		int left=0; 
		int right=length-1;
		boolean flag=false;
		while(left<=right && right<length*2-1 && left>=0) {
			if (total1<total/2) {
				right++;
				total1+=queue[right];
			} else if ((total1>total/2)){
				total1-=queue[left];
				left++;
			} else {
				flag=true;
				break;
			}
			answer++;
		}
		
		if (!flag) {
			answer=-1;
		}
		System.out.println(answer);
		
	}

}
