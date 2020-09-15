package com.example;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "districts")
public class District {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column (name = "district_id")
    private int districtId;
    @Column
    private String districtName;
    @Column
    private String street;

    public District(int districtId,String districtName, String street){
        this.districtName = districtName;
        this.districtId = districtId;
        this.street = street;
    };

    public District(){};

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;

    }

    public int getDistrictId() {
        return districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }


    @Override
    public String toString() {
        return "District{" +
                "id=" + id +
                ", districtId=" + districtId +
                ", districtName='" + districtName + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
