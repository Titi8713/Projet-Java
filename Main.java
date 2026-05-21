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

            				
            		//PROBABILITES

            		"('Combien de façons de choisir 2 élèves parmi 5 ? A: 20 B: 10 C: 5 D: 15', 'B', 0, 'Probabilités')," +
            		"('Nombre d’anagrammes du mot BAC ? A: 6 B: 9 C: 3 D: 12', 'A', 1, 'Probabilités')," +
            		"('Dans un schéma de Bernoulli, les expériences sont : A: variables B: indépendantes C: impossibles D: dépendantes', 'B', 0, 'Probabilités')," +
            		"('Dans un schéma de Bernoulli, p représente : A: la probabilité de succès B: le nombre d’essais C: la moyenne D: une dérivée', 'A', 1, 'Probabilités')," +
            		"('Une loi binomiale permet de compter : A: les limites B: les succès C: les vecteurs D: les intégrales', 'B', 0, 'Probabilités')," +
            		"('Espérance d’une loi binomiale : A: n+p B: p/n C: np D: n²', 'C', 1, 'Probabilités')," +
            		"('Une variable aléatoire associe : A: un nombre réel à une issue B: une matrice C: une droite D: une dérivée', 'A', 0, 'Probabilités')," +
            		"('L’espérance représente : A: une limite B: une moyenne théorique C: une dérivée D: une somme', 'B', 1, 'Probabilités')," +
            		"('La loi des grands nombres parle de : A: convergence B: divergence C: dérivation D: convexité', 'A', 0, 'Probabilités')," +
            		"('Quand le nombre d’essais augmente, la fréquence tend vers : A: 0 B: l’infini C: la probabilité D: une dérivée', 'C', 1, 'Probabilités')," +

            		
            		//VECTEURS ET PRODUIT SCALAIRE

            		"('Un vecteur possède : A: seulement une norme B: une norme et une direction C: seulement une direction D: une courbe', 'B', 0, 'Vecteurs & Produit scalaire')," +
            		"('Deux vecteurs colinéaires sont : A: proportionnels B: orthogonaux C: opposés D: identiques', 'A', 1, 'Vecteurs & Produit scalaire')," +
            		"('Produit scalaire de deux vecteurs perpendiculaires : A: -1 B: 1 C: impossible D: 0', 'D', 0, 'Vecteurs & Produit scalaire')," +
            		"('Le produit scalaire sert à calculer : A: une limite B: une intégrale C: un angle D: une dérivée', 'C', 1, 'Vecteurs & Produit scalaire')," +
            		"('La norme d’un vecteur correspond à : A: sa longueur B: sa pente C: sa somme D: son angle', 'A', 0, 'Vecteurs & Produit scalaire')," +
            		"('Un vecteur nul a : A: une norme infinie B: une norme nulle C: une direction fixe D: un angle droit', 'B', 1, 'Vecteurs & Produit scalaire')," +
            		"('Formule du produit scalaire : A: u-v B: u×v C: ||u|| ||v|| cos(θ) D: u+v', 'C', 0, 'Vecteurs & Produit scalaire')," +
            		"('Deux vecteurs sont orthogonaux si : A: ils sont égaux B: leur produit scalaire vaut 0 C: ils sont parallèles D: leur somme vaut 0', 'B', 1, 'Vecteurs & Produit scalaire')," +

            		
            		//GÉOMETRIE DANS L’ESPACE

            		"('Une droite paramétrique utilise : A: une intégrale B: un logarithme C: un paramètre réel D: une dérivée', 'C', 0, 'Géométrie espace')," +
            		"('Dans r=a+tu, u est : A: une limite B: un vecteur directeur C: un point D: une norme', 'B', 1, 'Géométrie espace')," +
            		"('Équation cartésienne d’un plan : A: ax+by+cz+d=0 B: y=ax² C: x²+y²=1 D: y=ax+b', 'A', 0, 'Géométrie espace')," +
            		"('Dans un plan, (a,b,c) représente : A: une dérivée B: une solution C: un vecteur normal D: une limite', 'C', 1, 'Géométrie espace')," +
            		"('Pour trouver un point d’une droite paramétrique, il faut : A: fixer t B: dériver C: intégrer D: factoriser', 'A', 0, 'Géométrie espace')," +
            		"('Deux droites parallèles ont : A: la même limite B: le même point C: le même vecteur directeur D: la même norme', 'C', 1, 'Géométrie espace')," +
            		"('Un point appartient à un plan si : A: il annule une dérivée B: il vérifie l’équation C: il diverge D: il est orthogonal', 'B', 0, 'Géométrie espace')," +
            		"('Intersection de deux plans non parallèles : A: un cercle B: rien C: un point D: une droite', 'D', 1, 'Géométrie espace')," +

            		
            		//SUITES

            		"('Limite de 1/n quand n tend vers +∞ : A: 0 B: 1 C: +∞ D: -1', 'A', 0, 'Suites')," +
            		"('Une suite croissante : A: diminue B: augmente C: oscille D: diverge toujours', 'B', 1, 'Suites')," +
            		"('Une suite bornée possède : A: une dérivée B: une asymptote C: des bornes D: une intégrale', 'C', 0, 'Suites')," +
            		"('Le théorème des gendarmes concerne : A: les dérivées B: les intégrales C: les vecteurs D: les limites', 'D', 1, 'Suites')," +
            		"('La suite n² tend vers : A: 0 B: 1 C: -∞ D: +∞', 'D', 0, 'Suites')," +
            		"('Une suite constante est : A: convergente B: divergente C: périodique D: aléatoire', 'A', 1, 'Suites')," +

            			
            		// DERIVATION

            		"('La dérivée de f(g(x)) utilise : A: une intégrale B: la règle de chaîne C: un vecteur D: une limite', 'B', 1, 'Dérivation')," +
            		"('La dérivée seconde étudie : A: la variation de pente B: le volume C: la norme D: la somme', 'A', 0, 'Dérivation')," +
            		"('Si f''''(x)>0 alors la fonction est : A: constante B: décroissante C: convexe D: concave', 'C', 1, 'Dérivation')," +
            		"('Une fonction convexe a une courbe : A: tournée vers le haut B: tournée vers le bas C: constante D: nulle', 'A', 0, 'Dérivation')," +
            		"('Point d’inflexion : A: maximum B: changement de convexité C: minimum D: asymptote', 'B', 1, 'Dérivation')," +
            		"('Une équation différentielle contient : A: une intégrale B: une dérivée C: un vecteur D: une matrice', 'B', 0, 'Dérivation')," +
            		"('La fonction f(x)=Ce^x est solution de : A: y''=y B: y''=-y C: y''=0 D: y''=2y', 'A', 1, 'Dérivation')," +
            		
            		//FONCTIONS
            		"('Une fonction continue admet : A: une asymptote B: une transition sans coupure C: une rupture D: un saut', 'B', 0, 'Fonctions')," +
            		"('Une fonction discontinue possède : A: une dérivée B: une intégrale C: une rupture D: une norme', 'C', 1, 'Fonctions')," +
            		"('Le domaine de ln(x) est : A: x>0 B: x<0 C: x≠0 D: tous les réels', 'A', 0, 'Fonctions')," +
            		"('ln(1)= ? A: e B: -1 C: 0 D: 1', 'C', 1, 'Fonctions')," +
            		"('La période de sin(x) est : A: 0 B: 1 C: π D: 2π', 'D', 0, 'Fonctions')," +
            		"('tan(x)= ? A: sin(x)+cos(x) B: sin(x)/cos(x) C: cos(x)/sin(x) D: sin²(x)', 'B', 1, 'Fonctions')," +
            		"('Une fonction affine est : A: discontinue B: impossible C: continue D: périodique', 'C', 0, 'Fonctions')," +
            		"('Une fonction trigonométrique connue est : A: exp(x) B: ln(x) C: x² D: sin(x)', 'D', 1, 'Fonctions')," +
            		"('La limite de x² quand x→2 vaut : A: 8 B: 4 C: 2 D: 6', 'B', 0, 'Fonctions')," +
            		"('Une asymptote verticale correspond à : A: une limite infinie B: une dérivée nulle C: une somme D: une intégrale', 'A', 1, 'Fonctions')," +
            		"('f∘g signifie : A: f+g B: g-f C: f(g(x)) D: f×g', 'C', 0, 'Fonctions')," +
            		"('Exemple de fonction composée : A: x² B: x+1 C: 2x D: sin(x²)', 'D', 0, 'Fonctions')" +
            		";";
            		
            
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
    	
    	JButton btnDenombrement=new JButton("Ouvrir le cours sur le Dénombrement : PROBABILITE");
    	btnDenombrement.addActionListener(e -> ouvrirPDF(Dénombrement));  
    	JButton btnGrandsNombres = new JButton("Ouvrir le cours sur les Grands Nombres : PROBABILITE");
    	btnGrandsNombres.addActionListener(e -> ouvrirPDF(GrandsNombres));
    	JButton btnLoiBinomiale = new JButton("Ouvrir le cours sur la Loi Binomiale : PROBABILITE");
    	btnLoiBinomiale.addActionListener(e -> ouvrirPDF(LoiBinomiale));
    	JButton btnSchemaBernoulli = new JButton("Ouvrir le cours sur le Schéma de Bernoulli : PROBABILITE");
    	btnSchemaBernoulli.addActionListener(e -> ouvrirPDF(SchemaBernouilli));
    	JButton btnVariablesAleatoires = new JButton("Ouvrir le cours sur les Variables Aléatoires : PROBABILITE");
    	btnVariablesAleatoires.addActionListener(e -> ouvrirPDF(VariablesAleatoires));	

    	JButton btnProduitScalaire = new JButton("Ouvrir le cours sur le Produit Scalaire : VECTEURS ET PRODUIT SCALAIRE");
    	btnProduitScalaire.addActionListener(e -> ouvrirPDF(ProduitScalaire));
    	JButton btnCalculVectoriel = new JButton("Ouvrir le cours sur le Calcul Vectoriel : VECTEURS ET PRODUIT SCALAIRE");
    	btnCalculVectoriel.addActionListener(e -> ouvrirPDF(CalculVectoriel));

    	JButton btnEquationCartesienne = new JButton("Ouvrir le cours sur l'Équation Cartésienne : GEOMETRIE DANS L'ESPACE");
    	btnEquationCartesienne.addActionListener(e -> ouvrirPDF(EquationCartesienne));

    	JButton btnRepresentationParam = new JButton("Ouvrir le cours sur la Représentation Paramétrique : GEOMETRIE DANS L'ESPACE");
    	btnRepresentationParam.addActionListener(e -> ouvrirPDF(RepresentationParametrique));

    	JButton btnLimiteSuite = new JButton("Ouvrir le cours sur les Limites de Suites : SUITES");
    	btnLimiteSuite.addActionListener(e -> ouvrirPDF(LimiteSuite));

    	JButton btnConvexite = new JButton("Ouvrir le cours sur la Convexité : DERIVATION");
    	btnConvexite.addActionListener(e -> ouvrirPDF(Convexite));
    	JButton btnDeriveeSeconde = new JButton("Ouvrir le cours sur la Dérivée Seconde : DERIVATION");
    	btnDeriveeSeconde.addActionListener(e -> ouvrirPDF(DeriveeSeconde));
    	JButton btnEquaDiff = new JButton("Ouvrir le cours sur les Équations Différentielles : DERIVATION");
    	btnEquaDiff.addActionListener(e -> ouvrirPDF(EquaDiff));
    	
    	JButton btnLimitesFonctions = new JButton("Ouvrir le cours sur les Limites de Fonctions : FONCTIONS");
    	btnLimitesFonctions.addActionListener(e -> ouvrirPDF(LimitesFonctions));
    	JButton btnCalculIntegral = new JButton("Ouvrir le cours sur le Calcul Intégral : FONCTIONS");
    	btnCalculIntegral.addActionListener(e -> ouvrirPDF(CalculIntegral));
    	JButton btnComposeeFonctions = new JButton("Ouvrir le cours sur les Fonctions Composées : FONCTIONS");
    	btnComposeeFonctions.addActionListener(e -> ouvrirPDF(ComposéeFonctions));
    	JButton btnContinuite = new JButton("Ouvrir le cours sur la Continuité : FONCTIONS");
    	btnContinuite.addActionListener(e -> ouvrirPDF(Continuite));
    	JButton btnFonctionsTrigo = new JButton("Ouvrir le cours sur les Fonctions Trigonométriques : FONCTIONS");
    	btnFonctionsTrigo.addActionListener(e -> ouvrirPDF(FonctionsTrigo));
    	JButton btnIntegration = new JButton("Ouvrir le cours sur l'Intégration : FONCTIONS");
    	btnIntegration.addActionListener(e -> ouvrirPDF(Integration));
    	JButton btnLogarithmes = new JButton("Ouvrir le cours sur les Logarithmes : FONCTIONS");
    	btnLogarithmes.addActionListener(e -> ouvrirPDF(Logarithmes));
    	

    	//Affichage des boutons 
    	frame.add(btnStart);
    	frame.add(btnFinal);
    	 
    	frame.add(btnDenombrement);
    	frame.add(btnGrandsNombres);
    	frame.add(btnLoiBinomiale);
    	frame.add(btnSchemaBernoulli);
    	frame.add(btnVariablesAleatoires);

    	frame.add(btnCalculVectoriel);
    	frame.add(btnProduitScalaire);

    	frame.add(btnRepresentationParam);
    	frame.add(btnEquationCartesienne);

    	frame.add(btnLimiteSuite);
    	
    	frame.add(btnConvexite);
    	frame.add(btnDeriveeSeconde);
    	frame.add(btnEquaDiff);
    	
    	frame.add(btnCalculIntegral);
    	frame.add(btnComposeeFonctions);
    	frame.add(btnContinuite);
    	frame.add(btnFonctionsTrigo);
    	frame.add(btnIntegration);
    	frame.add(btnLimitesFonctions);
    	frame.add(btnLogarithmes);
    	
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








