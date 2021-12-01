package cs3220.model;

public class Link {

	static int idSeed = 1;
	int id;
	String name;
	String zoomLink;

	public Link(String name, String zoomLink) {
		this.id = idSeed++;
		this.name = name;
		this.zoomLink = zoomLink;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZoomLink() {
		return zoomLink;
	}

	public void setZoomLink(String zoomLink) {
		this.zoomLink = zoomLink;
	}

}
