import java.util.ArrayList;
import java.util.Scanner;

public class Login {

    // Metodo per gestire il login
    public static void login(ArrayList<Integer> idUtenti, ArrayList<String> passwordUtenti) {
        // avvio lo scanner.
        Scanner input = new Scanner(System.in);
        // chiedo all' utente di inserire i dati.
        System.out.print("Inserisci l'ID: ");
        int idInserito = input.nextInt();
        input.nextLine();// pulisco lo scanner.
        System.out.print("Inserisci la password: ");
        String passwordInserita = input.nextLine();
        String passwordPulita = passwordInserita.toLowerCase().trim();

        // Verifica se l'ID e la password corrispondono a un utente
        boolean loginValido = false;
        // itero per id cercando quello che corrisponde con quello inserito dall'utente.
        for (int i = 0; i < idUtenti.size(); i++) {
            // valuta se i dati inseriti sono corretti all'indice corrispondente.
            if (idUtenti.get(i).equals(idInserito) && passwordUtenti.get(i).equals(passwordPulita)) {
                System.out.println("Login effettuato con successo!");
                loginValido = true;
                // invio alla funzione di calcolatrice
                menuCalcolatrice();
            }
        }

        // Se l'utente non è stato trovato o la password è errata
        if (!loginValido) {
            System.out.println("ID o password errati.");
        }
    }

}
