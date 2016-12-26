package by.kvach.entity;

/**
 * Created by manager on 12.12.2016.
 */
public class BrigadesEmployees {
    private int brigadeId;
    private int employeeId;

    public BrigadesEmployees() {
    }

    public BrigadesEmployees(int brigadeId, int employeeId) {
        this.brigadeId = brigadeId;
        this.employeeId = employeeId;
    }



    public int getBrigadeId() {
        return brigadeId;
    }

    public void setBrigadeId(int brigadeId) {
        this.brigadeId = brigadeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "BrigadesEmployees{" +
                "brigadeId=" + brigadeId +
                ", employeeId=" + employeeId +
                '}';
    }
}
