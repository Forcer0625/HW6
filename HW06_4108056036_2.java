public class HW06_4108056036_2 extends Dessert_Desert
{
	static int len,arr_len;
	final static int[] min = new int[100000];
	final static int[] max = new int[100000];
	static int[] ans;
	static int[] A;
	@Override
	public int[] maxBlocks(int[][] inputArr)
	{
		ans = new int[inputArr.length];
		for(int i=inputArr.length-1;i>=0;i--)
		{
			A=inputArr[i];
			int check=0;
			int count=0;
			min[check] = max[check] = A[0];
			len=A.length;
			for(int j=1;j<len;j++)
			{
				if(min[check] > A[j])
					min[check] = A[j];
				else if(max[check] <= A[j])
				{
					check++;
					min[check] = max[check] = A[j];
				}
			}
			
			for(int cur_min = min[check--];check>=0;check--)
			{
				if(cur_min >= max[check])
				{
					count++;
					cur_min = min[check];
				}
				else if(cur_min > min[check])
					cur_min = min[check];
			}
			ans[i]=++count;
		}
		return ans;
	}
}
