
package CoreJava.OOPS.Encapsulation_5.code_4;
 
public class Demo1{
    public static void main(String[] args) {
        BankAccount b=new BankAccount();
        System.out.println(" balance is "+b.getBalance());
        b.withdraw(1000);
        System.out.println(" balance is "+b.getBalance()); 
    }
}  
class BankAccount
{
    private double balance=10000.0;
    public double getBalance()
    {
        return balance;
    }
    public void withdraw(double amount)
    {
        balance-=amount;
    }
    public void desposit(double amount)
    {
        balance+=amount;
    }
}
class Student
{
    private String name;
    private int age;
    private String college;
    Student(String name,int age,String college)
    {
        this.name=name;
        this.age=age;
        this.college=college;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        this.age=age;
    }
    public String getCollege()
    {
        return college;
    }
    public void setCollege(String college)
    {
        // hum direclty set kyon nahi kar de rahe hai jab humein set hi karna hai toh 
        // isliye kyonki aap sabse pahle toh buss aap byss ek baar hi object create ke time hi variable de sakte ho phir change nahi kar sakte hai 
        // dusra maanlo aap change nahi kiya hai lekin usne college ka naam kuch bhi daal diya toh wo direclty set ho jayega 
        // lekin age mein valiadtions laga denge (18-24) ya kai saare validation hum laga sakte hai agar hum use karnge setters ya getters
        this.college=college;
    }
}
