package CoreJava.OOPS.Abstraction_7.Types_2.HighLevelAbstarction.code_2;

public class AbstractClassImplentaion {
    public static void main()
    {
        Car c=new FuelCar();
        c.accelearate();
        c.brake();
        c.start();

        Car c2=new ElrctricCar();
        c2.accelearate();
        c2.brake();
        c2.start();

        // fuel car accelerate
        // fuel car brake
        // car started
        // electric car accelerate
        // electric car brake
        // car started 
    }
}
abstract class Car{
    public void start()
    {
        System.out.println("car started");
    }
    abstract void brake();
    abstract void accelearate();

}
class FuelCar extends Car{
    // if we will not define it will give compile time error

    // best practices is that jum hum parent class ko yaha pe define karein the write @Override 
    // taaki pata chale ki ye function humra nahi hai balki abstarct class ka implentation hai 

    @Override
    void brake()
    {
        System.out.println("fuel car brake");
    }
    @Override
    void accelearate()
    {
        System.out.println("fuel car accelerate");
    }
}
class ElrctricCar extends Car{
    @Override
    void brake()
    {
        System.out.println("electric car brake");
    }
    @Override
    void accelearate()
    {
        System.out.println("electric car accelerate");
    }
}