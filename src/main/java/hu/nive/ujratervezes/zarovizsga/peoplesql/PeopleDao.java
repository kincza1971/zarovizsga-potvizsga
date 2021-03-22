package hu.nive.ujratervezes.zarovizsga.peoplesql;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleDao {

    private final DataSource dataSource;

    public PeopleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String findIpByName(String firstName, String lastName) {
        try(Connection connection = dataSource.getConnection()) {
            return getIpFromDb(connection, firstName, lastName);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot connect to database: " + sqle.getMessage());
        }
    }

    private String getIpFromDb(Connection connection, String firstName, String lastName) {
        try (PreparedStatement ps = connection.prepareStatement("SELECT ip_address FROM people WHERE first_name = ? and last_name = ?")) {
            ps.setString(1,firstName);
            ps.setString(2,lastName);
            ResultSet rs = ps.executeQuery();
            return getIpFromResultSet(rs);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot execute query: " + sqle.getMessage());
        }
    }

    private String getIpFromResultSet(ResultSet rs) {
        try (rs) {
            rs.first();
            return rs.getString("ip_address");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Error in result set: " + sqle.getMessage());
        }
    }

}

//A PeopleDao osztályba dolgozz, mely egy DataSource-ot kap konstruktorban. A PeopleDaoTest hívja meg, ott van
// a DataSource deklarálva. Nyugodtan írd át a benne lévő értékeket.
//
//Legyen egy String findIpByName(String firstName, String lastName) metódusa, mely adatbázisból visszaadja az
// adott névhez tartozó ip címet! A teszteset a V1__people.sql állományt futtatja le Flyway-jel. Létrehoz egy people
// táblát, amiből a lényeges a first_name, last_name és az ip_address oszlop. Adatokat is beszúrja.
