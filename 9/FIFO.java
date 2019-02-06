package pkg9;
import java.util.Scanner;

public class FIFO {

    int no_frames, no_pages;
    int frames[] = new int[5];
    int pages[] = new int[30];
    Scanner in = new Scanner(System.in);

    void read_data() {
        
            System.out.println("enter no. of frames: ");
            no_frames = in.nextInt();
            System.out.println("enter the no of pages ");
            no_pages = in.nextInt();
            System.out.println("enter the page nos ");
            for (int j = 0; j < no_pages; j++) {
                pages[j] = in.nextInt();
        }
    }

    void find_faults() {
        
        int i = 0, page, hit = 0, k = 0, fault = 0, j, l = 0;
        boolean notFound = true;
        
        
        for (i = 0; i < no_frames; i++) {
            frames[i] = -1;
        }
    
        do {
            for (i = 0; i < no_pages; i++) {
                
                page = pages[i];
                notFound = true;
                for (j = 0; j < no_frames; j++) {
                    if (page == frames[j]) {
                        hit++;
                        notFound = false;
                        break;
                    }
                }
                if (notFound) // if the page is not in the frames
                {

                    frames[k++] = page;  // here is the fifo concept in k variable
                    if (k == no_frames) { k = 0; }
                    
                    print_frames();
                    System.out.println();
                    fault++;
                    
                } else {
                    print_frames();
                    System.out.println();
                }
                l++;
            }
        } while (l != no_pages);
        
        
        System.out.println("Number of hits=" + hit);
        System.out.println("Number of faults=" + fault);
    }

    void print_frames() {
        System.out.print("frame :");
        for (int j = 0; j < no_frames; j++) {
            System.out.print(frames[j] + " ");
        }
    }
}
