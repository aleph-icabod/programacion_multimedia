package mx.anahuac.University;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person implements Serializable {
    private String name;
    private String email;
    private String genre;
    private Date birthDate;

    private SimpleDateFormat dateFormat;

    public Person(String name, String genre, Date birthDate) {
        this.name = name;
        this.genre = genre;
        this.birthDate = birthDate;
        this.dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        this.email = name + this.dateFormat.format(birthDate) + "@anahuac.mx";
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public String toString() {
        return this.name + "|" + this.email + "|" + this.genre + "|" + this.dateFormat.format(this.birthDate);
    }
}
