import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Biblioteca{
	private BufferedReader br;

	private Map<String, Libro> libri;

	private Map<String, Socio> soci;

	private List<Prestito> prestiti;

	public Biblioteca() {
		this.libri = new HashMap<>();
		this.soci = new TreeMap<>();
		this.prestiti = new ArrayList<>();
	}

	public void aggiungiLibro(Libro l) {
		this.libri.put(l.getIsbn(), l);
	}

	public void aggiungiSocio(Socio s) {
		this.soci.put(s.getCodiceFiscale(), s);
	}

	public Libro ricercaLibro(String isbn) {
		if (libri.containsKey(isbn))
			return libri.get(isbn);
		else
			return null;
	}

	public Socio ricercaSocio(String codFiscale) {
		if (soci.containsKey(codFiscale))
			return soci.get(codFiscale);
		else
			return null;
	}

	public Socio verificaPrestito(String isbn) {
		for (Prestito p : prestiti) {
			if (p.getIsbn().equalsIgnoreCase(isbn))
				return soci.get(p.getCodiceFiscale());
		}
		return null;
	}

	public void aggiungiPrestito(Prestito p) {
		if (verificaPrestito(p.getIsbn()) == null)
			prestiti.add(p);
	}

	public void restituzione(String isbn) {
		for (Prestito p : prestiti) {
			if (p.getIsbn().equalsIgnoreCase(isbn)) {
				prestiti.remove(p);
				break;
			}
		}
	}

	public void caricaLibri(String filename) {
		try {
			ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream(filename));
			libri = (HashMap<String, Libro>) ois1.readObject();
			ois1.close();
			System.out.println("Dati caricati con successo.");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Errore nella lettura da file");
		}
	}

	public void salvaFileLibri(String filename) {
		try {
			ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream(filename));
			oos1.writeObject(libri);
			oos1.close();
			System.out.println("File salvato con successo.");
		} catch (IOException e) {
			System.out.println("Errore nel salvataggio del file.");
		}
	}

	public void caricaSoci(String filename) {
		try {
			ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream(filename));
			soci = (TreeMap<String, Socio>) ois2.readObject();
			ois2.close();
			System.out.println("Dati caricati con successo.");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Errore nella lettura da file");
		}
	}

	public void salvaFileSoci(String filename) {
		try {
			ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream(filename));
			oos2.writeObject(soci);
			oos2.close();
			System.out.println("File salvato con successo.");
		} catch (IOException e) {
			System.out.println("Errore nel salvataggio del file.");
		}
	}

	public void caricaPrestiti(String filename) {
		try {
			ObjectInputStream ois3 = new ObjectInputStream(new FileInputStream(filename));
			prestiti = (ArrayList<Prestito>) ois3.readObject();
			ois3.close();
			System.out.println("Dati caricati con successo.");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Errore nella lettura da file");
		}
	}

	public void salvaFilePrestiti(String filename) {
		try {
			ObjectOutputStream oos3 = new ObjectOutputStream(new FileOutputStream(filename));
			oos3.writeObject(libri);
			oos3.close();
			System.out.println("File salvato con successo.");
		} catch (IOException e) {
			System.out.println("Errore nel salvataggio del file.");
		}
	}

	public Map<String, Libro> getLibri() {
		return libri;
	}

	public Map<String, Socio> getSoci() {
		return soci;
	}

	public List<Prestito> getPrestiti() {
		return prestiti;
	}

	
}
