public class SuperKeywordDemo {
    public static void main(String[] args) {
        BaseVarient car = new BaseVarient("Beep beep");

        System.out.println(car.horn);

        FunkyVarient coolCar = new FunkyVarient();
        System.out.println(coolCar.horn);


    }
}

class BaseVarient{
    public BaseVarient() {
        horn="honk honk";
    }

    String horn;
    
    public BaseVarient(String horn) {
        this.horn = horn;
    }

}

class FunkyVarient extends BaseVarient{
    public FunkyVarient(String horn){
        super(horn);
    }
    public FunkyVarient(){
        
    }
}
