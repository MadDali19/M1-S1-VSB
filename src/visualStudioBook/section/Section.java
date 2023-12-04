package visualStudioBook.section;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import visualStudioBook.itf.IObjet;
import visualStudioBook.itf.ISection;

public class Section implements ISection {
	private final int idSection;
	private static int numberSection = 1;
	private String title;
	private String content;
	private final ArrayList<IObjet> givenObjects;
	
	public Section(String title, String content) {
		Objects.requireNonNull(title);
		Objects.requireNonNull(content);
		this.idSection = numberSection;
		this.title = title;
		this.content = content;
		this.givenObjects = new ArrayList<IObjet>();
		numberSection++;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getIdSection() {
		return idSection;
	}

	public List<IObjet> getGivenObjects() {
		return givenObjects;
	}
	
	@Override
	public int hashCode() {
		return idSection;
	}
	
	
}
