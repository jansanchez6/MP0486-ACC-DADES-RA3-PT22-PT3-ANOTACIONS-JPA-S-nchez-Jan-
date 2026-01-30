package es.ilerna.M0486.ra3.pt22.pt3.anotacions.jpa.main.Clases;
import javax.persistence.Entity;

@Entity
public class Teacher extends Person {

    private String teacherCode;

    public Teacher() {}

    public String getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(String teacherCode) {
        this.teacherCode = teacherCode;
    }
}
