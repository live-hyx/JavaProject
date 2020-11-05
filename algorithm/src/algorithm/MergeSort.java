package algorithm;

import java.util.Arrays;
 
public class MergeSort {
    public static void main(String[] args)
    {
        int[] arr={8,4,5,7,1,3,6,2,45,23,0};
        createArray(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void createArray(int[] arr)
    //在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
    {
        int[] temp=new int[arr.length];
        divide(arr,0,arr.length-1,temp);
    }
 
    public static void divide(int[] arr,int left,int right,int[] temp)
    {
        if(left<right)
        {
            int middle=(right+left)/2;
            divide(arr,left,middle,temp);//左边归并排序，使得左子序列有序
            divide(arr,middle+1,right,temp);//右边归并排序，使得右子序列有序
            merge(arr,left,middle,right,temp);//将两个有序子数组合并操作
 
        }
    }
    public static void merge(int[] arr,int left,int middle,int right,int[] temp)
    {
        int i=left;
        int j=middle+1;
        int k=0;//临时数组指针
        while (i<=middle&&j<=right)
        {
            if(arr[i]<arr[j])
            {
                temp[k]=arr[i];
                i++;
                k++;
            }
            else {
                temp[k]=arr[j];
                j++;
                k++;
            }
        }
        while (i<=middle)//将左边剩余元素填充进temp中
        {
            temp[k]=arr[i];
            i++;
            k++;
        }
        while (j<=right)//将右序列剩余元素填充进temp中
        {
            temp[k]=arr[j];
            j++;
            k++;
        }
        int t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[t++];
        }
    }
}


