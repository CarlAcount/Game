/**
 *
 * @author Carl and GuoHao
 * @version 1.0
 */
package game;

public class Main {

    /**
     * Runs the Game
     * Creates and display the dialog
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            Game dialog = new Game(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }
    


    
}
