package algorithm;

import java.util.Scanner;

public class Fullarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fullarray f = new Fullarray();
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int[] a = new int[num];
		for (int i = 0; i < a.length; i++) {
			a[i] = input.nextInt();
		}
		f.Perm(a,0,a.length-1);
		input.close();
		/*int[] a= {1,2,2,3};
		Perm(a,0,a.length-1);*/
	}

	public static void swap(int[] a,int x,int y)//交换函数
	{
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	
	public static boolean isEqual(int[] a,int start,int end)//去重部分
	{
		for(int i=start;i<end;i++)
		{
			if(a[i]==a[end])
			{
				return false;
			}
		}
		return true;
	}
	public static void Perm(int[] a,int k,int m)//递归算法
	{
		if(a == null || k > m || k < 0 || m < 0){
			return;//非法输入检测
		}
		if(k==m)
		{
			for(int i=0;i<a.length;i++)
			{
				System.out.print(a[i]);
			}
			System.out.println();
		}
		else
		{
			for(int i=k;i<=m;i++)
			{
				if(isEqual(a,k,i))
				{
					swap(a,i,k);
					Perm(a,k+1,m);
					swap(a,i,k);
				
				}	
			}
		}
	}
}
