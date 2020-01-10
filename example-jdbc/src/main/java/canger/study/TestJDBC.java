package canger.study;

import java.io.IOException;
import java.sql.*;

public class TestJDBC {
    public static void main(String[] args) throws IOException, SQLException {
        Connection connection = MyUtil.getConnection();
        connection.setAutoCommit(false);


        String insert = "INSERT INTO employee(d_id,name,age,sex,homeaddr) values(?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insert,PreparedStatement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1,1001);
        preparedStatement.setString(2,"James");
        preparedStatement.setInt(3,31);
        preparedStatement.setString(4,"男");
        preparedStatement.setString(5,"America");

        preparedStatement.addBatch();

        preparedStatement.setInt(1,1001);
        preparedStatement.setString(2,"Harden");
        preparedStatement.setInt(3,31);
        preparedStatement.setString(4,"男");
        preparedStatement.setString(5,"America");

        preparedStatement.addBatch();

        int[] ints = preparedStatement.executeBatch();
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int i=0; i<columnCount; i++){
            String columnName = metaData.getColumnName(i + 1);
            System.out.println(columnName);
            int columnType = metaData.getColumnType(i + 1);
            String value=null;
            while (resultSet.next()){
                value = resultSet.getString(i + 1);
                System.out.println("columnName: "+columnName + " columnType:" + columnType + "  value:" + value);
            }
        }
        //connection.commit();
        connection.close();
    }
}
