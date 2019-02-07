package utils;
import java.sql.*;
import java.sql.SQLException;

/**
 * 
 * @author Ahmed Fayez
 * Created on 15/12/2018
 */
public class IDGenerator {
	/**
	 * This method auto generates primary keys for tables
	 * @param tableName
	 * @return primary key value
	 */
	public static Integer createPrimaryKey(String tableName) {
		
		Integer primaryKey = 1;
		StringBuilder str = new StringBuilder("select "+tableName);
		str.deleteCharAt(str.length()-1);
		str.append("_id FROM "+tableName);
		
		try (Connection con = DBUtils.getConnection();
				PreparedStatement pst = con.prepareStatement(str.toString());
				ResultSet rst = pst.executeQuery();)
		{
			
			while(rst.next())
			{
				primaryKey = rst.getInt(1)+1;
			}
			
			return primaryKey;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
        return null;
	}

}
