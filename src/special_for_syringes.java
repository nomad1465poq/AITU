import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class special_for_syringes {
    public void show_syringes(Connection conn, String str1,int ml) {
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
                String apply_name = rs.getString("apply_name");
                int qq= rs.getInt("ml_count");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                String data = name + "  | " + price + "тг";
                // Only add to the set if it's not already present
                if (!uniqueData.contains(data) && "for the nurse".equals(apply_name) && qq==ml) {
                    uniqueData.add(data);
                    System.out.println(data);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
