public class Demo{
    public static void main(String[] args){
        Student s1=new Student();
        s1.name="Shriji";
        s1.age=20;
        s1.roll=1;
        s1.markAttendance();
        s1.print();


        Student s2=new Student();
        s2.name="Aryan";
        s2.age=20;
        s2.roll=2;
        s2.markAttendance();
        s2.print();
    }
}
class Student{
    String name;
    int age;
    int roll;
    void print()
    {
        System.out.println(name);
        System.out.println(age);
        System.out.println(roll);
    }
    void markAttendance()
    {
        System.out.println(name + " has marked attendance");
    }
}