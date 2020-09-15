package com.example;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

@Entity
@Table (name = "parents")
public class Parent implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column (name = "FIO")
    private  String fio;
    @Column
    private String street;
    @OneToMany(mappedBy = "parent",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Child> children = new HashSet<Child>();


    public Parent(){};
   public Parent(String fio,String street){
        this.fio = fio;
        this.street = street;
    }

    public Set<Child> getChildren() {
        return this.children;
    }
    public int getId() {
        return id;
    }



    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    public void addChild(Child child) {
        Scanner scanner = new Scanner(System.in);
        int schoolNumber = 0;
        child.setParent(this);
        System.out.println("Выберите школу  для " + child.getFIO() + ":");
     //   showSchools();
        try {
            schoolNumber = Integer.parseInt(scanner.nextLine());
        }catch (NumberFormatException ex){
            ex.printStackTrace();
        }
        child.setSchoolNumber(schoolNumber);
        children.add(child);
    }



    @Override
    public String toString() {
        return "com.example.Parent{" +
                "id=" + id +
                ", FIO='" + fio + '\'' +
                ", street=" + street +

                '}';
    }
}
