import java.io.*;
public class os_first {
public static void main(String[] args)
{
int ch=0;
do{
try{
System.out.println("Menu...");
System.out.println("1... SRT");
System.out.println("2... RR");
System.out.println("Enter your choice..:");
DataInputStream in=new DataInputStream(System.in);
ch=Integer.parseInt(in.readLine());
switch(ch)
{
case 1: srt s=new srt(); s.create_proc(); s.disp(); s.findavgTime(s.proc, s.n);
break;
case 2: rr r=new rr(); r.create_proc(); r.disp(); r.findavgTime(r.proc, r.n);
break;
}
}catch(Exception e){}
}while(ch<=2&& ch>0);
}
}