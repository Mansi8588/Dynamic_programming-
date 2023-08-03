public class fibonacci {
  public static int fib(int data) {
  if(data==1||data==0)
  return data;
   return fib(data-1)+fib(data-2);
  }
    public static void main(String[] arg) {
      int n=5;
      System.out.println(fib(n));
    }
  }
      
