package visualStudioBook.bookSerializer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Objects;

import visualStudioBook.livre.Livre;

public class BookSerializer {

	String filepath;

	BookSerializer(String filepath) {
		Objects.requireNonNull(filepath);
		this.filepath = filepath;
	}

	public void saveBook(Livre livre) throws IOException {
		Objects.requireNonNull(livre);
		FileOutputStream os = new FileOutputStream(this.filepath);
		ObjectOutputStream oos = new ObjectOutputStream(os);
		oos.writeObject(livre);
		oos.close();
		os.close();
	}

	public Livre importBook() throws IOException {
		FileInputStream is = new FileInputStream(this.filepath);
		ObjectInputStream ois = new ObjectInputStream(is);
		Livre l = (Livre)ois.readObject();
		is.close();
		ois.close();
		return l;
	}
}
