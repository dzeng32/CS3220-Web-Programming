package cs3220.model;

public class ListStoryEntry {

	//static int idSeed = 1;
	private int id;
	private String storyTitle;
	private String subTitle;
	private String storyContent;
	private String submitDate;
	private String publishDate;

	public ListStoryEntry() {}
	
	public ListStoryEntry(String storyTitle, String subTitle, String storyContent) {
		//this.id = idSeed++;
		this.storyTitle = storyTitle;
		this.subTitle = subTitle;
		this.storyContent = storyContent;
	}
	
	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getStoryContent() {
		return storyContent;
	}

	public void setStoryContent(String storyContent) {
		this.storyContent = storyContent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStoryTitle() {
		return storyTitle;
	}

	public void setStoryTitle(String storyTitle) {
		this.storyTitle = storyTitle;
	}

}
