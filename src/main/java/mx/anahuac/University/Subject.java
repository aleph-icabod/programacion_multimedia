package mx.anahuac.University;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Subject implements Serializable {
    private String code;
    private String name;
    private int semester;
    private String career;

    private List<String> topics;

    public Subject(String code, String name, int semester, String career) {
        this.code = code;
        this.name = name;
        this.semester = semester;
        this.career = career;
        this.topics = new ArrayList<>();
    }

    public Subject(String code, String name, int semester, String career, List<String> topics) {
        this.code = code;
        this.name = name;
        this.semester = semester;
        this.career = career;
        this.topics = topics;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }


    public void addTopic(String t) {
        if (this.topics == null) {
            this.topics = new ArrayList<>();
        }
        this.topics.add(t);
    }

    @Override
    public String toString() {
        String s = this.code + "|" + this.name + "|" + this.career + "|" + this.semester;

        for (String t : this.topics) {
            s += "|" + t;
        }
        return s;
    }
}
