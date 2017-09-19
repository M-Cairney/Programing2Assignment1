import javax.swing.*;

public class Main {
    public static int height, width;
    public static void main(String[] args) {
        String inStr;
        height = 1000;
        width=1000;
        ///inStr = JOptionPane.showInputDialog(null,
        ///        "Enter height of the field");
        ///height = Integer.parseInt(inStr);
        ///inStr = JOptionPane.showInputDialog(null,
        ///        "Enter width of the field");
        ///width = Integer.parseInt(inStr);
        Display firstFrame = new Display();
        firstFrame.setSize(width,height);
        firstFrame.setResizable(false);
        firstFrame.setLocationRelativeTo(null);

    }
}
