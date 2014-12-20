/**
 * 
 */
package com.learning.sqlite_from_assets.models;

/**
 * @author Boopathy Balakrishnan
 * 
 * @version 1.0
 */
public class StudentsInformationModel {
    private String name;
    private String dept;

    public StudentsInformationModel(String name, String dept) {
        super();
        this.name = name;
        this.dept = dept;
    }
    /**
     * 
     */
    public StudentsInformationModel() {
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

}
