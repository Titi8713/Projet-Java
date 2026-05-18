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
            	    		
            	    		// PROBABILITÉS
            	    		"('Combien de façons de choisir 3 élèves parmi 6 ? A: 10 B: 15 C: 20 D: 18', 'C', 0, 'Probabilités')," +
            	    		"('Dans un schéma de Bernoulli, que représente p ? A: probabilité de succès B: nombre d’essais C: issue D: moyenne', 'A', 1, 'Probabilités')," +
            	    		"('Dans une loi binomiale, que calcule-t-on ? A: variance B: nombre de succès C: somme D: limite', 'B', 2, 'Probabilités')," +
            	    		"('Une variable aléatoire est : A: matrice B: fonction C: événement D: nombre réel aléatoire', 'D', 3, 'Probabilités')," +
            	    		"('Que dit la loi des grands nombres ? A: divergence B: stabilité parfaite C: convergence D: oscillation', 'C', 3, 'Probabilités')," +
            	    		"('Nombre de suites possibles de 3 lancers de pièce : A: 6 B: 8 C: 4 D: 9', 'B', 0, 'Probabilités')," +

            	    		// VECTEURS & PRODUIT SCALAIRE
            	    		"('Un vecteur représente : A: un point B: une direction et une norme C: une droite D: un nombre', 'B', 0, 'Vecteurs & Produit scalaire')," +
            	    		"('Produit scalaire de vecteurs orthogonaux : A: -1 B: 1 C: 0 D: dépend', 'C', 1, 'Vecteurs & Produit scalaire')," +
            	    		"('Condition de colinéarité : A: égalité B: orthogonalité C: proportionnalité D: produit nul', 'C', 2, 'Vecteurs & Produit scalaire')," +
            	    		"('Norme d’un vecteur : A: longueur B: angle C: volume D: surface', 'A', 1, 'Vecteurs & Produit scalaire')," +
            	    		"('Formule du produit scalaire : A: u+v B: u×v C: ||u||·||v||·cosθ D: u−v', 'C', 0, 'Vecteurs & Produit scalaire')," +
            	    		"('Vecteur nul est : A: infini B: longueur nulle C: unité D: direction', 'B', 3, 'Vecteurs & Produit scalaire')," +

            	    		// GÉOMÉTRIE ESPACE
            	    		"('Droite paramétrique : A: r=a+tu B: ax+by+c=0 C: x²+y²=1 D: y=ax²', 'A', 0, 'Géométrie espace')," +
            	    		"('Vecteur normal à un plan : A: parallèle B: perpendiculaire C: tangent D: nul', 'B', 1, 'Géométrie espace')," +
            	    		"('Équation d’un plan : A: y=ax+b B: ax+by+cz+d=0 C: r=a+tu D: x²+y²=1', 'B', 2, 'Géométrie espace')," +
            	    		"('Appartenance à une droite : A: dérivation B: substitution C: intégration D: limite', 'B', 1, 'Géométrie espace')," +
            	    		"('Intersection droite-plan : A: toujours vide B: point ou droite C: cercle D: parallèle', 'B', 3, 'Géométrie espace')," +
            	    		"('Vecteur directeur : A: scalaire B: direction C: norme D: angle', 'B', 0, 'Géométrie espace')," +

            	    		// LIMITES
            	    		"('Limite de 1/n : A: 1 B: ∞ C: 0 D: -1', 'C', 0, 'Limites')," +
            	    		"('Continuité signifie : A: saut B: rupture C: pas de saut D: constante', 'C', 1, 'Limites')," +
            	    		"('Limite d’un quotient : A: somme B: différence C: quotient D: produit', 'C', 2, 'Limites')," +
            	    		"('Logarithme de 1 : A: 1 B: 0 C: -1 D: ∞', 'B', 0, 'Limites')," +
            	    		"('Limite infinie signifie : A: stabilité B: divergence C: oscillation D: nullité', 'B', 3, 'Limites')," +
            	    		"('Limite d’une fonction continue : A: valeur différente B: égale valeur C: infinie D: nulle', 'B', 1, 'Limites')," +

            	    		// DÉRIVATION
            	    		"('Dérivée de f(g(x)) : A: f'(g(x))g'(x) B: f+g C: f×g D: g', 'A', 2, 'Dérivation')," +
            	    		"('Fonction composée : A: f(g(x)) B: f+g C: f×g D: f−g', 'A', 0, 'Dérivation')," +
            	    		"('Dérivée seconde : A: vitesse B: accélération C: limite D: aire', 'B', 1, 'Dérivation')," +
            	    		"('Convexité : A: courbure B: constante C: droite D: rupture', 'A', 2, 'Dérivation')," +
            	    		"('Si f''>0 alors : A: concave B: convexe C: linéaire D: constante', 'B', 3, 'Dérivation')," +
            	    		"('Rôle de la dérivée : A: aire B: pente C: volume D: distance', 'B', 0, 'Dérivation')," +

            	    		//FONCTIONS
            	    		"('Continuité signifie : A: pas de rupture B: saut C: dérivable D: constante', 'A', 1, 'Fonctions')," +
            	    		"('Logarithme de ab : A: produit B: somme C: différence D: quotient', 'B', 2, 'Fonctions')," +
            	    		"('sin(0) = ? A: 0 B: 1 C: π D: -1', 'A', 0, 'Fonctions')," +
            	    		"('cos(0) = ? A: 0 B: 1 C: -1 D: π', 'B', 0, 'Fonctions')," +
            	    		"('Fonction trigonométrique : A: polynôme B: linéaire C: sin D: constante', 'C', 1, 'Fonctions')," +
            	    		"('ln(e) = ? A: 1 B: 0 C: e D: -1', 'A', 0, 'Fonctions')";
            		
            
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







