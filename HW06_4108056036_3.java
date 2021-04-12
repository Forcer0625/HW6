public class HW06_4108056036_3 extends Dessert_Desert
{
    final static int FindCore=4;
    final static AnsFind[] FThread=new AnsFind[FindCore];
    static int arr_len;
    static int[] ans;
    public int[][] arr;
    @Override
    public int[] maxBlocks(int[][] input)
    {
        arr=input;
        arr_len=arr.length;
        ans=new int[arr_len];

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
        public AnsFind(int id)
        {
            this.id=id;
        }
        @Override
        public void run()
        {
            int len=arr[0].length;
            for(int i=arr_len-1;i>=0;i-=FindCore)
                if(arr[i].length > len)
                    len=arr[i].length;
            int[] max=new int[len];
            int[] min=new int[len];
            for(int i=arr_len-1-id;i>=0;i-=FindCore)
            {
                int[] A=arr[i];
                int count=0;
                max[0]=min[0]=A[0];
                len=arr[i].length;
                for(int j=1;j<len;j++)
                {
                    if(A[j]>=max[count])
                    {
                        count++;
                        max[count]=min[count]=A[j];
                    }
                    else if(A[j]<min[count])
                    {
                        min[count]=A[j];
                        for (int check=count-1;check>=0;check--)
                        {
                            if (A[j]>=max[check]) break;
                            else if (A[j]>=min[check])
                            {
                                count--;
                                max[check]=max[check+1];
                                break;
                            }else
                            {
                                count--;
                                min[check]=A[j];
                                max[check]=max[check+1];
                            }
                        }
                    }
                }
                ans[i]=++count; 
            }
        }
    }
}