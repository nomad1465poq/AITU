import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class applies_menu {
    public void show_allergies_medicine(Connection conn,String str1, int id,int type_ID1) {
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
                int apply_id = rs.getInt("apply_ID");
                int price = rs.getInt("pill_price");
                String name = rs.getString("pill_name");
                String data = name + "  | " + price + "тг";
                // Only add to the set if it's not already present
                if (!uniqueData.contains(data) && apply_id == id && type_ID1==type_id) {
                    uniqueData.add(data);
                    System.out.println(data);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
