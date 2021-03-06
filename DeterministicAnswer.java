public class DeterministicAnswer extends Dessert_Desert
{
    static int arr_len,len;
    static int[] A,ans,max,min;
    @Override
    public int[] maxBlocks(int[][] arr)
    {
        arr_len=arr.length;
        ans=new int[arr_len];
        len=arr[0].length;
        for(int i=arr_len;i>1;len=len<arr[--i].length?arr[i].length:len);     
        int[] max=new int[len];
        int[] min=new int[len];
        for(int i=arr_len-1;i>=0;i--)
        {
            A=arr[i];
            len=A.length;
            int count=0;
            max[0]=min[0]=A[0];
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
        return ans;
    }
}