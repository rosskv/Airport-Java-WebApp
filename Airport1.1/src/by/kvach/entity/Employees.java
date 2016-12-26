package by.kvach.entity;

/**
 * Created by manager on 12.12.2016.
 */
public class Employees {
    private int employeesId;
    private int professionId;
    private String firstname;
    private String lastname;

    public Employees() {
    }

    public Employees(String lastname, int employeesId, int professionId, String firstname) {
        this.lastname = lastname;
        this.employeesId = employeesId;
        this.professionId = professionId;
        this.firstname = firstname;
    }

    public int getEmployeesId() {
        return employeesId;
    }

    public void setEmployeesId(int employeesId) {
        this.employeesId = employeesId;
    }

    public int getProfessionId() {
        return professionId;
    }

    public void setProfessionId(int professionId) {
        this.professionId = professionId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "employeesId=" + employeesId +
                ", professionId=" + professionId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

}
