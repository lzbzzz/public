package com.lzb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class userInfo implements Serializable {

    private static final long serialVersionUID = 6530442981789541334L;

    @Id
    @GeneratedValue
    private Integer id;
    private String userName;
    private String realName;
    private String password;
    private String type;
    private String email;
    private Integer phone;

    public userInfo(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "userInfo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", realName='" + realName + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
//注意：这个@Id一定不要导错包了！否则浪费了半天时间还找不到错误所在！
//需要导的包是import javax.persistence.Id;！！！！！
//这个类是用来自动生成数据库表的！
//前提条件是：
// 1，需要在pom文件里面添加2个jar包：spring-boot-starter-data-jpa和mysql-connector-java
// 2，要先新建一个数据库，空的即可。
// 3，需要在配置文件里面指定数据库信息（驱动，url，username，password）
//只要按照上面的方法执行就可以成功！
//重要的事情再说一遍：@Id需要导的包是import javax.persistence.Id;！！！！！