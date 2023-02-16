package mx.anahuac;

import mx.anahuac.University.Person;
import mx.anahuac.University.Student;
import mx.anahuac.University.Subject;
import mx.anahuac.University.Teacher;

import javax.swing.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Teacher> teachers = readFile("teachers");
        List<Student> students = readFile("students");
        List<Subject> subjects = readFile("subjects");


        int option;
        do {
            option = mainMenu();
            switch (option) {
                case 1:
                    teachers.add(newTeacher());
                    break;
                case 2:
                    students.add(newStudent());
                    break;
                case 3:
                    subjects.add(newSubject());
                    break;
            }
        } while (option != 0);

        save(teachers, "teachers");
        save(students, "students");
        save(subjects, "subjects");
    }

    public static void save(List objects, String name) {
        saveTxtFile(objects, name);
        saveBinaryFile(objects, name);
    }

    public static <T> List<T> readFile(String name) {
        List<T> result = new ArrayList<T>();
        try {
            ObjectInputStream o = new ObjectInputStream(new FileInputStream(name));

            while (true) {
                Object item = o.readObject();
                if (item == null) {
                    break;
                }
                result.add((T) item);
            }
            o.close();
            return result;
        } catch (IOException e) {
            return result;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void saveTxtFile(List objects, String name) {
        try {
            FileWriter writer = new FileWriter(name + ".txt");
            for (int i = 0; i < objects.size(); i++) {
                writer.write(objects.get(i).toString() + "\n");
            }
            writer.flush();
        } catch (IOException e) {
            System.out.println("Could not write into file: " + e.getMessage());
        }
    }


    private static void saveBinaryFile(List objects, String name) {
        try {
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(name));
            for (int i = 0; i < objects.size(); i++) {
                o.writeObject(objects.get(i));
            }
            o.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static int mainMenu() {
        String selectedOption = JOptionPane.showInputDialog("Ingresa una opcion: " +
                "\n1) Agregar Maestro " +
                "\n2) Agregar Alumno" +
                "\n3) Agregar Materia " +
                "\n4) Agregar Grupo " +
                "\n0) Salir");

        try {
            int integerOption = Integer.parseInt(selectedOption);
            return integerOption;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static Teacher newTeacher() {
        Person p = newPerson();
        String cedula = JOptionPane.showInputDialog("Ingrese cedula");
        String speciality = JOptionPane.showInputDialog("Ingrese Especialidad");
        return new Teacher(p.getName(), p.getGenre(), p.getBirthDate(), cedula, speciality);
    }

    public static Student newStudent() {
        Person p = newPerson();
        String career = JOptionPane.showInputDialog("Ingrese Carrera");

        int s = 0;
        while (s == 0) {
            try {
                s = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Semestre"));
            } catch (NumberFormatException e) {
                s = 0;
            }
        }


        return new Student(p.getName(), p.getGenre(), p.getBirthDate(), s, career);
    }

    private static Person newPerson() {
        String name = JOptionPane.showInputDialog("Ingrese nombre");
        String genre = JOptionPane.showInputDialog("Ingrese genero");
        Date birthdate = null;
        while (birthdate == null) {
            birthdate = askDate("Ingrese Fecha de Nacimiento: dd-MM-YYYY");
        }
        return new Person(name, genre, birthdate);
    }

    private static Date askDate(String message) {
        String birthdate = JOptionPane.showInputDialog(message);
        try {
            Date d = new SimpleDateFormat("dd-MM-yyyy").parse(birthdate.trim());
            System.out.println(d.toString());
            System.out.println(birthdate);
            return d;
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Ingrese una fecha válida: dd-MM-yyyy");
            return null;
        }
    }

    public static Subject newSubject() {
        String code = JOptionPane.showInputDialog("Ingrese código");
        String name = JOptionPane.showInputDialog("Ingrese nombre de la materia");
        String career = JOptionPane.showInputDialog("Ingrese nombre de la carrera");
        int s = 0;
        while (s == 0) {
            try {
                s = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Semestre"));
            } catch (NumberFormatException e) {
                s = 0;
            }
        }


        Subject subject = new Subject(code, name, s, career);
        while (JOptionPane.showConfirmDialog(null, "¿Desea agregar otro tema?", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            String t = JOptionPane.showInputDialog("Ingrese tema");
            subject.addTopic(t);
        }

        return subject;
    }
}