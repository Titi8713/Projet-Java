import java.sql.*;
import javax.swing.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.*;
import java.io.File;


public class Main {

    public static void main(String[] args) throws URISyntaxException {

        String url = "jdbc:sqlite:projet.db";
        try {

            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            
            //Création BDD
            String sqlCreate =
                "CREATE TABLE IF NOT EXISTS questions (" +
                "id INTEGER PRIMARY KEY, " +
                "question TEXT UNIQUE, " +
                "reponse CHAR(1), " +
                "difficulte INT, " +
                "chapitre TEXT)";
            
            //Insertions des questions
            String sqlInsert =
            	    "INSERT OR IGNORE INTO questions(question,reponse,difficulte,chapitre) VALUES " +
            	    		// DÉNOMBREMENT
            	    		"('Combien de façons de choisir 2 élèves parmi 5 ? \nA: 10  B: 5  C: 20  D: 15', 'A', 0, 'Dénombrement'),"+

            	    		"('Combien d’anagrammes du mot ABCD ? A: 12  B: 24  C: 6  D: 48', 'B', 1, 'Dénombrement'),"+

            	    		"('Combien de codes à 3 chiffres avec répétition ? A: 900  B: 720  C: 1000  D: 100', 'C', 2, 'Dénombrement'),"+

            	    		"('Combien de façons de choisir 3 personnes parmi 10 avec ordre ? A: 120  B: 720  C: 60  D: 30', 'B', 3, 'Dénombrement'),"+

            	    		// VECTEURS
            	    		"('Qu''est-ce qu''un vecteur ? A: Une position  B: Une direction + norme  C: Une droite  D: Un point', 'B', 0, 'Vecteurs'),"+

            	    		"('Condition de colinéarité ? A: Produit nul  B: Vecteurs proportionnels  C: Orthogonaux  D: Égaux', 'B', 1, 'Vecteurs'),"+

            	    		"('Condition d''indépendance linéaire ? A: Tous égaux  B: Aucun vecteur combinaison des autres  C: Colinéaires  D: Orthogonaux', 'B', 2, 'Vecteurs'),"+

            	    		"('Comment définir un plan ? A: 1 vecteur  B: 1 point  C: 2 vecteurs non colinéaires  D: 3 vecteurs colinéaires', 'C', 3, 'Vecteurs'),"+

            	    		// PRODUIT SCALAIRE
            	    		"('Produit scalaire de deux vecteurs orthogonaux ? A: 1  B: 0  C: -1  D: infini', 'B', 0, 'Produit scalaire'),"+

            	    		"('Formule du produit scalaire ? A: u+v  B: ||u|| ||v|| cos(theta)  C: u×v  D: u-v', 'B', 1, 'Produit scalaire'),"+

            	    		"('Condition d''orthogonalité ? A: Produit scalaire = 0  B: Norme nulle  C: Somme nulle  D: Produit = 1', 'A', 2, 'Produit scalaire'),"+

            	    		"('Vecteur normal à un plan ? A: Somme  B: Différence  C: Produit vectoriel  D: Projection', 'C', 3, 'Produit scalaire'),"+

            	    		// DROITE
            	    		"('Forme paramétrique d''une droite ? A: ax+by+c=0  B: r = a + t u  C: y=ax²  D: x=y', 'B', 0, 'Droite'),"+

            	    		"('Que représente t ? A: Une constante  B: Paramètre réel  C: Une norme  D: Une direction', 'B', 1, 'Droite'),"+

            	    		"('Comment obtenir un point sur une droite ? A: Fixer t  B: Dériver  C: Intégrer  D: Multiplier', 'A', 2, 'Droite'),"+

            	    		"('Appartenance à une droite ? A: Dériver  B: Résoudre pour t  C: Multiplier  D: Additionner', 'B', 3, 'Droite'),"+

            	    		// PLAN
            	    		"('Forme générale d''un plan ? A: y=ax+b  B: ax+by+cz+d=0  C: x²+y²=1  D: r=a+tu', 'B', 0, 'Plan'),"+

            	    		"('Que représente (a,b,c) ? A: Un point  B: Un vecteur normal  C: Une direction  D: Une norme', 'B', 1, 'Plan'),"+

            	    		"('Comment déterminer un plan avec 3 points ? A: Dériver  B: Résoudre un système  C: Multiplier  D: Intégrer', 'B', 2, 'Plan'),"+

            	    		"('Condition d''appartenance à un plan ? A: Norme nulle  B: Vérifier l''équation  C: Multiplier  D: Dériver', 'B', 3, 'Plan'),"+

            	    		// SUITES
            	    		"('Limite de 1/n ? A: 1  B: 0  C: +∞  D: -1', 'B', 0, 'Suites'),"+

            	    		"('Théorème des gendarmes ? A: Produit  B: Encadrement ⇒ même limite  C: Somme  D: Division', 'B', 1, 'Suites'),"+

            	    		"('Limite d''une somme de suites ? A: Produit  B: Somme des limites  C: Différence  D: Max', 'B', 2, 'Suites'),"+

            	    		"('Exemple de suite divergente ? A: 1/n  B: n  C: 1/n²  D: constante', 'B', 3, 'Suites'),"+

            	    		// LIMITES
            	    		"('Limite d''une constante ? A: 0  B: Elle-même  C: +∞  D: -∞', 'B', 0, 'Limites'),"+

            	    		"('Asymptote verticale ? A: Limite nulle  B: Limite infinie  C: Produit nul  D: Somme nulle', 'B', 1, 'Limites'),"+

            	    		"('Limite d''un quotient ? A: Produit  B: Quotient des limites  C: Somme  D: Différence', 'B', 2, 'Limites'),"+

            	    		"('Asymptote oblique ? A: Dérivation  B: Division polynomiale  C: Intégrale  D: Limite nulle', 'B', 3, 'Limites'),"+

            	    		// DÉRIVATION
            	    		"('Définition de f∘g ? A: f+g  B: f(g(x))  C: f×g  D: f-g', 'B', 0, 'Dérivation'),"+

            	    		"('Dérivée de f(g(x)) ? A: f''(x)  B: f''(g(x))·g''(x)  C: g''(x)  D: f(x)', 'B', 1, 'Dérivation'),"+

            	    		"('Exemple de composition ? A: x²  B: sin(x²)  C: x+1  D: x', 'B', 2, 'Dérivation')," +
            	    		
            	    		"('Erreur fréquente ? A: Multiplier  B: Oublier la règle de chaîne  C: Diviser  D: Additionner', 'B', 3, 'Dérivation')";
            		
            
            stmt.execute("DROP TABLE IF EXISTS questions");
            
            stmt.execute(sqlCreate);
            stmt.execute(sqlInsert);
            
         

        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
        
        //Affichage premier QCM
        
        JFrame frame=new JFrame("Lecteur PDF");
    	frame.setSize(2000,1000);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setLayout(new GridLayout(23,0));
    	
    	JPanel panelRevisions = new JPanel();
    	panelRevisions.setLayout(new GridLayout(1,0));
    	
    	panelRevisions.add(new JLabel("Bonjour, bienvenue sur notre application MATHSPARK"));
    
    	
        JButton btnStart = new JButton("Lancer le QCM");
        btnStart.addActionListener(e -> {
    		try {
    			
    			//Résultats des autres QCM
    			
                Connection conn = DriverManager.getConnection("jdbc:sqlite:projet.db");
                Statement stmt = conn.createStatement();
                
                ResultSet count = stmt.executeQuery("SELECT COUNT(*) FROM questions where difficulte = 0");
                int nbquest = count.getInt(1);

                
                
                if (count.next()) {
                    System.out.println("Nombre de questions : " + nbquest);
                }
                count.close();
                
                
                
                //Resultats du premier QCM
                ResultSet rs1 = stmt.executeQuery("SELECT * FROM questions where difficulte = 0");
                
                String[] chapReviser2 = Réponse.question(rs1, nbquest); // console
               
                rs1.close();
                stmt.close();
                conn.close();
                
                
                panelRevisions.removeAll();
                
                //Affichage des autres QCM
                
                panelRevisions.add(new JLabel("Chapitres à réviser : "));
                for (String c : chapReviser2) {
                    if (c != null) {
                    	panelRevisions.add(
                    		new JLabel("\n" + c )
                    	);
                    }
                }
                
                
                panelRevisions.revalidate();
                panelRevisions.repaint();
                

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }); 
        
        JButton btnFinal = new JButton("Lancer le QCM final");
        btnFinal.addActionListener(e -> {
    		try {
    			
    			//Résultats du QCM final
    			
                Connection conn = DriverManager.getConnection("jdbc:sqlite:projet.db");
                Statement stmt = conn.createStatement();
                
                ResultSet count = stmt.executeQuery("SELECT COUNT(*) FROM questions where difficulte = 1");
                int nbquest = count.getInt(1);

                count.close();
                
                ResultSet rs2 = stmt.executeQuery("SELECT * FROM questions WHERE difficulte = 1");
                
                Réponse.question(rs2, nbquest);
                rs2.close();
                stmt.close();
                conn.close();
                
                panelRevisions.removeAll();
                panelRevisions.add(new JLabel("Merci d'avoir choisi notre application !!!"));
                
                panelRevisions.revalidate();
                panelRevisions.repaint();
    		}
    		catch (Exception ex) {
            ex.printStackTrace();
    		}
        });
                
        
        frame.add(panelRevisions);
        
        //Récupérations des cours par chapitres
        
        URI Dénombrement = new URI("https://www.maths-et-tiques.fr/telech/20Combi.pdf");
    	URI CalculIntegral = new URI("https://cours-de-sciences.fr/enseignement/terminale_generale/mathematiques_specialites/calcul_integral/calcul_integral_fiche_cours.pdf");
    	URI CalculVectoriel= new URI("http://www.nathaliehubert.com/meca/TERMINALES_SI/REV_TSI/documents/Cal_vect/cours.pdf");
    	URI ComposéeFonctions = new URI("https://www.maths-et-tiques.fr/telech/20CompTT.pdf");
    	URI Continuite = new URI("https://www.maths-et-tiques.fr/telech/20Cont.pdf");
    	URI Convexite = new URI("https://perso.math.univ-toulouse.fr/ktanguy/files/2022/08/Chapitre-11-Convexite%cc%81.pdf");
    	URI DeriveeSeconde = new URI("https://www.portois.fr/cours/cour_math/Cour_Deriver_Loic.pdf");
    	URI EquaDiff = new URI("https://www.maths91.fr/coursTermSPE_MATHS/TSp%C3%A9Maths-analyse-07-cours-equadiffs.pdf");
    	URI EquationCartesienne = new URI("https://www.maths-et-tiques.fr/telech/20Esp3.pdf");
    	URI FonctionsTrigo = new URI("https://www.maths-et-tiques.fr/telech/20TrigoT.pdf");
    	URI GrandsNombres = new URI("https://www.maths-et-tiques.fr/telech/20GrandN.pdf");
    	URI Integration = new URI("https://www.maths-et-tiques.fr/telech/Tintfct.pdf");
    	URI LimitesFonctions = new URI("https://www.maths-et-tiques.fr/telech/20LimFctC.pdf");
    	URI LimiteSuite = new URI("https://www.maths-et-tiques.fr/telech/SuitesTESL2.pdf");
    	URI Logarithmes = new URI("https://www.maths-et-tiques.fr/telech/LogTS.pdf");
    	URI LoiBinomiale = new URI("https://www.maths-et-tiques.fr/telech/Binomiale.pdf");
    	URI ProduitScalaire = new URI("https://www.maths-et-tiques.fr/telech/EspaceTS3.pdf");
    	URI RepresentationParametrique = new URI("https://www.maths-et-tiques.fr/telech/20Esp3.pdf");
    	URI SchemaBernouilli = new URI("https://lionelponton.fr/Terminale/Chapitre_8_Successions_d_epreuves.pdf");
    	URI VariablesAleatoires = new URI("https://www.maths-et-tiques.fr/telech/19vaPM.pdf");
    	
        
    	//Création des boutons des chapitres
    	
    	JButton btn2=new JButton("Ouvrir le cours sur le Dénombrement");
    	btn2.addActionListener(e -> ouvrirPDF(Dénombrement));  	
    	JButton btnCalculIntegral = new JButton("Ouvrir le cours sur le Calcul Intégral");
    	btnCalculIntegral.addActionListener(e -> ouvrirPDF(CalculIntegral));
    	JButton btnCalculVectoriel = new JButton("Ouvrir le cours sur le Calcul Vectoriel");
    	btnCalculVectoriel.addActionListener(e -> ouvrirPDF(CalculVectoriel));
    	JButton btnComposeeFonctions = new JButton("Ouvrir le cours sur les Fonctions Composées");
    	btnComposeeFonctions.addActionListener(e -> ouvrirPDF(ComposéeFonctions));
    	JButton btnContinuite = new JButton("Ouvrir le cours sur la Continuité");
    	btnContinuite.addActionListener(e -> ouvrirPDF(Continuite));
    	JButton btnConvexite = new JButton("Ouvrir le cours sur la Convexité");
    	btnConvexite.addActionListener(e -> ouvrirPDF(Convexite));
    	JButton btnDeriveeSeconde = new JButton("Ouvrir le cours sur la Dérivée Seconde");
    	btnDeriveeSeconde.addActionListener(e -> ouvrirPDF(DeriveeSeconde));
    	JButton btnEquaDiff = new JButton("Ouvrir le cours sur les Équations Différentielles");
    	btnEquaDiff.addActionListener(e -> ouvrirPDF(EquaDiff));
    	JButton btnEquationCartesienne = new JButton("Ouvrir le cours sur l'Équation Cartésienne");
    	btnEquationCartesienne.addActionListener(e -> ouvrirPDF(EquationCartesienne));
    	JButton btnFonctionsTrigo = new JButton("Ouvrir le cours sur les Fonctions Trigonométriques");
    	btnFonctionsTrigo.addActionListener(e -> ouvrirPDF(FonctionsTrigo));
    	JButton btnGrandsNombres = new JButton("Ouvrir le cours sur les Grands Nombres");
    	btnGrandsNombres.addActionListener(e -> ouvrirPDF(GrandsNombres));
    	JButton btnIntegration = new JButton("Ouvrir le cours sur l'Intégration");
    	btnIntegration.addActionListener(e -> ouvrirPDF(Integration));
    	JButton btnLimitesFonctions = new JButton("Ouvrir le cours sur les Limites de Fonctions");
    	btnLimitesFonctions.addActionListener(e -> ouvrirPDF(LimitesFonctions));
    	JButton btnLimiteSuite = new JButton("Ouvrir le cours sur les Limites de Suites");
    	btnLimiteSuite.addActionListener(e -> ouvrirPDF(LimiteSuite));
    	JButton btnLogarithmes = new JButton("Ouvrir le cours sur les Logarithmes");
    	btnLogarithmes.addActionListener(e -> ouvrirPDF(Logarithmes));
    	JButton btnLoiBinomiale = new JButton("Ouvrir le cours sur la Loi Binomiale");
    	btnLoiBinomiale.addActionListener(e -> ouvrirPDF(LoiBinomiale));
    	JButton btnProduitScalaire = new JButton("Ouvrir le cours sur le Produit Scalaire");
    	btnProduitScalaire.addActionListener(e -> ouvrirPDF(ProduitScalaire));
    	JButton btnRepresentationParam = new JButton("Ouvrir le cours sur la Représentation Paramétrique");
    	btnRepresentationParam.addActionListener(e -> ouvrirPDF(RepresentationParametrique));
    	JButton btnSchemaBernoulli = new JButton("Ouvrir le cours sur le Schéma de Bernoulli");
    	btnSchemaBernoulli.addActionListener(e -> ouvrirPDF(SchemaBernouilli));
    	JButton btnVariablesAleatoires = new JButton("Ouvrir le cours sur les Variables Aléatoires");
    	btnVariablesAleatoires.addActionListener(e -> ouvrirPDF(VariablesAleatoires));	
    	

    	//Affichage des boutons 
    	frame.add(btnStart);
    	frame.add(btnFinal);
    	 
    	frame.add(btn2);
    	frame.add(btnComposeeFonctions);
    	frame.add(btnCalculIntegral);
    	frame.add(btnCalculVectoriel);
    	frame.add(btnComposeeFonctions);
    	frame.add(btnContinuite);
    	frame.add(btnConvexite);
    	frame.add(btnDeriveeSeconde);
    	frame.add(btnEquaDiff);
    	frame.add(btnEquationCartesienne);
    	frame.add(btnFonctionsTrigo);
    	frame.add(btnGrandsNombres);
    	frame.add(btnIntegration);
    	frame.add(btnLimitesFonctions);
    	frame.add(btnLimiteSuite);
    	frame.add(btnLogarithmes);
    	frame.add(btnLoiBinomiale);
    	frame.add(btnProduitScalaire);
    	frame.add(btnRepresentationParam);
    	frame.add(btnSchemaBernoulli);
    	frame.add(btnVariablesAleatoires);
    	
    	frame.setVisible(true);
    	

    	
    }
    
    public static void ouvrirPDF(URI nomFichier) {
        try {
                Desktop.getDesktop().browse(nomFichier);
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}








