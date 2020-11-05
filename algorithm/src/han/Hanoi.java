package han;

import java.util.Scanner;

public class Hanoi{
   
    static int steps;//移动的次数
 
    public static void main(String[] args) {//测试
    	//初始化定义三根柱子
        char A = 'A';
        char B = 'B';
        char C = 'C';
        System.out.println("汉诺塔");
        System.out.println("输入黄金圆盘数：");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();//输入圆盘的数量
        hnt(n, A, B, C);//调用汉诺塔
        s.close();
    }
  
  
    public static void go(int pan, char start, char end ){
    	//打印输出每次圆盘的移动方向（盘子大小由所对应的阿拉伯数字代替）
        System.out.println("第"+(++steps)+"次移动  盘子"+ pan + "  " + "移动方向:" + start +"------->"+ end );
    }
 
 
    public static void hnt(int n, char A, char B, char C){//汉诺塔核心算法
        if(n == 1)
        {
            go(n, A, C);//盘子只有1个时直接移动（从A到C）
        }
        else{
            //把A上n-1个盘子移动到B
            hnt(n - 1, A, C, B);
            //把最大的盘子（第n个盘子）从A移动到C
            go(n, A, C);
            //再把B上n-1个盘子移动到C上
            hnt(n - 1, B, A, C);
        }
    }
}

