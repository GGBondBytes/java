package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Major;
import bean.School;
import jdbcUtils.JdbcUtils;

public class SchoolDao {
	private static Connection connection;
	private static PreparedStatement prepareStatement;
	private static ResultSet resultSet;

	public static List<School> findSchools() {
		List<School> list = new ArrayList<School>();
		School newSchool = null;
		String sql = "SELECT * FROM schooldb";
		try {
			connection = JdbcUtils.getConnection();
			prepareStatement = connection.prepareStatement(sql);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				newSchool = new School();
				newSchool.setSid(resultSet.getString("sid"));
				newSchool.setSname(resultSet.getString("sname"));
				list.add(newSchool);
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
