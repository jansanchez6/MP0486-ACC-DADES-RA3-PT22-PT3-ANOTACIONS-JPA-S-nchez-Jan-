package es.ilerna.M0486.ra3.pt22.pt3.anotacions;
import javax.persistence.*;

@Entity
@DiscriminatorValue("TEACHER")
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
