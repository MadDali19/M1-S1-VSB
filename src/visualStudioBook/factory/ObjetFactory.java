package visualStudioBook.factory;

import java.util.Objects;

import visualStudioBook.itf.IObjet;
import visualStudioBook.objet.Objet;

public class ObjetFactory {
	public static IObjet createObjet(String name, String description) {
		Objects.requireNonNull(name);
		Objects.requireNonNull(description);
		return new Objet(name, description);
	}
}
