public class testing {
    final static int RUNNING_TIMES=100;
    public static void main(String[] args)
    {
        Dessert_Desert t=new HW06_4108056014_5();
        long sum=0;
        int[][] ex={
                    {1,1,1,1,1,1,1},//7
                    {1,3,5,7,9},//5
                    {1,2,3},//3
                    {5,4,3,2,1},//1
                    {2,1,3,2},//2
                    {1,4,5,4,9,8},//4
                    {1},//1
                    {2,1},//1
                    /////// simpe N Special
                    {7,2,5,8,4,2,8,9},//3
                    {1,4,8,5,4,9,7,9},//4
                    {3,2,1,2,4,6,5,2},//1
                    {3,2,5,1,9},//2
                    {1,2,9,9,2},//3
                    {1,4,8,5,4,10,7,9},//3
                    {-4,-2,0,7,3,9},//5
                    {3,2,-4,-2,3,1,2,4,6,5,2,7,7,9,8,8,10},//5
                    {1,2,1,2,1,2,1,2},//3
                    {1,3,5,7,9,3,5,7,9,5,7,9,7,9}//4
                    };
        AnsPrint(t.maxBlocks(ex));
        for(int i=0;i<RUNNING_TIMES;i++)
        {
            long time_start=System.nanoTime();
            t.maxBlocks(ex);
            sum+=(System.nanoTime()-time_start);
        }
        System.out.println("-> "+(((sum/RUNNING_TIMES))));
    }
    public static void AnsPrint(int[] arr)
    {
        int len=arr.length;
        for(int i=0;i<len;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}
