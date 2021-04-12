import java.util.Random;
public class newTesting {
    public final static int LEN=100000;                         //inputArray length 
    public final static int MAX_LEN=2000;                      //single array max len
    public final static int RUNNING_TIMES=200;               //RunningTimes.
    public final static int DIVIDE_RANGE=100;                   //average divded block (~= MAX_LEN/DIVIDE_RANGE) @smaller is harder
    public static void main(String[] args)  throws Exception
    {
        DeterministicAnswer DA=new DeterministicAnswer();
        Dessert_Desert t=new HW06_4108056036_1();
        long TIME_SUM=0;
        Random ran=new Random();
        int[][] inputArray;
        for(int i=0;i<RUNNING_TIMES;i++)
        {
            inputArray=new int[LEN][];

            for(int j=0;j<LEN;j++)
                inputArray[j]=Blocks((int)(ran.nextGaussian()+1)*(MAX_LEN<<1));
            int[] ansCorrect=DA.maxBlocks(inputArray);
            long time_start=System.nanoTime();
            int[] ansFind=t.maxBlocks(inputArray);
            TIME_SUM+=(System.nanoTime()-time_start);
            if(!AnsCheck(ansCorrect, ansFind))
                throw new Exception();
        }
        System.out.println("-> 0.00000000"+(((TIME_SUM/RUNNING_TIMES))));
    }
    
    public static boolean AnsCheck(int[] ans,int[] ans2)
    {
        if(ans.length!=ans2.length)
            return false;

        for(int i=0;i<ans.length;i++)
            if(ans[i]!=ans2[i])
                return false;
        

        return true;
    }
    public static int[] Blocks(int len)
    {
        int[] re=new int[len];
        int index=0;
        for(int i=0;index<len && i<DIVIDE_RANGE ;i++)
        {
            for(int j=0;j<DIVIDE_RANGE && index<len;j++)
            {
                /*int num=(Math.random()+i)*DIVIDE_RANGE;
                if()*/
            }
        }
        return re;
    }
}
