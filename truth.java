import java.util.*;
class truth
{
  public static void main(String args [])
  {
    Scanner sc=new Scanner(System.in);
    System.out.print("N=");
    int n=sc.nextInt();
    String str[]= new String[n];
    char ch='A';
    for(int i=0;i<n;++i)
      str[i]="";
    int n2=(int)Math.pow(2,n), ind=0, n3=n2;
    while(n2>1)
    {
      int half=n2/2,turn=0;
      str[ind] += ch;
      ch++;
      for(;str[ind].length()<=n3;turn++)
      {
        if(turn<half)
          str[ind] += "0";
        else if(turn<half*2)
          str[ind] += "1";
        else
          turn=-1;
      }
      ind++;
      n2 /= 2;
    }
    System.out.println("OUTPUT");
    for(int i=0;i<=n3;++i)
    {
       for(int j=0;j<n;++j)
       {
         System.out.print(str[j].charAt(i));
         if(j<n-1)
           System.out.print(" | ");
       }    
       System.out.println();
    }
  }
}