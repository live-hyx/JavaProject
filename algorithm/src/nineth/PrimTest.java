package nineth;

import java.util.*;

public class PrimTest {
	
	public static void main(String[] args) {
//交互输入图的邻接矩阵表示，为方便测试，直接给定了邻接矩阵值
//		System.out.println("请输入图定点个数： ");
//		Scanner sc = new Scanner(System.in);
//		String line = sc.nextLine();
//		int n = Integer.parseInt(line);
//		System.out.println("请输入图的路径长度: ");
//		int[][] c = new int[n+1][n+1];
//		for(int i = 0; i < n; i++) {
//			line = sc.nextLine();
//			String[] ds = line.split(",");
//			for(int j = 0;j < ds.length; j++) {
//				c[i+1][i+1] = Integer.parseInt(ds[j]);
//				
//			}
//		}
//		System.out.println("一次构成树的边为： ");
		int n = 6;
		//c[i][j]表示从i到j的权，
		//自己到自己的权，以及不能直接到的值置-1，方便后面处理
		int[][] c = {
						{0,0,0,0,0,0},
						{0,-1,6,1,5,-1,-1},
						{0,6,-1,5,-1,3,-1},
						{0,1,5,-1,5,6,4},
						{0,5,-1,5,-1,-1,2},
						{0,-1,3,6,-1,-1,6},
						{0,-1,-1,4,2,6,-1}
		};
		prim(n,c);
		
	}
	public static void prim(int n, int[][] c) {
		//lowcost[i] 表示 从1到i的最短权值
		int[] lowcost = new int[n+1];
		//closest[i]的表示：
		//将整个节点空间定为V，已选的空间从S=1（只有第一个点）开始，
		//j在V-S中，找到S里离j最近的节点i ，就记录在closest[j]。
		int[] closest = new int[n+1];
		//哪些节点已经进入S空间
		boolean[] s = new boolean[n+1];
		//节点1进入S中，此为初始化
		s[1] = true;
		//初始化
		for(int i = 2; i <= n; i++) {
			//初始化第一个节点到每个节点权值
			lowcost[i] = c[1][i];
			//初始化，因为S中只有1，所以每个V-S中的节点最近的S中的节点一定是1
			closest[i] = 1;
			//这些节点都初始化为不在S中的状态
			s[i] = false;
		}
		//n-1次遍历，把S空间扩充成V
		for(int i = 1;i < n; i++) {
			//记录一个当前最小权值，不断比较最终变为整个1次遍历过程的最小权值
			int min = Integer.MAX_VALUE;
			//初始化j，j其实代表的是V-S空间中被选进S的节点
			//它的特征是，它到S（任何节点）的权值比其他节点到S（同样随便哪个节点）都小
			//这里的思想就是贪心的概念，通过局部最优可以得到全局最优
			int j = 1;
			//遍历除了直接初始化在S中的1节点外的其他所有节点
			for(int k = 2; k <= n; k++) {
				//不等于-1即，直接有权值，然后迭代出最小的lowcost，同时更新一些值。
				//这里举例更容易说明，如lowcost[k]其实代表的是目前的S空间到k的最小权值，迭代找到了这个k，那么 显然 j就应该是k
				if(lowcost[k] != -1 && lowcost[k] < min && !s[k]) {
					min = lowcost[k];
					j = k;
				}
			}
			//输出这对连接，closest[j]记录的其实就是达成lowcost[k]这一最小权值时，S中具体是哪个节点
			System.out.println(closest[j] + "-" + j);
			//如此，把j纳入S空间
			s[j] = true;
			//j进入S空间后，更新除1节点外所有节点的状态，他们到S的最小权值还得看看他们到 新进入的j是否更小
			for(int k = 2; k <= n; k++) {
				if(!s[k] && c[j][k] != -1) {
					//这里注意，如果lowcost[k]本来是-1
					//说明本来都不相连直接可以更新了
					//这里的逻辑要搞清楚，先判断有必要更新么？（c[j][k]!= -1),然后判断 要么c[j][k]比之前的权值更小，要么原来都不相连（c[j][k] < lowcost[k] || lowcost[k] == -1) 此时进行更新！
				if(c[j][k] < lowcost[k] || lowcost[k] == -1) {
						//更新该节点最小的权值
						lowcost[k] = c[j][k];
						//更新该节点在S中最近的点
						closest[k] = j;
					}
				}
			}
			
		}
	}
}

