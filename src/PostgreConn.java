import javax.xml.transform.Result;
import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class PostgreConn {
        public Connection connect_to_db(String dbname, String user, String pass){
            Connection conn=null;
            try{
                Class.forName("org.postgresql.Driver");
                conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname,user,pass);
                if(conn!=null){
                    System.out.println("Connection Estabilished");
                }
                else{
                    System.out.println("Failed");
                }
            }catch(Exception e){
                System.out.println(e);
            }

            return conn;

    }

}
