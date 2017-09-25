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

    public int count = 0;

    public static int startx;
    public static int starty;
    public static int finishx;
    public static int finishy;

    public JetWall JetWallLines = new JetWall();


    public Keying(Display f, Images i){
        character = new Rectangle((Main.width/2), (Main.height/2), charW, charH);

        f.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                startx = character.x;
                starty = character.y;

                if (e.getKeyCode() ==  KeyEvent.VK_D){
                    right = true;
                    left = false;
                    up = false;
                    down = false;
                    finishx = character.x;
                    finishy = character.y;
                    JetWallLines.addLine(startx, starty, finishx, finishy, Color.BLACK);
                    count+=1;
                }
                if(e.getKeyCode() == KeyEvent.VK_A){
                    left = true;
                    right = false;
                    up = false;
                    down = false;
                    finishx = character.x;
                    finishy = character.y;
                    JetWallLines.addLine(startx, starty, finishx, finishy, Color.BLACK);
                    count+=1;
                }
                if(e.getKeyCode() == KeyEvent.VK_W){
                    up = true;
                    left = false;
                    down = false;
                    right = false;
                    finishx = character.x;
                    finishy = character.y;
                    JetWallLines.addLine(startx, starty, finishx, finishy, Color.BLACK);
                    count+=1;
                }
                if(e.getKeyCode() == KeyEvent.VK_S){
                    down = true;
                    up = false;
                    right = false;
                    left = false;
                    finishx = character.x;
                    finishy = character.y;
                    JetWallLines.addLine(startx, starty, finishx, finishy, Color.BLACK);
                    count+=1;
                }
            }

        });


    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        g.setColor(Color.BLACK);
        g.fillRect(character.x, character.y, character.width, character.height);

        if(right && character.x + (character.width + character.width/2) <= Main.width){
            try {
                Thread.sleep(5);
            } catch (InterruptedException ie) { }

            character.x += 1;

        }
        if(left && character.x > 0){
            try {
                Thread.sleep(5);
            } catch (InterruptedException ie) { }

            character.x -= 1;


        }
        if(up && character.y > 0){
            try {
                Thread.sleep(5);
            } catch (InterruptedException ie) { }

            character.y -= 1;

        }
        if(down && character.y + (character.height *2) <= Main.height ){
            try {
                Thread.sleep(5);
            } catch (InterruptedException ie){}

            character.y += 1;

        }
        repaint();
        ///if(!finishx.isEmpty()) {
            ///for (int i = 0; i >= count; ++i)
               /// g.drawLine(startx.get(count-1), starty.get(count-1), finishx.get(count), finishy.get(count));
        }



    }

