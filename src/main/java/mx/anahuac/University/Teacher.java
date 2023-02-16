package mx.anahuac.University;

import java.io.Serializable;
import java.util.Date;

public class Teacher extends Person implements Serializable {
    private String cedula;
    private String speciality;

    public Teacher(String name, String genre, Date birthDate, String cedula, String speciality) {
        super(name, genre, birthDate);
        this.cedula = cedula;
        this.speciality = speciality;
    }

    public Teacher(String name, String genre, Date birthDate) {
        super(name, genre, birthDate);
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return super.toString() + "|" + this.cedula + "|" + this.speciality;
    }
}
