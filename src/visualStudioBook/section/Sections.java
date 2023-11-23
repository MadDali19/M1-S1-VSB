package visualStudioBook.section;

import java.util.Objects;

import visualStudioBook.itf.ISection;
import visualStudioBook.itf.ISections;

public class Sections implements ISections {
	public Sections() {
		
	}
	
	public ISection createSection(String title, String content) {
		Objects.requireNonNull(title);
		Objects.requireNonNull(content);
		return new Section(title, content);
	}
}
