import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Keying extends JPanel {

    public Rectangle character;

    public int charW = 24;
    public int charH = 36;

    public boolean right = false;
    public boolean left = false;
    public boolean up = false;
    public boolean down = false;


    public Keying(Display f, Images i){
        character = new Rectangle((Main.width/2), (Main.height/2), charW, charH);

        f.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                if (e.getKeyCode() ==  KeyEvent.VK_D){
                    right = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_A){
                    left = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_W){
                    up = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_S){
                    down = true;
                }
            }
            public void keyReleased(KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_D){
                    right = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_A){
                    left = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_W){
                    up = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_S){
                    down = false;
                }
            }
        });


    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        g.setColor(Color.WHITE);
        g.fillRect(character.x, character.y, character.width, character.height);

        if(right){
            character.x += 1;
        }
        if(left){
            character.x -= 1;
        }
        if(up){
            character.y -= 1;
        }
        if(down){
            character.y += 1;
        }
        repaint();
    }
}
