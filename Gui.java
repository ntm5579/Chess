import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import javax.imageio.ImageIO;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class Gui implements ActionListener {
    private JFrame frame;
    private JPanel startPanel;
    private JLabel player1Label;
    private JLabel player2Label;
    private JTextField player1Text;
    private JTextField player2Text;
    private JButton confirmButton;

    String player1name;
    String player2name;

    public Gui() throws InterruptedException {
        frame = new JFrame();
        startPanel = new JPanel();
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Chess");
        frame.setResizable(false);

        frame.add(startPanel);

        startPanel.setLayout(null);

        // changes the icon on the jframe window
        try {
            frame.setIconImage(ImageIO.read(new File("ChessIcon.jpg")));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // ui for setting names

        player1Label = new JLabel("Player 1: ");
        player1Label.setBounds(15, 20, 80, 25);
        startPanel.add(player1Label);

        player2Label = new JLabel("Player 2: ");
        player2Label.setBounds(15, 60, 80, 25);
        startPanel.add(player2Label);

        player1Text = new JTextField();
        player1Text.setBounds(80, 20, 165, 25);
        startPanel.add(player1Text);

        player2Text = new JTextField();
        player2Text.setBounds(80, 60, 165, 25);
        startPanel.add(player2Text);

        confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(this);
        confirmButton.setBounds(165, 100, 80, 35);
        Color buttonBlue = new Color(0, 136, 252);
        confirmButton.setBackground(buttonBlue);
        confirmButton.setBorderPainted(false);
        startPanel.add(confirmButton);

        frame.setVisible(true);
        // end of the first panel

        // changing to a different panel
        /*
         * frame.setVisible(false); frame.setSize(300, 200); TimeUnit.SECONDS.sleep(10);
         * frame.remove(test1); frame.add(test2);
         */

        // this.setText(""); to print out the chess board data

        frame.setVisible(true);
        // end of the second panel
    }

    public static void main(String[] args) throws InterruptedException {
        new Gui();

    }

    public void actionPerformed(ActionEvent e){
        player1name = player1Text.getText();
        player2name = player2Text.getText();
        
        //testing string collection
        System.out.println(player1name);
        System.out.println(player2name);

        //frame change tests
        frame.setSize(600, 200);
        player1Label.setVisible(false);
        player2Label.setVisible(false);
    }
}