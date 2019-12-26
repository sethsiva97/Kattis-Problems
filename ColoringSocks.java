import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.*;

public class ColoringSocks{

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer s1 = new StringTokenizer(br.readLine());
        StringTokenizer s2 = new StringTokenizer(br.readLine());

        int numSocks = Integer.parseInt(s1.nextToken()); //total number of socks
        int cap = Integer.parseInt(s1.nextToken()); //maximum capacity of a laundry machine
        int maxDiff = Integer.parseInt(s1.nextToken()); //maximum difference in colour two socks can have

        int[] socks = new int[numSocks]; //let's put all our socks in an array

        for(int i = 0; i < numSocks; i++){
            socks[i] = Integer.parseInt(s2.nextToken());
        }

        Arrays.sort(socks);

        int numMachines = 0; //total number of machines we will use 
        int j = 0;

        while(true){
            int numSocksInM = 0; //keeping track of the current number of socks in the laundry machine

            if(j >= numSocks){
                break;
            }

            int min = socks[j]; //this is the first sock we are putting in the machine, because the array is 
                                //sorted, we know this will be smallest colour in the machine
            while(j < cap && j < numSocks){ //make sure we can put the sock in the machine
                if(socks[j] - min > maxDiff){
                    break;
                }
                else{
                    j += 1;
                    numSocksInM += 1;
                }
            }

            numMachines += 1;
            cap += numSocksInM; //the capacity get's offset by the number of socks in the machine

        }

        System.out.println(numMachines);

    }

}
