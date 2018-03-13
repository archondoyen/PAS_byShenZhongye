package com.archon.po;

import java.sql.Timestamp;

public class Employee {
    private Integer id;
    private String eName;
    private String sex;
    private int age;
    private Company company;
    private Department department;
    private Employee Straightleader;
    private  Job job;
    private Double salay;
    private Double comm;/*奖金*/
    private Timestamp probationBeginTime;/*试用期时间*/
    private Timestamp hiredate;/*入职时间*/
    private Timestamp modifiedTime;
    private Integer state;/*在职信息*/


}