import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class special_for_rehabilition {
    public void show_rehabiltion(Connection conn, String str1,int id) {
        Statement statement;
        String table_name = str1;
        ResultSet rs = null;
        Set<String> uniqueData = new HashSet<>();
        try {
            String query = String.format("Select * from %s", table_name);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            System.out.println("Name" + " | " + "Price");
            while (rs.next()) {
                int apply_id=rs.getInt("apply_ID");
                String type_name = rs.getString("type_name");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                String data = name + "  | " + price + "тг";
                // Only add to the set if it's not already present
                if (!uniqueData.contains(data) && "rehabilition".equals(type_name) && id==apply_id) {
                    uniqueData.add(data);
                    System.out.println(data);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
