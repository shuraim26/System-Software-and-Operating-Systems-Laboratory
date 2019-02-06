import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
public class srt{
public int i,n;
String no,bt,at;
public process proc[]= new process[10];
public void create_proc()
{
try{
DataInputStream in=new DataInputStream(System.in);
BufferedReader bufferedReader = new BufferedReader(new
InputStreamReader(System.in));
System.out.println("Enter the number of process");
n=Integer.parseInt(in.readLine());
for(i=0;i<n;i++)
{
System.out.println("Enter the burst time and arrival time of process "+ i+1);
bt= bufferedReader.readLine();
at= bufferedReader.readLine();
proc[i]=new process(i+1,Integer.parseInt(bt),Integer.parseInt(at));
}
}catch(Exception e){}
}
public void disp()
{
System.out.println("p_id\tB_time\tA_Time");
for(i=0;i<n;i++)
{
System.out.println(proc[i].pid+"\t"+proc[i].bt+"\t"+proc[i].art);
}
}
void findavgTime(process proc[], int n)
{
int wt[] = new int[n], tat[] = new int[n];
int total_wt = 0, total_tat = 0;
findWaitingTime(proc, n, wt);
findTurnAroundTime(proc, n, wt, tat);
System.out.println("processes " +
" Burst time " +
" Waiting time " +
" Turn around time");
for (int i = 0; i < n; i++) {
total_wt = total_wt + wt[i];
total_tat = total_tat + tat[i];
System.out.println(" " + proc[i].pid + "\t\t"
+ proc[i].bt + "\t\t " + wt[i]
+ "\t\t" + tat[i]);
}
System.out.println("Average waiting time = " +
(float)total_wt / (float)n);
System.out.println("Average turn around time = " +
(float)total_tat / (float)n);
}
void findWaitingTime(process proc[], int n,
int wt[])
{
int rt[] = new int[n];
for (int i = 0; i < n; i++)
rt[i] = proc[i].bt;
int complete = 0, t = 0, minm = Integer.MAX_VALUE;
int shortest = 0, finish_time;
boolean check = false;
while (complete != n) {
for (int j = 0; j < n; j++)
{
if ((proc[j].art <= t) &&
(rt[j] < minm) && rt[j] > 0) {
minm = rt[j];
shortest = j;
check = true;
}
}
if (check == false) {
t++;
continue;
}
rt[shortest]--;
minm = rt[shortest];
if (minm == 0)
minm = Integer.MAX_VALUE;
if (rt[shortest] == 0) {
complete++;
finish_time = t + 1;
wt[shortest] = finish_time -
proc[shortest].bt -
proc[shortest].art;
if (wt[shortest] < 0)
wt[shortest] = 0;
}
t++;
}
}
static void findTurnAroundTime(process proc[], int n, int wt[], int tat[])
{
for (int i = 0; i < n; i++)
tat[i] = proc[i].bt + wt[i];
}
}
