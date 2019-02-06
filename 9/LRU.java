package pkg9;

import java.util.Scanner;

public class LRU {

    int no_frames, no_pages;
    int frames[] = new int[5];
    int[] age = new int[5];
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

    //fucntion to check if the value is in of the current frame values 
    boolean isInFrames(int value, int frames, int[] array) {

        for (int i = 0; i < frames; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    // function to find the oldest value in the frame the has not been used and return its index
    int findMax(int[] arr) {
        int idx = 0, maxValue = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
                idx = i;
            }
        }
        return idx;
    }

    void find_faults() {

        int faults = 0, n = 0;

        for (int i = 0; i < no_frames; i++) {
            frames[i] = -1;
            age[i] = 0;
        }

        while (n != no_pages) {

            for (int i = 0; i < no_frames; i++) { // getting older
                age[i]++;
            }

            int value = pages[n];

            if (!(isInFrames(value, no_frames, frames))) {

                faults++;
                int index = findMax(age);
                frames[index] = value;
                age[index] = 0;  // new age because it's a fresh new guest 
                print_frames();

            } else {
                for (int i = 0; i < no_frames; i++) {
                    if (frames[i] == value) {
                        age[i] = 0;
                        print_frames();
                    }
                }
            }

            n++;
        }

        System.out.println("No of faults " + faults);
    }

    void print_frames() {
        System.out.print("frame :");
        for (int j = 0; j < no_frames; j++) {
            System.out.print(frames[j] + " ");
        }
        System.out.println();
    }
}
