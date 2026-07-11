package in.shriji.priyaPritam.DTO;

import jakarta.validation.constraints.NotBlank;

public class UpdateStudentRequestDTO {
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Subject is required")
    private String subject;

    private Integer rollNo;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


}
