import java.util.*;

public class TheEasiestProblemIsThisOne{

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n;
        n = scan.nextInt();

        while(n != 0){ //we know that were done processing the input as soon as we see a zero
            System.out.println(smallestNum(n));
            n = scan.nextInt();
        }

    }

    public static int smallestNum(int n){ //this method returns the smallest number that when multiplied by the current number has the
                                            //same sum for the digits
        int sumOfN = sumOfDigits(n);
        int i = 11;

        while(true){ //it basically checks every number starting from 11 until it finds the number that has the same sum of digits
            if(sumOfN == sumOfDigits(n*i)){
                return i;
            }
            i += 1;
        }

    }

    public static int sumOfDigits(int n){

        int sum = 0;

        while(n > 0){
            sum += n%10; //this will give the number in the ones column
            n = n/10; //we shift the number to the right by one, which gets rid of the number in the ones column
        }

        return sum;
    }


}
