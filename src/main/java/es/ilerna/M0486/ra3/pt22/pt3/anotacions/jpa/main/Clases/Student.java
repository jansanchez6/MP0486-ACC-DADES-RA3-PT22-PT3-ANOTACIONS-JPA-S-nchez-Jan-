package es.ilerna.M0486.ra3.pt22.pt3.anotacions.jpa.main.Clases;
import javax.persistence.Entity;

@Entity
public class Student extends Person {

    private String studentCode;

    public Student() {}

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }
}

