/*
List<Integer> list = Arrays.stream(intArray)
                                   .boxed()
                                   .collect(Collectors.toCollection(ArrayList::new));
*/

import java.util.Scanner;

public class ArmstrongNumber {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no: ");
        int no = sc.nextInt();
        System.out.println(isArmstrong(no)?"the no is an Armstrong no":"the no is not an Armstrong no");
        sc.close();
    }

    private static boolean isArmstrong(int no){
        if(no < 0 || no >999) return false;
        int temp = no;
        int sum=0;
        while(temp!=0){
            int digit = temp %10 ;
            sum+= (digit*digit*digit);
            temp /= 10;
        }
        return sum == no;
    }
    
}