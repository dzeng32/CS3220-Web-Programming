package cs3220.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cs3220.model.ListStoryEntry;

public class DbServiceListStory {

	private String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu62";

	private String username = "cs3220stu62";

	private String password = "SsRG4yKbd2Pz";

	private Connection connection;

	public DbServiceListStory() {
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

	public List<ListStoryEntry> getEntries() {
		List<ListStoryEntry> entries = new ArrayList<ListStoryEntry>();

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from stories");
			while (rs.next()) {
				ListStoryEntry entry = new ListStoryEntry();
				entry.setId(rs.getInt("id"));
				entry.setStoryTitle(rs.getString("story_title"));
				entry.setSubTitle(rs.getString("sub_title"));
				entry.setStoryContent(rs.getString("story_content"));
				entry.setSubmitDate(rs.getString("submit_date"));
				entry.setPublishDate(rs.getString("publish_date"));

				entries.add(entry);
				// id story_title sub_title story_content submit_date publish_date
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Collections.reverse(entries);
		return entries;
	}

//
	public ListStoryEntry getEntry(int id) {
		ListStoryEntry entry = new ListStoryEntry();
		try {
			String sql = "select * from stories where id = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				entry.setId(rs.getInt("id"));
				entry.setStoryTitle(rs.getString("story_title"));
				entry.setSubTitle(rs.getString("sub_title"));
				entry.setStoryContent(rs.getString("story_content"));
				entry.setSubmitDate(rs.getString("submit_date"));
				entry.setPublishDate(rs.getString("publish_date"));
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entry;
	}

//
	public void updateEntry(int id, String title, String subtitle, String content) {
		try {
			// id story_title sub_title story_content submit_date publish_date
			String sql = "update stories set story_title = ?, sub_title = ?, story_content = ? where id = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, subtitle);
			pstmt.setString(3, content);
			pstmt.setInt(4, id);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int submitStory(String title, String subtitle, String content) {
		int id = 0;
		try {
			
			LocalDate date = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/YYYY");
			
			// id story_title sub_title story_content submit_date publish_date

			String sql = "insert into stories (story_title, sub_title, story_content, submit_date) values (?, ?, ?, ?)";
			PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, title);
			pstmt.setString(2, subtitle);
			pstmt.setString(3, content);
			pstmt.setString(4, formatter.format(date).toString());
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
	
	public void publishStory(int id) {
		
		try {
			LocalDate date = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/YYYY");
			// id story_title sub_title story_content submit_date publish_date
			String sql = "update stories set publish_date = ? where id = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, formatter.format(date).toString());
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
