// count ways to reach the nth stair . The person can climb either 1 or 2 stair at a time

// recursion method  O(2^n)

import java.util.Arrays;
public class climbing_stairs{
  
  public static int countWayRe(int n){
    if(n==0)
      return 1;
    if(n<0)
      return 0;
    
    return countWayRe(n-1)+countWayRe(n-2);
  }


  // Memorization O(n)

   public static int countWayMo(int n,int[] f){
    if(n==0)
      return 1;
    if(n<0)
      return 0;
     if(f[n]!=-1)  // Already calculated
       return f[n];
    
    f[n]= countWayMo(n-1,f)+countWayMo(n-2,f);
     return f[n];
  }

  // Tabulation 

  public static int waysTabu(int n) {
    int way[]=new int[n+1];
    way[0]=1;

    // tabulation loop
    for(int i=1;i<=n;i++){
      if(i==1){
    way[i]=way[i-1]+0;
      }
      else {
        way[i]=way[i-1]+way[i-2];
      }
    }
      return way[n];
    }
  
  public static void main(String arg[]) {
    int n=5; // n=3-->3 & n=4-->5 , so n=5-->8
    System.out.println(countWayRe(n));
    int f[]=new int[n+1]; // 0,0,0,0.. bydefault 
    Arrays.fill(f,-1);  // -1,-1,-1.. fill -1 at each index
    System.out.println(countWayMo(n,f));
      System.out.println(waysTabu(n));
  }
} 
