public class CommandLineArgDemo {
    public static void main(String[] args) {
        if(args.length<=0){
            System.out.println("No command line arg provided");
        }
        for (String arg : args) {
            System.out.println(arg);
        }

        int no = Integer.parseInt(args[3]);

        System.out.println("no is "+ no+" and no + 5 = "+(no+5));
    }
}
