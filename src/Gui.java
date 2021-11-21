import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComponent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Gui implements ActionListener {
    //setup components
    private static JFrame window;
    private static JPanel startPanel;
    private JLabel player1Label;
    private JLabel player2Label;
    private JTextField player1Text;
    private JTextField player2Text;
    private JButton confirmButton;
    private static Font myFont = new Font("Default", Font.BOLD, 25);
    private static Color BoardBrown = new Color(80,40,30);
    private static Color White = new Color(255,255,255);
    String player1name;
    String player2name;

    public static void themer(JComponent component){
        component.setFont(myFont);
    }

    //display and second phase components
    JTextArea boardArea = new JTextArea();
    JPanel gamePanel;
    JTextField moveBox;

    public Gui() throws InterruptedException {
        window = new JFrame();
        startPanel = new JPanel();
        window.setSize(300, 200);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Chess");
        window.setResizable(false);
        boardArea.setEditable(false);
        boardArea.setHighlighter(null);

        window.add(startPanel);

        startPanel.setLayout(null);


        try {
            window.setIconImage(ImageIO.read(new File("assets/ChessIcon.jpg")));
        } 
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        new Gui();
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

        window.setVisible(true);
        
        //figure out how to get the output of the boxes
        String[] names = {"test", "not taking textbox input"};
        return names;
    }

    GridBagConstraints gbc = new GridBagConstraints();
    public GridBagConstraints gbcManager(GridBagConstraints gbc, int r, int c){
        //System.out.println("GBC.gridx before: " + gbc.gridx + ", GBC.gridy before: " + gbc.gridy);
        
        gbc.gridx = c;
        gbc.gridy = r;
        //should be a way to do this once
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        
        //----------------------

        //System.out.println("GBC.gridx after: " + gbc.gridx + ", GBC.gridy after: " + gbc.gridy);
        return gbc;
    }

    public void gameWindowSetup(){
        //game panel setup
        gamePanel = new JPanel();
        gamePanel.setLayout(new GridBagLayout());

        JFrame boardFrame = new JFrame();
        boardFrame.setLayout(new GridBagLayout());

        int gridsize = 10;
        JComponent[][] gameComponents = new JComponent[gridsize][gridsize];
        for(int r = 0; r < gridsize; r++){
            JComponent[] row = new JComponent[gridsize];
            for(int c = 0; c < gridsize; c++){
                if(r == 0 || r == gridsize - 1){
                    if(c == 0 || c == gridsize - 1){
                        row[c] = new JLabel("");
                    }
                    else{
                        row[c] = new JLabel(Character.toString((char) c + 96));
                    }
                }
                else if(r!= 0 && (c == 0 || c == row.length - 1)){
                    row[c] = new JLabel(String.valueOf(gridsize - 1 - r));
                }
                else{
                    if(Board.boardSpaces[r - 1][c - 1] != null)
                        row[c] = new JButton(Board.boardSpaces[r - 1][c - 1].toString());
                    else{
                        row[c] = new JButton("    ");
                    }
                    if (r % 2 == 0){
                        if(c % 2 == 0){
                            row[c].setBackground(White);
                        }
                        else{
                            row[c].setBackground(BoardBrown);
                        }
                    }
                    else{
                        if(c % 2 == 0){
                            row[c].setBackground(BoardBrown);
                        }
                        else{
                            row[c].setBackground(White);
                        }
                    }
                }
            }
            gameComponents[r] = row;
        }
        for(int r = 0; r < gridsize; r++){
            for(int c = 0; c < gridsize; c++){
                gamePanel.add(gameComponents[r][c], gbcManager(gbc, r, c));
                themer(gameComponents[r][c]);
            }
        }
    }

    public void actionPerformed(ActionEvent e){
        if(startPanel.isVisible()){
            App.playerOne.setPlayerName(player1Text.getText());
            App.playerTwo.setPlayerName(player2Text.getText());

            //frame change
            window.setSize(600, 600);
            startPanel.setVisible(false);

            //Player.move = moveBox.getText();
            window.add(gamePanel);
            gamePanel.setVisible(true);
        }
        else if(gamePanel.isVisible()){

            

            //Board JLabel update has to happen when a move is confirmed
        }
    }
}