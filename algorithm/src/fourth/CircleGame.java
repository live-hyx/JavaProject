package fourth;

import java.util.LinkedList;

public class CircleGame {  
     
	   public static void main(String[] args) {
			//实例化对象
		   CircleGame d = new CircleGame(32);
			d.print();
		}
   private int num; // 人数  
   private LinkedList<Integer> list = new LinkedList<Integer>();  
   public CircleGame(int n)  {  
       this.num = n;  
       init();  
   }  
 
   private void init()  {  
       if (num % 2 == 0)  { //偶数个   
           for (int i = 0; i < num; i++) {  
               list.add(i + 1);  
           }  
       }  
       else  //奇数个  
       {  
           for (int i = 0; i < num; i++)  
           {  
               list.add(i + 1);  
           }  
           list.add(0);  
       }  
   }  
   public void print()  {  
       for (int i = 0; i < list.size() - 1; i++)  {  
           System.out.println("第" + (i + 1) + "天赛程如下：");  
           for (int j = 0; j < list.size() / 2; j++)  {  
               System.out.println(list.get(j) + "--"  
                       + list.get(list.size() - 1 - j));  
           }  
           int temp = list.pollLast();  //获取最后一个元素
           //System.out.println(list.get(1));
           list.add(1, temp);//将最后一个元素放在List的第二个位置
       }  
   } 

}

