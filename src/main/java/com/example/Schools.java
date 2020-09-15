package com.example;

import com.example.District;

import javax.persistence.*;

@Entity
@Table (name = "schools")
public class Schools {
    @Id
    public int schoolNumber;
    @Column
    public String schoolAddress;
    @Column (name = "district_id")
    private int districtId;

    public Schools(){};
    public Schools(int schoolNumber, int districtId, String schoolAddress){
        this.schoolNumber = schoolNumber;
        this.schoolAddress = schoolAddress;
        this.districtId = districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setSchoolAddress(String schoolAddress) {
        this.schoolAddress = schoolAddress;
    }

    public String getSchoolAddress() {
        return schoolAddress;
    }

    public void setSchoolNumber(int schoolNumber) {
        this.schoolNumber = schoolNumber;
    }

    public int getSchoolNumber() {
        return schoolNumber;
    }

   @Override
    public String toString() {
        return "schoolNumber=" + schoolNumber +
                ", schoolAddress='" + schoolAddress + '\'' ;

    }
}
