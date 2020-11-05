package algorithm;

public class binarysearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {1,2,3,4,5,6,7,8};
		System.out.println(search(a,3,0,a.length-1));

	}
	public static int search(int[] a,int x,int start,int end)//二分查找递归
	{
		if(start>end)
		{
			return -1;
		}
		int m=(start+end)/2;
		if(a[m]==x)
		{
			return m;
		}
		else if(x<a[m])
		{
			return search(a,x,start,m-1);
		}
		else
		{
			return search(a,x,m+1,end);
		}
	}

}
