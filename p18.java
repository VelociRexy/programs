import java.util.*;
class p18
{
  public static void main(String args[])
  {
    Scanner sc=new Scanner(System.in);
    System.out.print("INPUT : ");
    String s =sc.nextLine().toUpperCase();
    StringTokenizer st=new StringTokenizer(s,".!?");
    int ct=st.countTokens();
    System.out.print("OUTPUT : ");
    if(ct!=2 || !(s.endsWith(".") && !s.endsWith("!")&&!s.endsWith("?")))
      System.out.println("INVALID INPUT");
    else
    {
      String s1=st.nextToken();
      String s2=st.nextToken();
      StringTokenizer st1=new StringTokenizer(s1);
      int c1=st1.countTokens();
      String cmn[]=new String[c1];
      int freq[]=new int[c1];
      int id=0;
      for(int i=0;i<c1;i++)
      {
         String nt1=st1.nextToken();
         StringTokenizer st2=new StringTokenizer(s2);
         int c2=st2.countTokens();
         for(int j=0;j<c2;++j)
         {
           boolean b=true ;
           for(int k=0;k<id;k++)
            if(cmn[k].equals(nt1))
              b=false;
           if(nt1.equals(st2.nextToken())&& b==true)
           {
             cmn[id]=nt1;
             id++;
             break;
           }
         }
      }
      s1=s1+s.charAt(s1.length());
      s2=s2+s.charAt(s.length()-1);
      System.out.println(s1+"\n\t"+s2);
      if(cmn[0]==null)
        System.out.println("NO COMMON WORDS");
      else
      {
        for(int i=0;i<id;++i)
        {
          int f=0;
          StringTokenizer st3=new StringTokenizer(s);
          int ct3=st3.countTokens();
          for(int j=0;j<ct3;++j)
          {
            String e=st3.nextToken();
            e=e.replace('!',' ').replace('?',' ').replace('.',' ').trim();
            if(e.equals(cmn[i]))
              f++;
            freq[i]=f;
          }
        }
        System.out.println("COMMON WORDS  FREQUENCY");
        for(int i=0;i<id;++i)
        {
          System.out.println(cmn[i]+"\t\t\t\t"+freq[i]);
        }
      }
    }
  }
}