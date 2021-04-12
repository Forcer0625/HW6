public class HW06_4108056036_5 extends Dessert_Desert
{
    final static Object lock=new Object();
    final static int FindCore=5;
    final static AnsFind[] FThread=new AnsFind[FindCore];
    static int arr_len;
    final static int[][] max=new int[FindCore][];
    final static int[][] min=new int[FindCore][];
    static int[] ans;
    public int[][] arr;
    public HW06_4108056036_5()
    {
        for(int i=FindCore-1;i>=0;i--)
        {
            (FThread[i]=new AnsFind(i)).start();
        }   
        
    }
    @Override
    public int[] maxBlocks(int[][] input)
    {
        arr=input;
        arr_len=arr.length;
        ans=new int[arr_len];
        synchronized(lock)
        {
            notifyAll();
        }
        /*if(FThread[0]==null)
            for(int i=FindCore-1;i>=0;i--)
                (FThread[i]=new AnsFind(i)).start();
        else
            for(int i=FindCore-1;i>=0;i--)
                FThread[i].start();*/

        /*try
        {
            for(int i=FindCore-1;i>=0;i--)
                FThread[i].join();
        }catch(InterruptedException e){}*/
        for(int i=0;i<1;i++)
        {
            if(FThread[0].flag &&FThread[1].flag &&FThread[2].flag &&FThread[3].flag &&FThread[4].flag)
                break;
            i--;
        }
        return ans;
    }
    class AnsFind extends Thread
    {
        int id;
        //int len_prev;
        boolean flag;
        public AnsFind(int id)
        {
            this.id=id;
        }
        @Override
        public void run()
        {
            try
            {
                while(true)
                {
                    flag=false;
                    int len=arr[0].length;
                    for(int i=arr_len-1;i>=0;i-=FindCore)
                        if(arr[i].length > len)
                            len=arr[i].length;
                    max[id]=new int[len];
                    min[id]=new int[len];
                    for(int i=arr_len-1-id;i>=0;i-=FindCore)
                    {
                        int[] A=arr[i];
                        int count=0;
                        max[id][0]=min[id][0]=A[0];
                        len=arr[i].length;
                        for(int j=1;j<len;j++)
                        {
                            if(A[j]>=max[id][count])
                            {
                                count++;
                                max[id][count]=min[id][count]=A[j];
                            }
                            else if(A[j]<min[id][count])
                            {
                                min[id][count]=A[j];
                                for (int check=count-1;check>=0;check--)
                                {
                                    if (A[j]>=max[id][check]) break;
                                    else if (A[j]>=min[id][check])
                                    {
                                        count--;
                                        max[check]=max[check+1];
                                        break;
                                    }else
                                    {
                                        count--;
                                        min[id][check]=A[j];
                                        max[id][check]=max[id][check+1];
                                    }
                                }
                            }
                        }
                        ans[i]=++count; 
                    }
                    this.flag=true;
                    synchronized(lock)
                    {
                        this.wait();
                    }
                }
            }catch(InterruptedException e){}
        }
    }
}