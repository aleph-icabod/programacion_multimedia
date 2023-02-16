package mx.anahuac.University;

import java.io.Serializable;
import java.util.Date;

public class Student extends Person implements Serializable {
    private int semester;
    private String career;

    public Student(String name, String genre, Date birthDate) {
        super(name, genre, birthDate);
        this.career = "";
        this.semester = 1;
    }

    public Student(String name, String genre, Date birthDate, int semester, String career) {
        super(name, genre, birthDate);
        this.semester = semester;
        this.career = career;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    @Override
    public String toString() {
        return super.toString() + "|" + this.getSemester() + "|" + this.getCareer();
    }
}
