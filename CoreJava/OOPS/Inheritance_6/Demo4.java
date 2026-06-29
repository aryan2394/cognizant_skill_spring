package CoreJava.OOPS.Inheritance_6;

public class Demo4 {
    public static void main()
    {
        EnginneringStudent e1=new EnginneringStudent();
        e1.attendanceMarked(); 
        e1.extraCurricularActivity();
        // matlab EngineeringStudent  is a clid class class of Student parent class


        Student s1 = new Student();
        s1.attendanceMarked();
        // s1.extraCurricularActivity(); gives error because uppar wale class ko neche se use 
        // nahi kar sakte or niche wale class ko uppar se use kar sakte he 
    }
}
class Student{
    void attendanceMarked()
    {
        System.out.print("mark attendance");
    }
}

class EnginneringStudent extends Student{
    void extraCurricularActivity()
    {
        System.out.print("Extra curricular activity");
    }
}
