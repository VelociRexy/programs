import java.io.*;
public class Program13
{
  public static void main (String args[]) throws IOException
  {
    BufferedReader br=new BufferedReader(new InputStreamReader (System.in));
    System.out.print("INPUT:N=");
    int n=Integer.parseInt(br.readLine());
    if(n>2&&n<9)
    {
      String teams[]=new String[n];
      for(int i=0;i<n;++i)
      {
        System.out.print("TEAM "+(i+1)+":");
        teams[i]=br.readLine();
      }
      System.out.println("OUTPUT");
      int maxlen=teams[0].length();
      for(int i=0;i<n;++i)
      {
        if(teams[i].length()>maxlen)
          maxlen=teams[i].length();
      }
      for(int i=0;i<n;i++)
      {
        int eachlen=teams[i].length();
        while(eachlen<maxlen)
        {
          teams[i]+=" ";
          eachlen++;
        }
      }
      for(int i=0;i<maxlen;i++)
        {
          for(int j=0;j<n;j++)
            System.out.print(teams[j].charAt(i)+"\t");
          System.out.println();
        }
    }
    else
        System.out.print("OUTPUT:NUMBER OF TEAMS OUT OF RANGE");
  }
}