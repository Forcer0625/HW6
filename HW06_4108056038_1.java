public class HW06_4108056038_1 extends Dessert_Desert {
    public static void main(String[] args) {
        HW06_4108056038_1 test = new HW06_4108056038_1();
        int[][] a = {{1,4,8,5,4,9,7,9},{1},{3,2,5,1,9},{1,2,9,9,2}};
        for(int i=0;i<a.length;i++) {
            System.out.println(test.maxBlocks(a)[i]);
        }
    }
    public int[] maxBlocks(int[][] inputArr) {
        int len = inputArr.length;
        int[] re = new int[len];
        for(int i=0;i<len;i++) {
            int jlen = inputArr[i].length;
            int[] max = new int[jlen];
            int[] min = new int[jlen];
            int count=1;
            max[0]=min[0]=inputArr[i][0];
            for(int j=1;j<jlen;j++) {
                if(inputArr[i][j]>=max[count-1]) {
                    count++;
                    max[count-1]=min[count-1]=inputArr[i][j];
                }else if (inputArr[i][j]<min[count-1]) {
                    min[count-1]=inputArr[i][j];
                    for (int check=count-2;check>=0;check--) {
                        if (inputArr[i][j]>=max[check]) break;
                        else if (inputArr[i][j]>=min[check]) {
                            count--;
                            max[check]=max[check+1];
                            break;
                        }else {
                            count--;
                            min[check]=inputArr[i][j];
                        }
                    }
                }
            }
            re[i]=count; 
        }
        return re;
    }
}