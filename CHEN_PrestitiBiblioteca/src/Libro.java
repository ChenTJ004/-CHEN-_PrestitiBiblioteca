import java.io.Serializable;

public class Libro implements Serializable{
	private String isbn;
	private String titolo;
	private String autore;
	
	public Libro() {}

	public Libro(String isbn, String titolo, String autore) {
		this.isbn = isbn;
		this.titolo = titolo;
		this.autore = autore;
	}
	public Libro(Libro l) {
		this.isbn = l.isbn;
		this.titolo = l.titolo;
		this.autore = l.autore;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String toString() {
		return "ISBN: " + isbn + "\t TITOLO:" + titolo + "\t AUTORE:" + autore;
	}

	
	
	
}