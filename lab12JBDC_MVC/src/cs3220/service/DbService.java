package cs3220.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import cs3220.model.Department;
import cs3220.model.Faculty;

public class DbService {

	private String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu62";

	private String username = "cs3220stu62";

	private String password = "SsRG4yKbd2Pz";

	private Connection connection;

	public DbService() {
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Department> getDepartments() {
		List<Department> departments = new ArrayList<Department>();
		List<Faculty> faculties = new ArrayList<Faculty>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from faculties");

			while (rs.next()) {
				Faculty faculty = new Faculty();
				faculty.setDepartment_name(rs.getString("department_name"));
				faculty.setName(rs.getString("name"));
				faculty.setChair(rs.getBoolean("isChair"));
				faculties.add(faculty);
			}

			rs = stmt.executeQuery("select * from departments");

			while (rs.next()) {
				Department department = new Department();
				department.setName(rs.getString("name"));
				departments.add(department);

			}
			for (int i = 0; i < departments.size(); i++) {
				for (int j = 0; j < faculties.size(); j++) {
					if (departments.get(i).getName().equals(faculties.get(j).getDepartment_name())) {
						departments.get(i).getFaculty().add(faculties.get(j));
					}
				}
			}

			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return departments;
	}

	public int addDepartment(String name) {
		int id = 0;
		try {
			String sql = "insert into departments (name) values (?)";
			PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, name);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next())
				id = rs.getInt(1);
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	public int addFaculty(String departmentName, String facultyName, boolean isChair) {
		int id = 0;
		try {
			String sql = "insert into faculties ( department_name, name, isChair) values (?, ?, ?)";
			PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, departmentName);
			pstmt.setString(2, facultyName);
			pstmt.setBoolean(3, isChair);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			
			List<Department> departments = (getDepartments());
			for (Department department : departments)
				if (department.getName().equals(departmentName))
					department.getFaculty().add(new Faculty(facultyName));
			
			if (rs.next())
				id = rs.getInt(1);
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
}