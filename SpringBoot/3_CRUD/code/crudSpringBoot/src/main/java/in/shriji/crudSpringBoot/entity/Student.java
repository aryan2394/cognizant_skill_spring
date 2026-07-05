package in.shriji.crudSpringBoot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    private Long id;

    private String name;
    private int age;
    private String email;
    private int rollNo;
    private String subject;
//    agar aap dekho ki ye Studnet class karna kya chahti hai toh basically jo values databse min store hogi ya retureive hogi unn saare varibles ko rakhi huwi hai
//    humein basically saare data ko convert karna padega in the studnets table taaki wo sql database mein save ho jaaye

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
