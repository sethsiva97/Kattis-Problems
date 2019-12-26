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

public class FlexibleSpaces{

    public static void main(String[] args) throws IOException{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer s1 = new StringTokenizer(br.readLine());
        StringTokenizer s2 = new StringTokenizer(br.readLine());

        int width = Integer.parseInt(s1.nextToken());
        int numPartitions = Integer.parseInt(s1.nextToken());

        int[] partitions = new int[numPartitions + 2]; //stores the locations of all the partitions as well as 
                                                        //the location of the first wall (which is 0), and the 
                                                        //location of the final wall (which is width)

        partitions[0] = 0; //storing the location of the first wall

        for(int i = 1; i < numPartitions + 1; i++){
            partitions[i] = Integer.parseInt(s2.nextToken());
        }

        partitions[partitions.length-1] = width; //storing the location of the final wall

        ArrayList<Integer> numWidths = new ArrayList<Integer>(); //this will hold the widths we can occupy
        
        for(int i = 1; i <= width; i++){ //check if we can occupy the widths from 1 to the width
            if(canFit(i,partitions)){
                numWidths.add(i);
            }
        }

        for(int i = 0; i < numWidths.size(); i++){
            System.out.println(numWidths.get(i));
        }

        
    }
    
    public static boolean canFit(int len, int[] partitions){

        int p1 = 0; //this is the first partition
        int p2 = 0; //this is the second partition

        while(p2 < partitions.length){
            if(partitions[p2] - partitions[p1] == len){ //if we can satisfy the length we are done
                return true;
            }
            if(partitions[p2] - partitions[p1] < len){ //if the distance between the first partition and the second
                p2 += 1;                                //is less than the desired length move the second partition
            }
            else{           //if the distance between the first partition and the second is greater than the 
                p1 += 1;    //desired length, move the first partition
            }
        }

        return false;

    }
    
}