package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.List;
import java.util.ArrayList;

public class CSVReader {
    private static final String CSV_JDBC_DRIVER = "org.relique.jdbc.csv.CsvDriver";
    private static final String CSV_JDBC_HEADER = "jdbc:relique:csv:";
    private static final String CSV_PROP_SEPARATOR = "separator";
    private static final String CSV_PROP_SUPHEADER = "suppressHeaders";
    private static final String CSV_PROP_FILEEXTEN = "fileExtension";
    private static final String CSV_PROP_CHARSET = "charset";

    public List<String[]> parse(String path, final String csvName) {
        List<String[]> list = new ArrayList<String[]>();
        try {
            // Set jdbc properties
            Class.forName(CSV_JDBC_DRIVER);
            // Create connection properties
            final Properties props = new java.util.Properties();
            // Split setting with comma
            props.put(CSV_PROP_SEPARATOR, ",");
            // Drop first line
            props.put(CSV_PROP_SUPHEADER, "false");
            // File type
            props.put(CSV_PROP_FILEEXTEN, ".csv");
            // Charset
            props.put(CSV_PROP_CHARSET, "UTF-8");


            final Connection conn = DriverManager.getConnection(CSV_JDBC_HEADER + path, props);
            final Statement stmt = conn.createStatement();

            // Get result set
            final ResultSet results = stmt.executeQuery("SELECT" + "*" + "FROM" + " " + csvName);

            // Load column name
            int ColLength = results.getMetaData().getColumnCount();
            String[] colName = new String[ColLength];
            for (int i = 0; i < ColLength; i++) {
                colName[i] = results.getMetaData().getColumnName(i + 1);
            }
            list.add(colName);

            // Load column data
            while (results.next()) {
                String[] row = new String[results.getMetaData().getColumnCount()];
                for (int i = 0; i < row.length; i++) {
                    row[i] = results.getString(i + 1);

                }
                list.add(row);
            }

            results.close();
            stmt.close();
            conn.close();
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
        } catch (final SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
