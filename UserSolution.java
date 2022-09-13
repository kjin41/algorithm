import java.util.ArrayList;
import java.util.TreeSet;

class UserSolution
{
	class Robot implements Comparable<Robot>{
		int rID, wID, wTime, mTime;
		boolean isBroken;
		
		public Robot(int rID, int wID, int wTime, int mTime, boolean isBroken) {
			super();
			this.rID = rID;
			this.wID = wID;
			this.wTime = wTime;		// 일 시작한 시각
			this.mTime = mTime;		// 일한 시간, 고장난 시간 등 현재시각에서 빼면 지능지수
			this.isBroken = isBroken;
		}
		
		@Override
		public int compareTo(Robot o) {		// 지능지수, 고유번호 오름차순
			if (this.mTime==o.mTime)	return this.rID-o.rID;
			return o.mTime-this.mTime;
		}
	}

	TreeSet<Robot> center;
	Robot[] robots;
	ArrayList<Integer>[] jobs;
	
	public void init(int N)
	{
		robots=new Robot[N+1];
		center=new TreeSet<>();
		jobs=new ArrayList[50001];
		for (int i=1; i<=N; i++) {
			robots[i]=new Robot(i, 0, 0, 0, false);
			center.add(robots[i]);
		}
	}

	public int callJob(int cTime, int wID, int mNum, int mOpt)
	{
		jobs[wID]=new ArrayList<>();
		int total=0;
		if (mOpt==1) {
			for (int i=0; i<mNum; i++) {
				total+=robotCall(center.pollFirst(), cTime, wID);
			}
		} else {
			for (int i=0; i<mNum; i++) {
				Robot last=center.last();
				Robot cur=center.ceiling(new Robot(0, 0, 0, last.mTime, false));
				center.remove(cur);
				total+=robotCall(cur, cTime, wID);
			}
		}
		return total;
	}

	private int robotCall(Robot cur, int cTime, int wID) {
		cur.wID=wID;
		cur.wTime=cTime;
		robots[cur.rID]=cur;
		jobs[wID].add(cur.rID);
		return cur.rID;
	}

	public void returnJob(int cTime, int wID)
	{
		for (int i: jobs[wID]) {
			robots[i].mTime+=cTime-robots[i].wTime;
			robots[i].wID=0;
			center.add(robots[i]);
		}
	}

	public void broken(int cTime, int rID)
	{
		Robot cur=robots[rID];
		if (cur.wID==0)	return;
		if (cur.isBroken)	return;
		cur.isBroken=true;
		int size=jobs[cur.wID].size();
		for (int s=0; s<size; s++) {
			if (jobs[cur.wID].get(s)==rID)	{
				jobs[cur.wID].remove(s);
				break;
			}
		}
		cur.wID=0;
	}

	public void repair(int cTime, int rID)
	{
		if (!robots[rID].isBroken) return;
		robots[rID].isBroken=false;
		robots[rID].mTime=cTime;
		center.add(robots[rID]);
	}

	public int check(int cTime, int rID)
	{
		if (robots[rID].isBroken)	return 0;
		if (robots[rID].wID!=0) return -1*robots[rID].wID;
		return cTime-robots[rID].mTime;
	}
}