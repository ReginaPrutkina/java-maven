package com.springTest;

public class UserSber {
    private String fio;

    private String age;

    private String address;

    Job job;

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "UserSber{" +
                "fio='" + fio + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                ", job=" + job +
                '}';
    }
}
