package com.springTest;

public class childJob extends Job{
    private String addField;

    public String getAddField() {
        return addField;
    }

    public void setAddField(String addField) {
        this.addField = addField;
    }

    @Override
    public String toString() {
        return "childJob{" +
                "addFields='" + addField + '\'' +
                "} " + super.toString();
    }
}
