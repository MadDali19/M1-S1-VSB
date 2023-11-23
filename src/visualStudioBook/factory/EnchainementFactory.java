package visualStudioBook.factory;

import java.util.Objects;

import visualStudioBook.enchainement.Enchainement;
import visualStudioBook.itf.IEnchainement;
import visualStudioBook.itf.ISection;

public class EnchainementFactory {
	public static IEnchainement createEnchainement(ISection source, ISection destination) {
		Objects.requireNonNull(source);
		Objects.requireNonNull(destination);
		return new Enchainement(source, destination);
	}
}
