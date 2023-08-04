// Online Java Compiler
// Use this editor to write, compile and run your Java code online




public class t_knapsack{

  
  // Recursion
  // O(2^n)
  
  public static int knapsack(int val[],int wt[],int W,int n) {
      if(W==0||n==0){
          return 0;
      }
    if (wt[n-1]<=W) {// valid condition
      // include
    int  ans1=val[n-1]+knapsack(val,wt,W-wt[n-1],n-1);

      // exclude
     int ans2=knapsack(val,wt,W,n-1);
      return Math.max(ans1,ans2);
    }
      
    else {
      return knapsack(val,wt,W,n-1);
    }
  }

  // Memorization 
  //O(nW)

   public static int knapsackMemo(int val[],int wt[],int W,int n,int dp[][]) {
      if(W==0||n==0){
          return 0;
      }

      if(dp[n][W]!=-1)
        return dp[n][W];
     
    if (wt[n-1]<=W) {// valid condition
      // include
    int  ans1=val[n-1]+knapsack(val,wt,W-wt[n-1],n-1);

      // exclude
     int ans2=knapsack(val,wt,W,n-1);
      dp[n][W]= Math.max(ans1,ans2);
      return dp[n][W];
    }
      
    else {
      dp[n][W]= knapsack(val,wt,W,n-1);
      return dp[n][W];
    }
  }
  
  
 // Tabulation 
  
  public static void print(int dp[][]){
      for(int i=0;i<dp.length;i++){
          for(int j=0;j<dp[0].length;j++){
              System.out.print(dp[i][j]);
          }
          System.out.println();
      }
      System.out.println();
  }

  
 public static int Tab(int val[],int wt[],int W ){
      int n=val.length;
      int dp2[][] =new int[n+1][W+1];
      for(int i=0;i<dp2.length;i++){
          dp2[i][0]=0;
      }
      for(int j=0;j<dp2[0].length;j++){
          dp2[0][j]=0;
      }
      for(int i=0;i<n+1;i++){
          for(int j=0;i<W+1;j++){
              int v=val[i-1]; // ith item value
              int w=wt[i-1];  // ith item weight
             if(w<=j){ // total allowed capacity j 
                  int incProfit=v+dp2[i-1][j-w];
                  int excProfit=dp2[i-1][j];
                  dp2[i][j]=Math.max(incProfit,excProfit);
                  
                  
              }
              else{  // invalid
                  int excProfit=dp2[i-1][j];
                  dp2[i][j]=excProfit;
              }
          }
      }
      print(dp2);
      return dp2[n][W];
  }
  
  public static void main(String arg[]) {
    int val[]={15,14,10,45,30};
    int wt[]={2,5,1,3,4};
    int W=7;
    int dp[][]=new int[val.length+1][W+1];
    for(int i=0;i<dp.length;i++) {
      for(int j=0;j<dp[0].length;j++){
        dp[i][j]=-1;
      }
    }
    
    System.out.println(knapsack(val,wt,W,val.length));
    System.out.println(knapsackMemo(val,wt,W,val.length,dp));
    System.out.println(Tab(val,wt,W));
  }
}
