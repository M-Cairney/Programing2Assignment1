import javax.swing.*;
import java.awt.*;

public class Display extends JFrame {
    public JPanel gp = (JPanel) getGlassPane();
    public Images i;
    public Keying k;

    public Display(){
        super("Tron");
        setVisible(true);
        gp.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        i = new Images();
        k = new Keying(this, i);

        gp.setLayout(new GridLayout(1,1,0,0));
        this.setLayout(new GridLayout(1,1,0,0));

        gp.add(k);
        this.add(i);


    }
}
