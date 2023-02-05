package com.kodilla.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StoredProcTestSuite {

    @Test
    public void testUpdateVipLevels() throws SQLException {
        // Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE READERS SET VIP_LEVEL=\"Not set\"";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);
        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM READERS WHERE VIP_LEVEL=\"Not set\"";


        // When
        String sqlProcedureCall = "CALL UpdateVipLevels()";
        statement.execute(sqlProcedureCall);

        ResultSet rs = statement.executeQuery(sqlCheckTable);


        // Then
        int howMany = -1;
        if (rs.next()) {
            howMany = rs.getInt("HOW_MANY");
        }

        assertEquals(0, howMany);
        rs.close();
        statement.close();
    }


    @Test
    public void testUpdateBestsellers() throws SQLException {
        // Given
        Integer bookId = -1;
        Integer rentId1 = -1;
        Integer rentId2 = -1;
        int howMany = -1;
        ResultSet resultSet;
        DbManager dbManager = DbManager.getInstance();
        Statement statement = dbManager.getConnection().createStatement();
        String sqlUpdate = "UPDATE BOOKS SET BESTSELLER=false";
        String sqlInsertBook = "INSERT INTO BOOKS (BOOK_ID, TITLE, PUBYEAR, BESTSELLER)\n" +
                "VALUES (null, 'test', 200, 0);";

        bookId = executeInsert(statement, sqlInsertBook);

        String sqlInsertRent1 = String.format("INSERT INTO RENTS (BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)\n" +
                "VALUES (%s, 5, NOW(), null);", bookId);
        String sqlInsertRent2 = String.format("INSERT INTO RENTS (BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)\n" +
                "VALUES (%s, 4, NOW(), null);", bookId);

        rentId1 = executeInsert(statement, sqlInsertRent1);
        rentId2 = executeInsert(statement, sqlInsertRent2);

        statement.executeUpdate(sqlUpdate);
        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM BOOKS WHERE BESTSELLER=true";

        // When
        String sqlProcedureCall = "CALL UpdateBestsellers()";
        statement.execute(sqlProcedureCall);

        resultSet = statement.executeQuery(sqlCheckTable);

        // Then
        resultSet.next();
        howMany = resultSet.getInt("HOW_MANY");

        assertTrue(howMany > 0);
        resultSet.close();

        //CLEAN UP
        statement.execute(String.format("DELETE FROM RENTS WHERE RENT_ID = %s", rentId1));
        statement.execute(String.format("DELETE FROM RENTS WHERE RENT_ID = %s", rentId2));
        statement.execute(String.format("DELETE FROM BOOKS WHERE BOOK_ID = %s", bookId));
        statement.close();
    }

    private Integer executeInsert(Statement statement, String sqlInsert) throws SQLException {
        String sqlIdentity = "SELECT @@IDENTITY";
        Integer id;
        ResultSet resultSet;
        statement.execute(sqlInsert);
        resultSet = statement.executeQuery(sqlIdentity);
        resultSet.next();
        id = resultSet.getInt(1);
        resultSet.close();
        return id;
    }
}
