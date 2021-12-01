package cs3220.model;

import java.util.ArrayList;
import java.util.List;

public class Course {

	static int idSeed = 1;
	int id;
	String courseTitle;
	List<Link> links;

	public Course(String courseTitle) {
		this.id = idSeed++;
		this.courseTitle = courseTitle;
		this.links = new ArrayList<Link>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

}
