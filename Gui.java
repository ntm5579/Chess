import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

import javax.imageio.ImageIO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
//import java.awt.Image;
import java.io.File;
import java.io.IOException;

public class Gui implements ActionListener {
    //setup components
    private JFrame frame;
    private JPanel startPanel;
    private JLabel player1Label;
    private JLabel player2Label;
    private JTextField player1Text;
    private JTextField player2Text;
    private JButton confirmButton;
    String player1name;
    String player2name;

    //display and second phase components
    JTextArea boardArea = new JTextArea();
    JPanel gamePanel;
    JTextField moveBox;

    public Gui() throws InterruptedException {
        frame = new JFrame();
        startPanel = new JPanel();
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Chess");
        frame.setResizable(false);
        boardArea.setEditable(false);
        boardArea.setHighlighter(null);

        frame.add(startPanel);

        startPanel.setLayout(null);

        // changes the icon on the jframe window
        try {
            frame.setIconImage(ImageIO.read(new File("ChessIcon.jpg")));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String[] nameWindow(){
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
        
        //figure out how to get the output of the boxes
        String[] names = {"test", "not taking textbox input"};
        return names;
    }

    public void gameWindowSetup(){
        //game panel setup
        //confirmButton.setBounds(500, 500, 80, 35);
        gamePanel = new JPanel();
        frame.add(gamePanel);
        gamePanel.setVisible(false);
        gamePanel.add(boardArea);
        
        moveBox = new JTextField();
        moveBox.setBounds(20, 500, 40, 160);
        gamePanel.add(moveBox);

        boardArea.setBounds(20, 20, 400, 400);
        boardArea.setText(Board.boardToJLabel());
        boardArea.setFont(boardArea.getFont().deriveFont(24.0f));
    }

    public static void main(String[] args) throws InterruptedException {
        new Gui();
    }

    public void actionPerformed(ActionEvent e){
        if(startPanel.isVisible()){
            App.playerOne.setPlayerName(player1Text.getText());
            App.playerTwo.setPlayerName(player2Text.getText());

            //frame change
            frame.setSize(600, 600);
            startPanel.setVisible(false);

            //Player.move = moveBox.getText();
            gamePanel.setVisible(true);
        }
        else if(gamePanel.isVisible()){

            

            //Board JLabel update has to happen when a move is confirmed
        }
    }
}