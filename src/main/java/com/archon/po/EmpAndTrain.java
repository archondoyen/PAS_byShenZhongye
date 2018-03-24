package com.archon.po;

public class EmpAndTrain {
    public static final Integer PREPARE_TRAIN = 0;
    public static final Integer TRAINING = 1;
    public static final Integer COMPLETE_TRAINED = 999;
    public static final Integer FAILED_TRAIN = -999;
    public static final Integer CANCEL_TRAIN = -1;/*取消培训*/

    private Integer id;
    private Integer empId;
    private Integer trainId;
    private Employee employee;
    private Train train;
    private Integer type;
    @Override
    public String toString() {
        return "EmpAndTrain{" +
                "id=" + id +
                ", empId=" + empId +
                ", trainId=" + trainId +
                ", employee=" + employee +
                ", train=" + train +
                '}';
    }

    public EmpAndTrain(){

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getTrainId() {
        return trainId;
    }

    public void setTrainId(Integer trainId) {
        this.trainId = trainId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }
}