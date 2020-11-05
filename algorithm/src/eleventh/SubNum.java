package eleventh;

public class SubNum {//子集和数问题-回溯
	 
	// 初始化化一个数组
	int M[] = {1,2,3,4,5,6,7,8,9};
	int N[] = new int[9];
	//用来标识在某种组合中某个数字是否出现
	boolean [] judge =new boolean [9];
	int num;//给定的num
	int temp;//保存和
 
	// 初始化化num
	public SubNum(int num) {
		this.num = num;
	}
 
	// 采用回溯法解决。。
	public void findSub() {
		for (int a = 0; a < M.length; a++) {
			for (int b = a + 1; b < M.length; b++) {
				for(int i=0;i<M.length;i++){//初始化标示数组
					judge [i]=false;
				} 
				temp = M[a];
				judge[a]=true;
				for (int c = b; c < M.length; c++) {
					temp += M[c];
					judge[c]=true;
					if (num == temp) {// 子集找到
						for(int i=0;i<M.length;i++){
							if(judge[i]==true)
								System.out.print(M[i]+"+");
						}
						System.out.print("是一种答案");
						System.out.println();
						temp = temp - M[c];//回溯上一个节点
						judge[c]=false;
					} else if (temp > num) {// 若果大于，则不加这个数，加下一个。
						temp = temp - M[c];
						judge[c]=false;
					} else if (temp < num) {
						// break;// 如果仍小于，继续+。
					}
				}
			}
		}
	}
 
	public void testlast(){
		if (M[M.length - 1] == num)//测试最后一位是否满足条件。。。
			System.out.println(M[M.length-1] + "是一种答案");
	}
	public static void main(String[] agrs) {
		SubNum sn = new SubNum(12);
		sn.findSub();
                sn.testlast();
       }
}

