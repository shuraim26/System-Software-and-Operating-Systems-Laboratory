package bankers; 

import java.io.IOException;
import java.util.Scanner;

public class Bankers {
    //np = no. of processes \ nr = no. of resources
    private int need[][],allocate[][],max[][],avail[],np,nr;
    
    private void input(){
         Scanner sc = new Scanner(System.in);
         System.out.print("Enter no. of processes and resources: ");
         np=sc.nextInt();  //no. of processes
         nr=sc.nextInt();  //no. of resources
         need=new int[np][nr];  //initializing arrays
         max=new int[np][nr];
         allocate= new int[np][nr];
         avail=new int [nr];

         System.out.println("Enter allocation matrix: ");
         for(int i=0;i<np;i++)
              for(int j=0;j<nr;j++)
             allocate[i][j]=sc.nextInt();  //allocation matrix

         System.out.println("Enter max. matrix: ");
         for(int i=0;i<np;i++)
              for(int j=0;j<nr;j++)
             max[i][j]=sc.nextInt();  //max matrix

            System.out.println("Enter available matrix: ");
            for(int j=0;j<nr;j++)
                avail[j]=sc.nextInt();  //available matrix

            sc.close();
    }
    
    //calculate the need matrix
    private void calc_need(){
        for(int i=0;i<np;i++){
            for(int j=0;j<nr;j++){  //calculating need matrix
                need[i][j]=max[i][j]-allocate[i][j];
            }
        }
    }
 
    //Check if the requested resource is available or not
    private boolean check(int row){
       //checking if all resources for it^(h) process can be allocated
      for(int j=0;j<nr;j++) {
        if(avail[j]<need[row][j]) {
          return false;
        }
      }
      return true;
    }

    
    // Check if by fulfilling the resource request the system remains in safe state
    public void isSafe(){
       input(); //collecting data from the user
       calc_need(); //mathmagics here :DD
       boolean done[]=new boolean[np];
       int j=0;

       while(j<np){  //loop until all process allocated
       boolean allocated=false;
       
       
       
       for(int i=0;i<np;i++){
        if(!done[i] && check(i)){  //trying to allocate
            for(int k=0;k<nr;k++){
            avail[k]+=allocate[i][k];
            System.out.print(avail[k]);
            }
            
         System.out.println(" Allocated process : "+i);
         allocated=done[i]=true;
               j++;
             }
       }
       
       
       
       if(!allocated) break;  // if the above loop iterated over all 
                              // processes and there was no process then break 
       
       
       }
       
       
       if(j==np)  //if all processes are allocated
        System.out.println("\nSafely allocated!");
       else
        System.err.println("\nAll proceess can't be allocated safely!");
    }

    public static void main(String[] args) throws IOException {
        new Bankers().isSafe();
    }
}
