import java.util.*;
import java.io.*;

public class iCanGuessTheDataStructure{

    public static void main (String[] args) throws IOException {

        BufferedReader file = new BufferedReader(new InputStreamReader(System.in));

        String line;

        while ((line=file.readLine())!=null) {

            int count = Integer.parseInt(line); //these n lines correspond to the current data structure

            Stack<Integer> stack = new Stack<>();
            boolean isStack = true;

            Queue<Integer> queue = new LinkedList<>();
            boolean isQueue = true;

            PriorityQueue<Integer> PQueue = new PriorityQueue<>(Collections.reverseOrder());
            boolean isPQueue = true;

            for (int i = 0; i < count; i++) { //go through all of the operations

                StringTokenizer st = new StringTokenizer(file.readLine());

                String operation = st.nextToken(); //this is the operation so the 1 or 2

                int val = Integer.parseInt(st.nextToken()); //this is the value being put in or taken out

                if (operation.equals("1")) {
                    if(isStack){
                        stack.push(val);
                    }
                    if(isQueue){
                        queue.offer(val);
                    }
                    if(isPQueue) {
                        PQueue.offer(val);
                    }
                }

                else if (operation.equals("2")) {
                    if((isStack && stack.size() == 0) || (isStack && stack.pop() != val)){
                        isStack = false;
                    }
                    if((isQueue && queue.size() == 0) || (isQueue && queue.poll() != val)){
                        isQueue = false;
                    }
                    if((isPQueue && PQueue.size() == 0) || (isPQueue && PQueue.poll() != val)){
                        isPQueue = false;
                    }
                }
            }

            if(!isPQueue && !isStack && !isQueue){
                System.out.println("impossible");
            }
            else if((isStack && isQueue) || (isStack && isPQueue) || (isQueue && isPQueue)){
                System.out.println("not sure");
            }
            else if(isStack){
                System.out.println("stack");
            }
            else if(isQueue){
                System.out.println("queue");
            }
            else {
                System.out.println("priority queue");
            }

        }
    }

}