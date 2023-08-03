public class fibonacci {
  public static int fib(int n,int f[]) {
  if(n==1||n==0){
  return n;
  }
    if(f[n]!=0) {// fib(n) is already calculated 
      return f[n];
  }
   f[n]= fib(n-1,f)+fib(n-2,f);
    return f[n];
  }
    public static void main(String[] arg) {
      int n=5;
      int f[]=new int[n+1];    // f[]=0,0,1,2,3,5
    System.out.println(fib(n,f));
    System.out.println();
    for(int i=0;i<n+1;i++){
       System.out.println(fib(i,f)); 
    }
      for(int i=0;i<n+1;i++){
       System.out.println(f[i]); 
    }
    }
  }
      
