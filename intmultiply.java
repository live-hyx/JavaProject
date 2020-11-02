package algorithm;

public class intmultiply {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=-1234;
		int b=-4321;
		System.out.println(multiply(a,b,4));
		System.out.println(a*b);//可用于验证

	}
	public static int Sign(int a)
	{
		if(a>0)
		{
			return 1;
		}
		else if(a<0)
			return -1;
		else
			return 0;
	}
	public static int multiply(int X,int Y,int n)//乘法
	{
		int sign=Sign(X)*Sign(Y);//符号
		int x = Math.abs(X);
		int y = Math.abs(Y);
		if(x==0||y==0)
		{
			return 0;
		}
		if(n==1)
		{
			return sign*x*y;
		}
		else//XY=AC2n+[(A-B)(D-C)+AC+BD]2n/2+BD
		{
			int A = (int) (x / Math.pow(10,(int)n/2));
			int B = x-A*(int)Math.pow(10, (int)n/2);
			int C = (int) (y / Math.pow(10,(int)n/2));
			int D = y-C*(int)Math.pow(10, (int)n/2);
			int AC=multiply(A,C,n/2);
			int BD=multiply(B,D,n/2);
			int W = multiply(A-B,D-C,n/2)+AC+BD;
			return sign*(AC*(int)Math.pow(10, n)+W*(int)Math.pow(10, n/2)+BD);
		}
	}
}
