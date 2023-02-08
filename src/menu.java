import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class menu {
    public void show_client_menu(Connection conn,String str)
    {
        Statement statement;
        String table_name = str;
        ResultSet rs = null;
        Set<String> uniqueData = new HashSet<>();
        try {
            String query = String.format("Select * from %s", table_name);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            System.out.println("ID"+" | "+"NAME");
            while (rs.next()) {
                int id = rs.getInt("type_ID");
                String name = rs.getString("type_name");
                String data = id + "  | " + name;

                // Only add to the set if it's not already present
                if (!uniqueData.contains(data) ) {
                    uniqueData.add(data);
                    System.out.println(data);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
