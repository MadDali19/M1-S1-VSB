package visualStudioBook.factory;

import java.util.Objects;

import visualStudioBook.itf.ISection;
import visualStudioBook.section.Section;

public class SectionFactory {
	public static ISection createNewSection(String title, String content) {
		Objects.requireNonNull(title);
		Objects.requireNonNull(content);
		return new Section(title, content);
	}
}
