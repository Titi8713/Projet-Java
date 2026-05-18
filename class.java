import java.sql.*;
import javax.swing.JOptionPane;

public class Réponse {

    public static String[] question(ResultSet res, int nbquest) throws SQLException {

        String[] chapitres = new String[30];
        int[] scores = new int[30];
        int nbChapitres = 0;
        int[] questchap = new int[30];
        String[] aReviser = new String[30];
        int nbReviser = 0;

        while (res.next()) {

            String chapitre = res.getString("chapitre");

            String question = res.getString("question");

            int index = -1;

            for (int i = 0; i < nbChapitres; i++) {
                if (chapitres[i].equals(chapitre)) {
                    index = i;
                    break;
                }
            }

            if (index == -1) {
                chapitres[nbChapitres] = chapitre;
                scores[nbChapitres] = 0;
                questchap[nbChapitres] = 0;
                index = nbChapitres;
                nbChapitres++;
            }

            String reponse;

            // Validation de la saisie
            do {

                reponse = JOptionPane.showInputDialog(
                    null,
                    question + "\n\nEntrer A, B, C ou D :"
                );

                
                if (reponse == null) {
                    return new String[] { "QCM annulé" };
                }

                reponse = reponse.trim().toUpperCase();

                if (!reponse.matches("[ABCD]")) {

                    JOptionPane.showMessageDialog(
                        null,
                        "Veuillez entrer uniquement A, B, C ou D"
                    );
                }

            } while (!reponse.matches("[ABCD]"));

            String bonneReponse = res.getString("reponse");

            //Vérification de la réponse
            if (reponse.equals(bonneReponse)) {
            	
            	//Affichage mini fenêtre
                JOptionPane.showMessageDialog(
                    null,
                    "✔ Correct !"
                );

                scores[index]++;
                questchap[index]++;

            } else {

                JOptionPane.showMessageDialog(
                    null,
                    "❌ Faux ! Bonne réponse : " + bonneReponse
                );

                questchap[index]++;
            }
        }

        //Calcul score total
        int total = 0;

        String messageScores = "Scores par chapitre :\n\n";

        for (int i = 0; i < nbChapitres; i++) {

            messageScores += chapitres[i] + " : " + scores[i] + "/" + questchap[i] + "\n";

            total += scores[i];
        }

        messageScores += "\nScore total : " + total + "/" + nbquest;
        
        //Nouvelle mini fenêtre avec le score par chapitre et le total
        JOptionPane.showMessageDialog(null, messageScores);

        //Chapitres à réviser si score < à la moitié
        for (int i = 0; i < nbChapitres; i++) {

            if (2 * scores[i] < questchap[i]) {

                aReviser[nbReviser] = chapitres[i];
                nbReviser++;
            }
        }

        if (nbReviser == 0) {
            return new String[] { "Aucun chapitre à réviser" };
        }

        String[] resultat = new String[nbReviser];

        for (int i = 0; i < nbReviser; i++) {
            resultat[i] = aReviser[i];
        }

        return resultat;
    }
}

