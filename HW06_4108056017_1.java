
public class HW06_4108056017_1 extends Dessert_Desert {

	public static void main(String[] args) {
		int[][] A = { { 1, 1, 1, 1, 1, 1, 1 }, { 1, 3, 5, 7, 9 }, { 1, 2, 3 }, 
				{ 5, 4, 3, 2, 1 }, { 2, 1, 3, 2 }};
		HW06_4108056017_1 test = new HW06_4108056017_1();
		int[] ans = test.maxBlocks(A);
		int length = ans.length;
		System.out.print("[");
		for(int i = 0; i < length - 1; i++) {
			System.out.print(ans[i] + ", ");
		}
		System.out.println(ans[length - 1] + "]");

	}

	@Override
	public int[] maxBlocks(int[][] inputArr) {
		//這裡是花黑噴 那個黃黃的箭頭
		int num = inputArr.length;
		int[] ans = new int[num];
		
		for(int i = 0; i < num; i++) {
			
			int index = 0;
			int count = 1;
			int length = inputArr[i].length;
			int[][] stack = new int[length][2];
			int min = inputArr[i][0];
			int max = min;
			
			for(int j = 0; ; j++) {
				
				if(j >= length) {
					stack[index][1] = min;
					break;
				}
				
				if(inputArr[i][j] <= min)
					min = inputArr[i][j];
				
				if(inputArr[i][j] > max) {
					stack[index][0] = max;
					stack[index][1] = min;
					min = max = inputArr[i][j];
					index++;
					//System.out.println("count = " + count);
				}
			}
			
			for(int j = index; j > 0; j--) {
				//System.out.println("max = " + stack[j][0] + ", min = " + stack[j][1]);
				if(stack[j - 1][0] > stack[j][1]) {
					if(stack[j - 1][1] > stack[j][1]) {
						stack[j - 1][1] = stack[j][1];
					}
				}
				else count++;
				
			}
			
			ans[i] = count;
		}
		
		
		return ans;
	}
	
}
