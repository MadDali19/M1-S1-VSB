package visualStudioBook.section;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import visualStudioBook.itf.IObjet;
import visualStudioBook.itf.ISection;

public class Section implements ISection,  Serializable {
	private final int idSection;
	private static int numberSection = 1;
	private String title;
	private String content;
	private ArrayList<IObjet> givenObjects;
	
	public Section(String title, String content) {
		Objects.requireNonNull(title);
		Objects.requireNonNull(content);
		this.idSection = numberSection;
		this.title = title;
		this.content = content;
		this.givenObjects = new ArrayList<IObjet>();
		numberSection++;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String getContent() {
		return content;
	}

	@Override
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public void setgivenObjects(ArrayList<IObjet> Objects) {
		this.givenObjects = Objects;
	}
	
	@Override
	public int getIdSection() {
		return idSection;
	}
	
	@Override
	public List<IObjet> getGivenObjects() {
		return givenObjects;
	}
	
	
	
	
}
