import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int numGiocate = 0;
        String player = "x";

        // Costruisco un nuovo oggetto Tris
        Tris game = new Tris();
        Scanner in = new Scanner(System.in);

        // Procedo con il gioco
        while(true)
        {
            // Giocata del giocatore
            System.out.println(game.toString());
            System.out.print("inserisci riga per " + player);
            System.out.println(" (-1 per uscire): ");

            int riga = in.nextInt();

            if (riga < 0) return;

            System.out.print("Inserisci colonna per " +player);
            System.out.println(" : ");

            int colonna = in.nextInt();

            // Inserimento giocata
            game.set(riga,colonna,player);

            // Visualizzo lo stato del tris
            System.out.println(game.tostring());

            // Verifico se è presente un vincitore
            String verifica = game.getWinner();
            if(verifica.equalsIgnoreCase(" VINCE IL GIOCATORE X ") || verifica.equalsIgnoreCase(" VINCE IL GIOCATORE O "))
            {
                // Il gioco termina se un giocatore vince la partita
                System.out.println(verifica);
                return;
            }

            numGiocate++;
            if(numGiocate==9)
            {
                // Se il tris è pieno e non c'è vincitore, la partita termina
                System.out.println("NESSUN VINCITORE");
                return;
            }

            // Se ha giocato X allora dopo gioca O, altrimenti viceversa
            if(player=="x") player = "o";
            else player = "x";
        }
    }
}
