public class ArgCalc {
    public static void main(String[] args) {
        int op1 = Integer.parseInt(args[0]);
        int op2 = Integer.parseInt(args[2]);
        switch (args[1]) {
            case "+":
                System.out.println(op1 + op2);
                break;
            case "-":
                System.out.println(op1 - op2);
                break;
            case "*":
                System.out.println(op1 * op2);
                break;
            case "/":
                System.out.println(op1 / op2);
                break;
            default:
                System.out.println("Invalid argument");
                break;
        }

    }

}
