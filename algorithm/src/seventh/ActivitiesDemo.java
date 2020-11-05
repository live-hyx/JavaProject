package seventh;

public class ActivitiesDemo {

    /*
     * 贪心算法求解活动安排问题
     * 设有n个活动的集合E={1,2,…,n}，其中每个活动都要求使用同一资源，
     * 如会议室使用，安排演讲会场等等，而在同一时间内只有一个活动能使用这一资源。
     * 每个活动i都有一个要求使用该资源的起始时间si和一个结束时间fi,且si <fi 。
     * 如果选择了活动i，则它在半开时间区间[si, fi)内占用资源。
     * 若区间[si, fi)与区间[sj, fj)不相交，则称活动i与活动j是相容的。
     * 也就是说，当si≥fj或sj≥fi时，活动i与活动j相容。  
     * 
     * 在下面所给出的解活动安排问题的贪心算法选择函数greedySelector。
     * 
     * 说明：由于输入的活动以其完成时间的非减序排列，所以算法greedySelector
     * 每次总是选择具有最早完成时间的相容活动加入集合A中。
     * 直观上，按这种方法选择相容活动为未安排活动留下尽可能多的时间。
     * 也就是说，该算法的贪心选择的意义是使剩余的可安排时间段极大化，以便安排尽可能多的相容活动。
     * 算法greedySelector的效率极高。当输入的活动已按结束时间的非减序排列，
     * 算法只需O(n)的时间安排n个活动，使最多的活动能相容地使用公共资源。
     * 如果所给出的活动未按非减序排列，可以用O(nlogn)的时间重排（随机快排）。
     * 
     * */

    public static int greedySelector(int[] s, int[] f, boolean[] a) {

        int n = s.length - 1;
        //安排第一个活动，标记为true
        a[1] = true;
        int j = 1;
        int count = 1;

        for (int i = 2; i <= n; i++) {
            //检验当前最早结束的活动的开始时间是否晚于前一个活动的结束结束时间
            if (s[i] >= f[j]) {
                //如果晚于，则表示两个活动相互兼容，将活动标记为true
                a[i] = true;
                j = i;
                //记已经安排活动的个数
                count++;
            } else {
                //与已安排活动不兼容，标记此活动未安排
                a[i] = false;
            }

        }
        return count;

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //初始化数据s数组记录活动开始时间；f数组记录活动结束时间
        int[] s = { 1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12 };
        int[] f = { 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
        //声明一个boolean型数组
        boolean[] a = new boolean[s.length];

        int result = greedySelector(s, f, a);
        System.out.println("Result is: " + result);
        for (int i = 1; i <= s.length - 1; i++) {
            if (a[i]) {
                System.out.println("第" + i + "活动被选中，其开始时间为：" + s[i] + "，结束时间为：" + f[i]);
            }
        }

    }

}

