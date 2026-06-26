package CoreJava.OOPS.contructors.code; 

public class DefaultContructor {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.print();
    }
}

class Student {
    String name;
    int age;
    int roll;

    void print() {
        System.out.println(name);
        System.out.println(age);
        System.out.println(roll);
    }
}