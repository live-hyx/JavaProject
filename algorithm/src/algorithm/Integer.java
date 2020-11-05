package algorithm;

public class Integer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer in=new Integer();
		System.out.println(in.q(6,5));

	}
	public int q(int n,int m)//递归
	{
		if(m==1||n==1)
		{
			return 1;
		}
		else if(n<m)
		{
			return q(n,n);
		}
		else if(n>m&&m>1)
		{
			return q(n,m-1)+q(n-m,m);
		}
		else
			return 1+q(n,n-1);
	}

}
