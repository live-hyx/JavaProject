package fifth;


/**
 * array[i][j]
 * 		表示Ai...Aj的最佳计算次序所对应的相乘次数 即存放各子问题的最优值
 * s[i][j]=k
 * 		表示Ai...Aj这(j-i+1)个矩阵中最优加括号方法为(Ai...Ak)(Ak+1...Aj),
 * 		即存放了各子问题的最优决策
 * p[i]表示Ai的行数，p[i+1]表示Ai的列数 
 */
public class Matrix{
 
    private int array[][];  
    private int p[];  
    private int s[][];  
      
    public Matrix(){
    	//六个矩阵有七个数
        p=new int[]{5,3,4,7,2,3,6};  
        array=new int[6][6];  
        s=new int[6][6];  
    }  
    /**动态规划*/
    public void martixChain(){  
        int n=array.length;  
        for(int i=0;i<n;i++){
            array[i][i]=0;
        }
        for(int r=2;r<=n;r++){  		//不同规模的子问题
            for(int i=0;i<=n-r;i++){    //每一个规模为r的矩阵连乘序列的首矩阵Ai
                int j=i+r-1;  			//每一个规模为r的矩阵连乘序列的尾矩阵Aj
                // 决策为k=i的乘法次数
                array[i][j]=array[i+1][j]+p[i]*p[i+1]*p[j+1];  
                s[i][j]=i;
                for(int k=i+1;k<j;k++){ //对Ai...Aj的所有决策，求最优值，记录最优决策
                    int t=array[i][k]+array[k+1][j]+p[i]*p[k+1]*p[j];  
                    if(t<array[i][j]){  
                        array[i][j]=t;
                        s[i][j]=k;
                    }  
                }  
            }  
        }  
    }  
    /* 
     * 待求矩阵为：Ai...Aj
     */  
    public void traceBack(int i ,int j){
    	if(i<j){
    		traceBack(i,s[i][j]);
    		traceBack(s[i][j]+1,j);
    		if(i==s[i][j] && (s[i][j]+1)==j){
    			System.out.println("把A"+(i+1)+"到A"+(j+1)+"括起来");
    		}else if(i==s[i][j] && (s[i][j]+1)!=j){
    			System.out.println("把A"+((s[i][j]+1)+1)+"到A"+(j+1)+"括起来,在把A"+(i+1)+"到A"+(j+1)+"括起来");
    		}else if(i!=s[i][j] && (s[i][j]+1)==j){
    			System.out.println("把A"+(i+1)+"到A"+(s[i][j]+1)+"括起来,在把A"+(i+1)+"到A"+(j+1)+"括起来");
    		}else{
    			System.out.println("把A"+(i+1)+"到A"+(s[i][j]+1)+"括起来，在把A"+((s[i][j]+1)+1)+"到A"+(j+1)+"括起来，然后把A"+(i+1)+"到A"+(j+1)+"括起来");
    		}
    	}
    }
    public static void main(String[] args) {  
        Matrix m=new Matrix();  
        m.martixChain();
        m.traceBack(0, 5);
    }
}


 
 
 
 
 


