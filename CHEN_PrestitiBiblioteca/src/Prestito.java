import java.io.Serializable;

public class Prestito implements Serializable{
	private String isbn;
	private String codiceFiscale;
	
	public Prestito(String isbn, String codiceFiscale) {
		this.isbn = isbn;
		this.codiceFiscale = codiceFiscale;
	}
	
	public Prestito(Prestito p) {
		this.isbn = p.isbn;
		this.codiceFiscale = p.codiceFiscale;
	}
	
	public Prestito() {}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	
	public String toString() {
		return "ISBN: " + isbn + "\t C.FISCALE:" + codiceFiscale;
	}
	
	
	
}
