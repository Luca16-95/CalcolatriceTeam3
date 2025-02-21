import java.util.ArrayList;
import java.util.Scanner;

public class Calcolatrice {
    public static void main(String[] args) {

    }

    public static ArrayList<Object> somma(ArrayList<Integer> numeri) {
        ArrayList<Object> calcolo = new ArrayList<>();
        calcolo.add(numeri.get(0));
        calcolo.add(numeri.get(1));
        calcolo.add(numeri.get(0) + numeri.get(1));
        return calcolo;
    }

    public static ArrayList<Object> sottrazione(ArrayList<Integer> numeri) {
        ArrayList<Object> calcolo = new ArrayList<>();
        calcolo.add(numeri.get(0));
        calcolo.add(numeri.get(1));
        calcolo.add(numeri.get(0) - numeri.get(1));
        return calcolo;
    }

    public static ArrayList<Object> divisione(ArrayList<Integer> numeri) {
        ArrayList<Object> calcolo = new ArrayList<>();
        calcolo.add((Double) numeri.get(0).doubleValue());
        calcolo.add((Double) numeri.get(1).doubleValue());
        calcolo.add((Double) numeri.get(0).doubleValue() / (Double) numeri.get(1).doubleValue());
        return calcolo;
    }

    public static ArrayList<Object> moltiplicazione(ArrayList<Integer> numeri) {
        ArrayList<Object> calcolo = new ArrayList<>();
        calcolo.add(numeri.get(0));
        calcolo.add(numeri.get(1));
        calcolo.add(numeri.get(0) * numeri.get(1));
        return calcolo;
    }

    public static ArrayList<Integer> dammiDueNumeri() {
        Scanner myIntScanner = new Scanner(System.in);
        ArrayList<Integer> numeri = new ArrayList<>();

        System.out.println("Inserisci il primo numero: ");
        numeri.add(myIntScanner.nextInt());
        System.out.println("Inserisci il secondo numero: ");
        numeri.add(myIntScanner.nextInt());
        myIntScanner.close();

        return numeri;
    }

    public static void menuCalcolatrice(ArrayList<String> history) {

        Scanner myIntScanner = new Scanner(System.in);
        int sceltaUtente = 0;
        do {
            System.out.println("------- MENU CALCOLATRICE ---------");
            System.out.println("0 per addizione");
            System.out.println("1 per sottrazione");
            System.out.println("2 per moltiplicazione");
            System.out.println("3 per divisione");
            System.out.println("4 per tornare indietro");

            sceltaUtente = myIntScanner.nextInt();
            if (sceltaUtente < 0 || sceltaUtente > 4) {
                System.out.println("Input non valido, riprova");
            }

            switch (sceltaUtente) {
                case 0: // addizione
                    history.add(fromCalcToString("+", somma(dammiDueNumeri())));
                    break;
                case 1: // sottrazione
                    history.add(fromCalcToString("-", sottrazione(dammiDueNumeri())));

                    break;
                case 2: // moltiplicazione
                    history.add(fromCalcToString("*", moltiplicazione(dammiDueNumeri())));

                    break;
                case 3: // divisione
                    history.add(fromCalcToString("/", divisione(dammiDueNumeri())));

                    break;
                case 4: // torna indietro
                System.out.println("Stai tornando indietro");
                    break;
                default:
                    System.out.println("Opzione non valida");
                    break;
            }

        } while (sceltaUtente!= 4);

        myIntScanner.close();

    }

    public static String fromCalcToString(String operando, ArrayList<Object> calcolo) {
        String convertito = "";

        if (operando.equals("/")) {
            // caso specia occhio ai double
            convertito = ((Double) calcolo.get(0)).toString() + " " + operando + " "
                    + ((Double) calcolo.get(1)).toString() + " = " + ((Double) calcolo.get(2)).toString();
        } else {
            convertito = ((Integer) calcolo.get(0)).toString() + " " + operando + " "
                    + ((Integer) calcolo.get(1)).toString() + " = " + ((Integer) calcolo.get(2)).toString();

        }

        return convertito;

    }


    public static void printHistory(ArrayList<String> history){
        for(String calcolo : history){
            System.out.println(calcolo);
        }

    }
}