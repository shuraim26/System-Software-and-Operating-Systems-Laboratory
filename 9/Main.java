package pkg9;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int ch = 0;
        Scanner in = new Scanner(System.in);
        while(true){
                System.out.println("Menu...");
                System.out.println("1... FIFO");
                System.out.println("2... LRU");
                System.out.println("Enter your choice..:");
                ch = in.nextInt();
                switch (ch) {
                    case 1:
                        FIFO fifo = new FIFO();
                        fifo.read_data();
                        fifo.find_faults();
                        break;
                    case 2:
                        LRU lru = new LRU();
                        lru.read_data();
                        lru.find_faults();
                        break;
                }
        }
         
    }
}

/*

sample input 
FIFO
enter no. of frames: 
3
enter the no of pages 
20
enter the page nos 
7 0 1 2 0 3 0 4 2 3 0 3 2 1 2 0 1 7 0 1



LRU sample input
7 0 1 2 0 3 0 4 2 3 0 3 2 1 2 0 1 7 0 1



*/