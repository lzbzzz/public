package com.lzb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class examinees {


    @Id

    @GeneratedValue
    private Integer id;
    private String eEid;//准考证号=考试编号+考场编号+座位号
    private String eName;//考生姓名
    private String eSid;//学号
    private String eTid;//考试编号
    private String eTnm;//考试名称
    private String eClass;//考场
    private String ePlace;//座位号
    private String eTime;//考试时间

    public examinees(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String geteEid() {
        return eEid;
    }

    public void seteEid(String eEid) {
        this.eEid = eEid;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String geteSid() {
        return eSid;
    }

    public void seteSid(String eSid) {
        this.eSid = eSid;
    }

    public String geteTid() {
        return eTid;
    }

    public void seteTid(String eTid) {
        this.eTid = eTid;
    }

    public String geteTnm() {
        return eTnm;
    }

    public void seteTnm(String eTnm) {
        this.eTnm = eTnm;
    }

    public String geteClass() {
        return eClass;
    }

    public void seteClass(String eClass) {
        this.eClass = eClass;
    }

    public String getePlace() {
        return ePlace;
    }

    public void setePlace(String ePlace) {
        this.ePlace = ePlace;
    }

    public String geteTime() {
        return eTime;
    }

    public void seteTime(String eTime) {
        this.eTime = eTime;
    }
    @Override
    public String toString() {
        return "examineesController{" +
                "id=" + id +
                ", eEid='" + eEid + '\'' +
                ", eName='" + eName + '\'' +
                ", eSid='" + eSid + '\'' +
                ", eTid='" + eTid + '\'' +
                ", eTnm='" + eTnm + '\'' +
                ", eClass='" + eClass + '\'' +
                ", ePlace='" + ePlace + '\'' +
                ", eTime='" + eTime + '\'' +
                '}';
    }

}
