import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class special_equipment {
    public void show_special_equipment(Connection conn, String str1) {
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
                int type_id= rs.getInt("type_ID");
                String type_name = rs.getString("type_name");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                String data = name + "  | " + price + "тг";
                // Only add to the set if it's not already present
                if (!uniqueData.contains(data) && "special equipment".equals(type_name)) {
                    uniqueData.add(data);
                    System.out.println(data);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
