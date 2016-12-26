package by.kvach.dao;

import by.kvach.entity.Employees;

import java.util.List;

/**
 * Created by manager on 16.12.2016.
 */
public interface IEmployeesDAO {
    List<Employees> getEmployees();
    List<Employees> viewEmployeesBrigade(Integer id);
    boolean  addEmployees(String professionId, String firstName, String lastName);
    boolean removeEmployees (Integer id);
    void addEmployeesIntoBrigade(Integer idBrigade, Integer idEmployee);
    boolean removeEmployeesIntoBrigade(Integer idEmployee);


}
