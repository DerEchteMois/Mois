import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Desktop;
 
public class VierGewinnt extends JFrame {
    // Anfang Attribute
 
    // Anfang Variablen
    private JLabel LeoLabel = new JLabel();
    //Versuch, eine Reset-Fkt einzuführen
    private JButton Reset = new JButton();
    //Größe des Feldes! falls änderung, methode winnerTest beachten!
    private JButton[][] buttons = new JButton[4][4];
    int[][] wert = new int[4][4];
    // Ende Variablen
 
    // Ende Attribute
    public VierGewinnt(String title) {
        // Frame-Initialisierung
        super(title);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 540;
        int frameHeight = 505;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        Container cp = getContentPane();
        cp.setLayout(null);
        // Anfang Komponenten
        //Koordinaten des Textes(links,oben,breite,höhe)
        LeoLabel.setBounds(156, 16, 233, 32);
        //Empfangstext
        LeoLabel.setText("Vier gewinnt by Leo H.");
        //Schriftfarbe und Größe
        LeoLabel.setFont(new Font("Papyrus", Font.ITALIC, 18));
        //farbe der schrift
        LeoLabel.setForeground(Color.blue);
        //hintergrundfarbe setzen
        LeoLabel.setBackground(Color.red);
        //hintergrund ist transparent, das wird hierdurch indirekt behoben
        LeoLabel.setOpaque(true);
        
        
        
        //fügt label zum applet hinzu
        cp.add(LeoLabel);
        
        //button reset zum applet hinzufügen
        cp.add(Reset);
        for (int xk = 0; xk < 4; xk++) {
            for (int yk = 0; yk < 4; yk++) {
                buttons[xk][yk] = new JButton("");
                buttons[xk][yk].setBounds(128 + 68 * xk, 64 + 74 * yk, 67, 73);
                buttons[xk][yk].addActionListener(new ActionListener() {
 
                    public void actionPerformed(ActionEvent evt) {
                        buttonClicked(evt);
                    }
                });
                cp.add(buttons[xk][yk]);
            }
        }
 
 
        setResizable(false);
        setVisible(true);
    }
 
    // Anfang Ereignisprozeduren
    // Anfang Methoden
   
        
   
 
    // Ende Methoden
    public static void main(String[] args) {
        new VierGewinnt("DuBrauchstEineReihe,Mois!");
    }
    int total = 0;
 
    public void buttonClicked(ActionEvent evt) {
        JButton button = (JButton) evt.getSource();
        button.setText(total % 2 == 0 ? "X" : "O");
        button.setEnabled(false);
 
        for (int xk = 0; xk < 4; xk++) {
            for (int yk = 0; yk < 4; yk++) {
                if (buttons[xk][yk] == button) {
                    wert[xk][yk] = 1 + total % 2;
                }
            }
        }
        winnerTest(1 + total % 2);
        total++;
    }
 
    public void winnerTest(int value) {
        boolean winner = false;
        for(int i = 0; i < 4; i++) {
            if(wert[i][0] == value && wert[i][1] == value && wert[i][2] == value && wert[i][3] == value) {
                winner = true;
            }
            if(wert[0][i] == value && wert[1][i] == value && wert[2][i] == value && wert[3][i] == value) {
                winner = true;
            }
        }
       if(wert[0][0] == value && wert[1][1] == value && wert[2][2] == value && wert[3][3] == value) {
           winner = true;
       }
       if(wert[0][3] == value && wert[1][2] == value && wert[2][1] == value && wert[3][0] == value) {
           winner = true;
       }
 
        if (winner) {
           JOptionPane.showMessageDialog(this, "Du, Spieler" + value + ", bist der Sieger!");
            for (int xk = 0; xk < 4; xk++) {
                for (int yk = 0; yk < 4; yk++) {
                    buttons[xk][yk].setText("");
                    buttons[xk][yk].setEnabled(true);
                    wert[xk][yk] = 0;
                }
            }
            total = 0;
        }
    }
}