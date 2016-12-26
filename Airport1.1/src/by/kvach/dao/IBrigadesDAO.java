package by.kvach.dao;

import by.kvach.entity.Brigades;

import java.util.List;

/**
 * Created by manager on 15.12.2016.
 */
public interface IBrigadesDAO {
    boolean  addBrigade( String name);
    List<Brigades> getBrigades();
    boolean removeBrigade (Integer id);
    Brigades getBrigadesById(int id_b);

}
