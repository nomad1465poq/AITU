import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class ch_or_ad {
    public void show_forms(Connection conn,String str)
    {
        Statement statement;
        String table_name = "client_menu";
        ResultSet rs = null;
        Set<String> uniqueData = new HashSet<>();
        try {
            String query = String.format("Select * from %s", table_name);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            System.out.println("ID" + " | " + "Form");
            while (rs.next()) {
                String ch = rs.getString("ch_or_ad");
                int id = rs.getInt("form_ID");
                String name = rs.getString("form_name");
                String data = id + "  | " + name;
                // Only add to the set if it's not already present
                if (!uniqueData.contains(data) && str.equals(ch)) {
                    uniqueData.add(data);
                    System.out.println(data);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
