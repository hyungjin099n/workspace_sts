package com.example.Test.vo;

public class EmpVO {
    private String empno;
    private String ename;
    private int sal;

    public String getEmpno() {
        return empno;
    }

    public void setEmpno(String empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "EmpVO{" +
                "empno='" + empno + '\'' +
                ", ename='" + ename + '\'' +
                ", sal=" + sal +
                '}';
    }
}
