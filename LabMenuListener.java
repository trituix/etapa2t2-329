import java.awt.event.*; 
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class LabMenuListener implements ActionListener {
   private MyWorld  world;
   public LabMenuListener (MyWorld  w){
      world = w;
   }
   public void actionPerformed(ActionEvent e) {
      JMenuItem menuItem = (JMenuItem)(e.getSource());
      String text = menuItem.getText();
      
      // Actions associated to main manu options
      if (text.equals("My scenario")) {  // here you define Etapa2's configuration
         world.clean();
         double mass = 1.0;      // 1 [kg] 
         double radius = 0.1;    // 10 [cm] 
         double position = 0.0;  // 1 [m] 
         double speed = 0.5;     // 0.5 [m/s]
         Ball b0 = new Ball(mass, radius, position, speed);
         Ball b1 = new Ball(mass, radius, 2.0, 0);
         world.addElement(b0);
         world.addElement(b1);
      }
      if (text.equals("Ball")) {
        // nothing by now       
      }
      if (text.equals("Fixed Hook")) ; // ; same as nothing
      if (text.equals("Spring")) ;

      // Actions associated to MyWorld submenu
      if (text.equals("Start")) {
         world.start();
      }
      if (text.equals("Stop")) {
         world.stop();
      }
      if (text.equals("Delta time")) {
         String data = JOptionPane.showInputDialog("Enter delta t [s]");
         world.setDelta_t(Double.parseDouble(data));
      }
      if (text.equals("Refresh time")) {
         String data = JOptionPane.showInputDialog("Enter refresh time [s]");
         world.setRefreshPeriod(Double.parseDouble(data));
      }
      if (text.equals("View Refresh time")) {
         JOptionPane.showMessageDialog(new JFrame("Refresh time"), "Current Refresh time: " + world.getRefreshPeriod() + " [s]");
      }
   }
}