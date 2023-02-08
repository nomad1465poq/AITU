import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class form_data {
    public void show_capsules_eliksires(Connection conn,String str,int id1)
    {
        Statement statement;
        String table_name = "client_menu";
        ResultSet rs = null;
        Set<String> uniqueData = new HashSet<>();
        try {
            String query = String.format("Select * from %s", table_name);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            System.out.println("Name" + " | " + "Price");
            while (rs.next()) {
                String ch_or_ad= rs.getString("ch_or_ad");
                int apply_id = rs.getInt("form_ID");
                int price = rs.getInt("pill_price");
                String name = rs.getString("pill_name");
                String data = name + "  | " + price+"тг";
                // Only add to the set if it's not already present
                if (!uniqueData.contains(data) && apply_id==id1 && str.equals(ch_or_ad) ) {
                    uniqueData.add(data);
                    System.out.println(data);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
