package uestc.homework2_1;

public class staff extends Person{
    private String school;
    private double pay;

    public staff(String name, String address, String school, double pay)
    {
        super(name, address);
        this.pay=pay;
        this.school=school;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public String toString() {
        return "Staff[" + "name='" + getName() + ' ' + ", address='" + getAddress() + ' ' + ", school='" + school + '\'' + ", pay=" + pay + ']';
    }
}
