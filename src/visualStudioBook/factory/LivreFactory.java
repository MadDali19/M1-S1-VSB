package visualStudioBook.factory;

import java.util.Objects;

import visualStudioBook.itf.ILivre;
import visualStudioBook.livre.Livre;

public class LivreFactory {
		public static ILivre createLivre(String title, String auteur, String description) {
				Objects.requireNonNull(title);
				Objects.requireNonNull(auteur);
		                Objects.requireNonNull(description);
				return new Livre(title,auteur, description);
			}
		
}
