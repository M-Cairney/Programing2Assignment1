import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class Keying extends JPanel {

    public Rectangle character;

    public int charW = 24;
    public int charH = 36;

    public boolean right = false;
    public boolean left = false;
    public boolean up = false;
    public boolean down = false;

    public int count = 0;

    public static ArrayList<Integer> startx = new ArrayList<Integer>();
    public static ArrayList<Integer> starty = new ArrayList<Integer>();
    public static ArrayList<Integer> finishx = new ArrayList<Integer>();
    public static ArrayList<Integer> finishy = new ArrayList<Integer>();


    public Keying(Display f, Images i){
        character = new Rectangle((Main.width/2), (Main.height/2), charW, charH);

        f.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                startx.add(character.x);
                starty.add(character.y);

                if (e.getKeyCode() ==  KeyEvent.VK_D){
                    right = true;
                    left = false;
                    up = false;
                    down = false;
                    finishx.add(character.x);
                    finishy.add(character.y);
                    count+=1;
                }
                if(e.getKeyCode() == KeyEvent.VK_A){
                    left = true;
                    right = false;
                    up = false;
                    down = false;
                    finishx.add(character.x);
                    finishy.add(character.y);
                    count+=1;
                }
                if(e.getKeyCode() == KeyEvent.VK_W){
                    up = true;
                    left = false;
                    down = false;
                    right = false;
                    finishx.add(character.x);
                    finishy.add(character.y);
                    count+=1;
                }
                if(e.getKeyCode() == KeyEvent.VK_S){
                    down = true;
                    up = false;
                    right = false;
                    left = false;
                    finishx.add(character.x);
                    finishy.add(character.y);
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
           /// for (int i = 0; i < count; ++i)
                ///g.drawLine(startx.get(count-1), starty.get(count-1), finishx.get(count), finishy.get(count));}



    }
}
