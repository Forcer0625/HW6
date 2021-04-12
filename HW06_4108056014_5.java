
public class HW06_4108056014_5 extends Dessert_Desert{
	int[] min = new int[100000];
	int[] max = new int[100000];
	int[] ans;
	int[] Arr;
	int last,cur_min;
	@Override
	public int[] maxBlocks(int[][] inputArr) {
		ans = new int[inputArr.length];
		for(int i=0;i<inputArr.length;i++) {
			Arr = inputArr[i];
			last=0;
			ans[i]=1;
			min[last] = max[last] = Arr[0];
			for(int j=1;j<Arr.length;j++) {
				if(min[last] > Arr[j]) {
					min[last] = Arr[j];
				}
				else if(max[last] <= Arr[j]) {
					last++;
					min[last] = max[last] = Arr[j];
				}
			}
			cur_min = min[last];
			for(int j=last-1;j>=0;j--) {
				if(cur_min >= max[j]) {
					ans[i]++;
					cur_min = min[j];
				}
				else if(cur_min > min[j]) {
					cur_min = min[j];
				}
			}
		}
		return ans;
	}
}
