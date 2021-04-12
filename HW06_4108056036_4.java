public class HW06_4108056036_4 extends Dessert_Desert
{
    final static int FindCore=5;
	final static int[] min = new int[500000];
	final static int[] max = new int[500000];
    final static AnsFind[] FThread = new AnsFind[FindCore];
    static int[][] arr;;
    static int[] ans;
    @Override
    public int[] maxBlocks(int[][] inputArr)
    {
        arr=inputArr;
        ans=new int[arr.length];
        for(int i=FindCore-1;i>=0;i--)
            (FThread[i]=new AnsFind(i)).start();
        
        try
        {
            for(int i=FindCore-1;i>=0;i--)
                FThread[i].join();
        }catch(InterruptedException e){}

        return ans;
    }
    class AnsFind extends Thread
    {
        int id;
        int[] A;
        public AnsFind(int id)
        {
            this.id=id;
        }
        @Override
        public void run()
        {
            for(int i=arr.length-1-id;i>=0;i-=FindCore)
            {
                A=arr[i];
                int check=id;
                int count=0;
                min[check] = max[check] = A[0];
                int len=A.length;
                for(int j=1;j<len;j++)
                {
                    if(min[check] > A[j])
                        min[check] = A[j];
                    else if(max[check] <= A[j])
                    {
                        check+=FindCore;
                        min[check] = max[check] = A[j];
                    }
                }
                int cur_min = min[check];
                for(check-=FindCore;check>=0;check-=FindCore)
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
        }
    }
}