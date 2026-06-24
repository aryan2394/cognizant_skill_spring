package CoreJava.OOPS.contructors.code;

public class ParameterContructor {
    public static void main(String[] args) {
        Student s1=new Student("Aryan",20,1);
        s1.print();
    }
}       

class Student {
    String name;
    int age;
    int roll;
    Student(String n,int a,int r)
    {
        name=n;
        age=a;
        roll=r;
    }

    void print() {
        System.out.println(name);
        System.out.println(age);
        System.out.println(roll);
    }
}
