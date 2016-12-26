package by.kvach.dao.implementation;

import by.kvach.dao.DatabaseConnection;
import by.kvach.dao.IProfessionsDAO;
import by.kvach.db.Fields;
import by.kvach.entity.Professions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by manager on 17.12.2016.
 */
public class ProfessionsDAO implements IProfessionsDAO {

    @Override
    public List<Professions> getProfessions() {
        List<Professions> professions = new ArrayList<>();
        String sql = "SELECT * FROM professions";
        try (Connection conn = DatabaseConnection.getConnection()) {
            try (Statement st = conn.createStatement()) {
                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        Professions p = extractProfessions(rs);
                        professions.add(p);
                    }
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return professions;
    }
    private Professions extractProfessions(ResultSet rs) throws SQLException {
        Professions p = new Professions();
        p.setProfessionId(rs.getInt(Fields.PROFESSIONS_PROFESSION_ID));
        p.setProfession(rs.getString(Fields.PROFESSIONS_PROFESSION));
        return p;
    }
}
