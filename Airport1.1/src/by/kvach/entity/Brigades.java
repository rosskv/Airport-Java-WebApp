package by.kvach.entity;

import java.util.List;

/**
 * Created by manager on 12.12.2016.
 */
public class Brigades {

    private int brigdeId;
    private String name;
    private int userId;

    public Brigades(int brigdeId, String name, int userId, List<Employees> brigadesEmployees) {
        this.brigdeId = brigdeId;
        this.name = name;
        this.userId = userId;
        this.brigadesEmployees = brigadesEmployees;
    }

    public List<Employees> getBrigadesEmployees() {
        return brigadesEmployees;
    }

    public void setBrigadesEmployees(List<Employees> brigadesEmployees) {
        this.brigadesEmployees = brigadesEmployees;
    }

    private List<Employees> brigadesEmployees;


    public Brigades() {
    }

    public int getBrigdeId() {
        return brigdeId;
    }

    public void setBrigdeId(int brigdeId) {
        this.brigdeId = brigdeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    @Override
    public String toString() {
        return "Brigades{" +
                "brigdeId=" + brigdeId +
                ", name='" + name + '\'' +
                ", userId=" + userId +
                ", brigadesEmployees=" + brigadesEmployees +
                '}';
    }
}
