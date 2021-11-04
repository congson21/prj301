/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.Date;
import java.util.ArrayList;
/**
 *
 * @author Asus
 */
public class Student {
    private int id;
    private String student_code;
    private String user_name;
    private String name;
    private Date dob;
    private boolean gender;
    private Classification classi;
    private ArrayList<Student_Room> rooms = new ArrayList<>();

    public ArrayList<Student_Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Student_Room> rooms) {
        this.rooms = rooms;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudent_code() {
        return student_code;
    }

    public void setStudent_code(String student_code) {
        this.student_code = student_code;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Classification getClassi() {
        return classi;
    }

    public void setClassi(Classification classi) {
        this.classi = classi;
    }

    

    



    

    
}
