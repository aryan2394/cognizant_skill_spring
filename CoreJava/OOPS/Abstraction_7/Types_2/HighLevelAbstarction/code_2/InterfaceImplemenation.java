package CoreJava.OOPS.Abstraction_7.Types_2.HighLevelAbstarction.code_2;

public class InterfaceImplemenation {
    public static void main(String[] args)
    {
        Car c=new FuelCar();
        c.start();
        c.brake();
        c.accelearate();

        Car c2=new ElectricCar();
        c2.start();
        c2.brake();
        c2.accelearate();

        // fuel car started
        // fuel car brake
        // fuel car accelerate
        // electric car started
        // electric car brake
        // electric car accelerate
    }
}

interface Car{
    void start();
    void brake();
    void accelearate();
}
class FuelCar implements Car{
    public void start()
    {
        System.out.println("fuel car started");
    }
    public void brake()
    {
        System.out.println("fuel car brake");
    }
    public void accelearate()
    {
        System.out.println("fuel car accelerate");
    }
}
class ElectricCar implements Car{
    public void start()
    {
        System.out.println("electric car started");
    }
    public void brake()
    {
        System.out.println("electric car brake");
    }
    public void accelearate()
    {
        System.out.println("electric car accelerate");
    }
}