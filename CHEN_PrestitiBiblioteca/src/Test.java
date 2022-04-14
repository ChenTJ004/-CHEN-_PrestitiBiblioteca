import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Test {
	public static void stampaMenu(String[] opts) {
		System.out.println("---MENU---");
		for (String opt : opts) {
			System.out.println(opt);
		}
		System.out.print("Scegli che cosa fare : ");
	}

	public static void main(String[] args) throws IOException {
		Biblioteca biblioteca = new Biblioteca();

		String[] opts = { "1- Ricerca libro per ISBN.", "2- Ricerca dati socio per codice fiscale.",
				"3- Verifica prestito di un libro.", "4- Memorizzazione di un nuovo prestito.",
				"5- Restituzione di un libro.", "6- Salvataggio dei dati su file.",
				"7- Recupero dei dati da file per i libri, soci e prestiti." };
		
		/* LIBRI MEMORIZZATI AL FILE libri.bin 
		biblioteca.aggiungiLibro(new Libro("978-1234302410", "Best cielo android apps", "Ugo Zamengo"));
		biblioteca.aggiungiLibro(
				new Libro("978-1234395844", "Best cielo tips you will read this year", "Rossana Carfagna"));
		biblioteca.aggiungiLibro(new Libro("978-1234489278", "Best 70 tips for cielo", "Severino Bova"));
		biblioteca.aggiungiLibro(new Libro("978-1234582712", "Should fixing cielo take 70 steps?", "Ottavio Cossiga"));
		biblioteca.aggiungiLibro(new Libro("978-1234676146", "The a - z of cielo", "Sig.ra Alessandra Dallara"));
		biblioteca.aggiungiLibro(
				new Libro("978-1234769580", "The next 70 things to immediately do about cielo", "Alessio Montesano"));
		biblioteca.aggiungiLibro(new Libro("978-1234863014", "The ultimate guide to cielo", "Cecilia Pepe-Bettin"));
		biblioteca.aggiungiLibro(new Libro("978-1234956448", "Top 70 funny cielo quotes", "Lidia Rastelli"));
		biblioteca.aggiungiLibro(new Libro("978-1235049882", "Top 70 quotes on cielo", "Enrico Fantini-Paoletti"));
		*/

		/* SOCI MEMORIZZATI NEL FILE soci.bin
		biblioteca.aggiungiSocio(new Socio("GND8800", "Giuseppe", "DeLuca", "giuse88@gmail.com"));
		biblioteca.aggiungiSocio(new Socio("MRHS999", "Mario", "Rossini", "mario99@gmail.com"));
		biblioteca.aggiungiSocio(new Socio("PPL7777", "Paolo", "Moretti", "paolo77@gmail.com"));
		 */
		
		/* PRESTITI MEMORIZZATI NEL FILE prestiti.bin 
		biblioteca.aggiungiPrestito(new Prestito("978-1234863014", "GND8800"));
		biblioteca.aggiungiPrestito(new Prestito("978-1235049882", "MRHS999"));
		biblioteca.aggiungiPrestito(new Prestito("978-1234489278", "PPL7777"));
		 */
		Input input = new Input();
		int risposta;
		String isbn;
		String codFiscale;

		String fileLibri;
		String fileSoci;
		String filePrestiti;
		int opt;
		//RECUPERARE PRIMA I DATI DIGITANDO IL COMANDO 7
		do {
			stampaMenu(opts);

			risposta = input.inputInt("");

			switch (risposta) {
			case 1:
				System.out.println("ISBN del libro: ");
				isbn = input.inputString("");
				if (biblioteca.ricercaLibro(isbn) == null) {
					System.out.println("Libro non presente.");
				} else
					System.out.println(biblioteca.ricercaLibro(isbn).toString());
				break;
			case 2:
				System.out.println("CODICE FISCALE del socio: ");
				codFiscale = input.inputString("");
				if (biblioteca.ricercaSocio(codFiscale) == null) {
					System.out.println("Utente non registrato.");
				} else
					System.out.println(biblioteca.ricercaSocio(codFiscale).toString());
				break;
			case 3:
				System.out.println("ISBN del libro: ");
				isbn = input.inputString("");
				if (biblioteca.verificaPrestito(isbn) == null) {
					System.out.println("Prestito non presente.");
				} else
					System.out.println(biblioteca.verificaPrestito(isbn).toString());
				break;
			case 4:
				System.out.println("ISBN del libro: ");
				isbn = input.inputString("");
				if (biblioteca.ricercaLibro(isbn) == null || biblioteca.verificaPrestito(isbn) != null)
					System.out.println("Libro gia` in prestito o non esistente.");
				else {
					System.out.println("CODICE FISCALE del socio: ");
					codFiscale = input.inputString("");
					if (biblioteca.ricercaSocio(codFiscale) != null) {
						biblioteca.aggiungiPrestito(new Prestito(isbn, codFiscale));
						System.out.println("Prestito effettuato.");
					}
					else
						System.out.println("Utente non registrato, impossibile effettuare il prestito.");
				}
				break;
			case 5:
				System.out.println("ISBN del libro: ");
				isbn = input.inputString("");
				if (biblioteca.verificaPrestito(isbn) == null) {
					System.out.println("Impossibile effettuare la restituzione.");
				} else {
					biblioteca.restituzione(isbn);
					System.out.println("Lista prestiti aggiornato.");
				}
				break;
			case 6:
				do {
					System.out.println("1. Salva libri, 2. Salva soci, 3. Salva prestiti, 4.Esci");
					opt = input.inputInt("");
					switch (opt) {
					case 1:
						System.out.println("Nome del file per il salvataggio dei libri: ");
						fileLibri = input.inputString("");
						biblioteca.salvaFileLibri(fileLibri);
						break;

					case 2:
						System.out.println("Nome del file per il salvataggio dei soci: ");
						fileSoci = input.inputString("");
						biblioteca.salvaFileSoci(fileSoci);
						break;
					case 3:
						System.out.println("Nome del file per il salvataggio dei prestiti: ");
						filePrestiti = input.inputString("");
						biblioteca.salvaFilePrestiti(filePrestiti);
						break;
					}
				} while (opt != 4);
				break;
			case 7:
				do {
					System.out.println("1. Recupero libri, 2. Recupero soci, 3. Recupero prestiti, 4.Esci");
					opt = input.inputInt("");
					switch (opt) {
					case 1:
						System.out.println("Nome del file per il recupero dei libri: ");
						fileLibri = input.inputString("");
						biblioteca.caricaLibri(fileLibri);
						break;

					case 2:
						System.out.println("Nome del file per il recupero dei soci: ");
						fileSoci = input.inputString("");
						biblioteca.caricaSoci(fileSoci);
						break;
					case 3:
						System.out.println("Nome del file per il recupero dei prestiti: ");
						filePrestiti = input.inputString("");
						biblioteca.caricaPrestiti(filePrestiti);
						break;
					}
				} while (opt != 4);
			}

		} while (risposta >= 1 || risposta <= 7);

	}
}
