package uestc.homework2_1;

public class Student extends Person{

    private String program;
    private int year;
    private double fee;

    public Student(String name, String address, String program, int year, double fee)
    {
        super(name, address);//调用父类构造方法，并把值传过去
        this.fee=fee;
        this.program=program;
        this.year=year;
    }

    public String getProgram() {
        return program;
    }

    public int getYear() {
        return year;
    }

    public double getFee() {
        return fee;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String toString() {
        return "Student[" + "name='" + getName() + ' ' + ", address='" + getAddress() + ' ' + ", program='" + program + '\'' + ", year=" + year + ", fee=" + fee + ']';
    }
}
