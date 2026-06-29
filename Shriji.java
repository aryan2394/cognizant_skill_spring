public class Shriji {
    public static void main(String[] args)
    {
        Student s=new Student();
        System.out.println(s.name);
        // Output is :Person
        // as abhi tak sirf name ka varibale sirf person mein hai toh ye print karega Person 
        // ab maanlo ki maine name naam ka vriable bana liya hai ab Student mein toh 
        // output kya aayega? 
        System.out.println(s.name);
        // Output is :Student

        // lekin maanlo ye toh problem ho gayi hai maanlo mujhe abhi bhi use karna hai Person 
        // wala name toh hum kaise karenge?

        // ab yaha pe aata hai super keyword:


    }
}
class Person{
    String name="Person";
}
class Student extends Person{
    String name="Student";
    
}

