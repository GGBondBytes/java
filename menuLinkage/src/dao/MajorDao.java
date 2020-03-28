package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Major;
import jdbcUtils.JdbcUtils;

public class MajorDao {
	private static Connection connection;
	private static PreparedStatement prepareStatement;
	private static ResultSet resultSet;

	public static List<Major> findMajors(String sid) {
		List<Major> list = new ArrayList<Major>();
		Major newMajor = null;
		String sql = "SELECT mid,mname,sid FROM majordb WHERE sid=?";
		try {
			connection = JdbcUtils.getConnection();
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, sid);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				newMajor = new Major();
				newMajor.setMid(resultSet.getString("mid"));
				newMajor.setMname(resultSet.getString("mname"));
				newMajor.setSid(resultSet.getString("sid"));
				list.add(newMajor);
			}
			
	
			System.out.println(list);

			JdbcUtils.close(connection, prepareStatement, resultSet);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
