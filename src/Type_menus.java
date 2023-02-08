import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class Type_menus {
        public void show_applies(Connection conn, String str,int id)
        {
            Statement statement;
            String table_name = str;
            ResultSet rs = null;
            Set<String> uniqueData = new HashSet<>();
            try {
                String query = String.format("Select * from %s", table_name);
                statement = conn.createStatement();
                rs = statement.executeQuery(query);
                System.out.println("ID" + " | " + "APPLICATIONS");
                while (rs.next()) {
                    int id1 = rs.getInt("type_ID");
                    int ID = rs.getInt("apply_ID");
                    String name = rs.getString("apply_name");
                    String data = ID + "  | " + name;
                    // Only add to the set if it's not already present
                    if (!uniqueData.contains(data) && id1 == id) {
                        uniqueData.add(data);
                        System.out.println(data);
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

}


