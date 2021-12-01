package cs3220.model;

public class Faculty {

	private String department_name;
    private String name;

    private boolean isChair;

    public Faculty()
    {
        isChair = false;
    }

    public Faculty( String name )
    {
        this();
        this.name = name;
    }

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public boolean isChair()
    {
        return isChair;
    }

    public void setChair( boolean isChair )
    {
        this.isChair = isChair;
    }

}
