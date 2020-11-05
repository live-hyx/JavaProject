package algorithm;
import java.util.*;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a= {2,4,3,6,7,1,5};
		sort(a,1,a.length-1);
		System.out.println(Arrays.toString(a));
	}
	
	public static void Swap(int a,int b)
	{
		int c=a;
		a=b;
		b=c;
	}

	public static int Partition(int[] a,int p,int r)
	{
		int i = p;
        int j= r;
        
        //将第一个数作为基准值。挖坑
        int x = a[p];
        
        //使用循环实现分区操作
        while(i<j){//5  8
                //1.从右向左移动j，找到第一个小于基准值的值 arr[j]
                while(a[j]>=x && i<j){
                        j--;
                }
                //2.将右侧找到小于基准数的值加入到左边的（坑）位置， 左指针想中间移动一个位置i++
                if(i<j){
                        a[i] = a[j];
                        i++;
                }
                //3.从左向右移动i，找到第一个大于等于基准值的值 arr[i]
                while(a[i]<x && i<j){
                        i++;
                }
                //4.将左侧找到的打印等于基准值的值加入到右边的坑中，右指针向中间移动一个位置 j--
                if(i<j){
                        a[j] = a[i];
                        j--;
                }
        }
        
        //使用基准值填坑，这就是基准值的最终位置
        a[i] = x;//a[j] = y;
        //返回基准值的位置索引
        return i; //return j;
	}
	
	public static void sort(int[] a,int p,int r)
	{
		if(p<r)
		{
			int q=Partition(a,p,r);
			sort(a,p,q-1);
			sort(a,q+1,r);
		}
	}
}
