package by.kvach.dao.implementation;

import by.kvach.dao.DatabaseConnection;
import by.kvach.dao.IEmployeesDAO;
import by.kvach.db.Fields;
import by.kvach.entity.Employees;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by manager on 16.12.2016.
 */
public class EmployeesDAO implements IEmployeesDAO {
    private final String INSERT_NEW_EMPLOYEES = "insert into employees(profession_id, first_name , last_name) values(?, ?, ?)";

    @Override
    public boolean addEmployees(String professionId, String firstName, String lastName)
    {
        Connection connection = null;
        PreparedStatement ps = null;

        try{
            connection = DatabaseConnection.getConnection();
            ps = connection.prepareStatement(INSERT_NEW_EMPLOYEES);
            ps.setString(1, professionId);
            ps.setString(2,  firstName);
            ps.setString(3, lastName);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if (ps != null)
                    ps.close();
                if(connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<Employees> getEmployees() {
        List<Employees> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        try (Connection conn = DatabaseConnection.getConnection()) {
            try (Statement st = conn.createStatement()) {
                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        Employees e = extractEmployees(rs);
                        employees.add(e);
                    }
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return employees;
    }


    @Override
    public List<Employees> viewEmployeesBrigade(Integer id) {
        List<Employees> employees = new ArrayList<>();
        String sql = "SELECT *\n" +
                "FROM\n" +
                "  airport.brigades_employees\n" +
                "  INNER JOIN\n" +
                "  brigades\n" +
                "    ON brigades_employees.brigade_id = brigades.brigade_id\n" +
                "      INNER JOIN\n" +
                "  employees\n" +
                "    ON brigades_employees.employee_id = employees.id " +
                "where airport.brigades_employees.brigade_id=?;";

    try {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement st = conn.prepareStatement(sql);
        st.setInt(1, id);
        //int count= st.executeUpdate();
        ResultSet rs = st.executeQuery();
                    while (rs.next()) {
                        Employees e = extractEmployees(rs);
                        employees.add(e);
                             }
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public boolean removeEmployees(Integer id) {
        String sql = "delete from employees where id=?;";
        boolean isRemoved = false;
        try (Connection conn = DatabaseConnection.getConnection()) {
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                st.setInt(1, id);
                int count = st.executeUpdate();
                if (count == 1) {
                    isRemoved = true;
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return isRemoved;
    }

    @Override
    public void addEmployeesIntoBrigade(Integer idBrigade, Integer idEmployee){
        String sql = "INSERT INTO brigades_employees VALUES(?,?);";
        try (Connection conn = DatabaseConnection.getConnection()) {
            try (PreparedStatement st = conn.prepareStatement(sql)) {

                st.setInt(1, idBrigade);
                st.setInt(2, idEmployee);
                st.executeUpdate();

            }
        }
     catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    }

    @Override
    public boolean removeEmployeesIntoBrigade(Integer idEmployee){
        String sql = "DELETE FROM brigades_employees WHERE employee_id=?;";
        boolean isRemoved = false;
        try (Connection conn = DatabaseConnection.getConnection()) {
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                st.setInt(1, idEmployee);
                int count = st.executeUpdate();
                if (count == 1) {
                    isRemoved = true;
                }
            }
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return isRemoved;
    }

    private Employees extractEmployees(ResultSet rs) throws SQLException {
        Employees e = new Employees();
        e.setEmployeesId(rs.getInt(Fields.EMPLOYEES_ID));
        e.setFirstname(rs.getString(Fields.EMPLOYEES_FIRST_NAME));
        e.setLastname(rs.getString(Fields.EMPLOYEES_LAST_NAME));
        e.setProfessionId(rs.getInt(Fields.EMPLOYEES_PROFESSION_ID));
        return e;
    }



}
