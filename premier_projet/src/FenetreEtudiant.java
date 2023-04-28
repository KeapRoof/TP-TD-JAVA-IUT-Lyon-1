import javax.swing.*;
import javax.tools.*;

public class FenetreEtudiant extends JFrame{

    JLabel label = new JLabel("Bienvenue dans l'application de gestion des etudiants");
    JLabel lblnom = new JLabel("Nom : ");
    JLabel lblprenom = new JLabel("Prenom : ");
    public FenetreEtudiant(){
        this.setTitle("Gestion des etudiants");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        // Ajout des composants
        JPanel pan = new JPanel();
        JPanel cp = (JPanel) this.getContentPane();
        this.setContentPane(pan);
        cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
        cp.add(label);
        cp.add(lblnom);
        cp.add(lblprenom);
        this.setIconImage(im);
    }

    public static void main(String[] args){
        FenetreEtudiant fen = new FenetreEtudiant();
        
    }
}
