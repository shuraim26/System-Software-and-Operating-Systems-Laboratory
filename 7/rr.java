import java.io.DataInputStream;
public class rr{
int i,n;
int no,bt,at,q;
process proc[]= new process[10];
public void create_proc()
{
try{
DataInputStream in=new DataInputStream(System.in);
System.out.println("Enter the number of process");
n=Integer.parseInt(in.readLine());
for(i=0;i<n;i++)
{
System.out.println("Enter the burst time and arrival time of process "+ i+1);
bt=Integer.parseInt(in.readLine());
at=Integer.parseInt(in.readLine());
proc[i]=new process(i+1,bt,at);
}
System.out.println("Enter Time quantum:");
q=Integer.parseInt(in.readLine());
}catch(Exception e){}
}
public void disp()
{
System.out.println("p_id\tB_time\tA_Time");
for(i=0;i<n;i++)
{
System.out.println(proc[i].pid+"\t"+proc[i].bt+"\t"+proc[i].art);
}
System.out.println("Quantum : "+ q);
}
void findavgTime(process proc[], int n)
{
System.out.println("function statred");
int wt[] = new int[n], tat[] = new int[n];
int total_wt = 0, total_tat = 0;
// Function to find waiting time of all processes
findWaitingTime(proc, n, wt);
// Function to find turn around time for all processes
findTurnAroundTime(proc ,n, wt, tat);
// Display processes along with all details
System.out.println("Processes " + " Burst time " +
" Waiting time " + " Turn around time");
// Calculate total waiting time and total turn
// around time
for (int i=0; i<n; i++)
{
total_wt = total_wt + wt[i];
total_tat = total_tat + tat[i];
System.out.println(" " + (i+1) + "\t\t" + proc[i].bt +"\t " +
wt[i] +"\t\t " + tat[i]);
}
System.out.println("Average waiting time = " +
(float)total_wt / (float)n);
System.out.println("Average turn around time = " +
(float)total_tat / (float)n);
}
void findTurnAroundTime(process proc[], int n,
int wt[], int tat[])
{
// calculating turnaround time by adding bt[i] + wt[i]
for (int i = 0; i < n ; i++)
tat[i] = proc[i].bt + wt[i];
}
void findWaitingTime(process proc[], int n , int wt[])
{
System.out.println("findwaiting time is strated");
int rem_bt[] = new int[n];
for (int i = 0 ; i < n ; i++)
rem_bt[i] = proc[i].bt;
int t = 0; // Current time
while(true)
{
boolean done = true;
// Traverse all processes one by one repeatedly
for (int i = 0 ; i < n; i++)
{
if (rem_bt[i] > 0)
{
done = false; // There is a pending process
if (rem_bt[i] > q)
{
t += q;
rem_bt[i] -= q;
}
else
    {
t = t + rem_bt[i];
wt[i] = t -proc[i].bt-proc[i].art;
rem_bt[i] = 0;
}
}
}
if (done == true)
break;
}
}
}