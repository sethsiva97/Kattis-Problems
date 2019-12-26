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

public class RadioCommercials {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer s1 = new StringTokenizer(br.readLine());
        StringTokenizer s2 = new StringTokenizer(br.readLine());
        
        int numCommercials = Integer.parseInt(s1.nextToken());
        int price = Integer.parseInt(s1.nextToken());
        
        int[] segments = new int[numCommercials];
        
        for(int i = 0; i < numCommercials; i++){
            segments[i] = Integer.parseInt(s2.nextToken());
        }

        int max = 0;
        int prev = 0; //we need to store what the value of the previous segment was, in case we want to combine 
                        //with the current segment
        
        for(int i = 0; i < numCommercials; i++){
            int profit = segments[i] - price; //this is the profit we will gain from using the current segment
            max = Math.max(Math.max(max,profit),profit+prev); 
            prev = Math.max(profit+prev,profit); //if the previous sequence makes things worse, get rid of it
        }
        
        System.out.println(max);

    }

}
