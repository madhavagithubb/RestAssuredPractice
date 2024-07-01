package Pojoclasses;

import java.util.List;

public class AddNewPet {

	private double id ;
	
	private Pojoclasses.category category;
	
	private String name;
	
	private List<String> photoUrls;
	
	private Pojoclasses.tags tags;
	
	private String status;

	public double getId() {
		return id;
	}

	public void setId(double d) {
		this.id = d;
	}

	public Pojoclasses.category getCategory() {
		return category;
	}

	public void setCategory(Pojoclasses.category ct) {
		this.category = ct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getPhotoUrls() {
		return photoUrls;
	}

	public void setPhotoUrls(List<String> photoUrls) {
		this.photoUrls = photoUrls;
	}

	public Pojoclasses.tags getTags() {
		return tags;
	}

	public void setTags(Pojoclasses.tags tg) {
		this.tags = tg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
}
