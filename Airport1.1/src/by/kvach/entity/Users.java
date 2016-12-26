
package by.kvach.entity;
/**
 * Created by manager on 12.12.2016.
 */
public class Users {
    private int userId;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private boolean roleId;

    public Users(){}

    public Users(int userId, String login, String firstName, boolean roleId, String lastName, String password) {
        this.userId = userId;
        this.login = login;
        this.firstName = firstName;
        this.roleId = roleId;
        this.lastName = lastName;
        this.password = password;
    }

    public int getUserId(){ return  userId;}

    public void setUserId(int userId) {  this.userId = userId;   }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean getRoleId() {
        return roleId;
    }

    public void setRoleId(boolean roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}
