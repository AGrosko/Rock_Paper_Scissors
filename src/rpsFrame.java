import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class rpsFrame extends JFrame {

    int compChoice;
    int scoreHolder;
    Random rand;

    JPanel mainPnl;
    JPanel controlPnl;
        JButton quitBtn;
        JButton rockBtn;
            JLabel rIconLbl;
            ImageIcon rIcon;
        JButton paperBtn;
            JLabel pIconLbl;
            ImageIcon pIcon;
        JButton scissorBtn;
            JLabel sIconLbl;
            ImageIcon sIcon;
    JPanel statsPnl;
        JLabel playerLbl;
            JTextArea playerTA;
        JLabel compLbl;
            JTextArea compTA;
        JLabel tieLbl;
            JTextArea tieTA;
    JPanel resultsPnl;
        JTextArea resultsTA;
        JScrollPane scroller;


public rpsFrame(){
    rand = new Random();
    mainPnl = new JPanel();
    mainPnl.setLayout(new BorderLayout());



    createStatsPnl();
    mainPnl.add(statsPnl,BorderLayout.NORTH);

    createControlPnl();
    mainPnl.add(controlPnl,BorderLayout.CENTER);

    createResultsPnl();
    mainPnl.add(resultsPnl,BorderLayout.SOUTH);
    this.add(mainPnl);


    quitBtn.addActionListener(new ActionListener() {
        @Override
        /**
         * Action Listeners for each button.
         * Quit will end the program and
         * the rps buttons will call the runRound with the appropriate parameter
         */
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    });
    rockBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            resultsTA.append("Player Chose Rock \n");
            runRound(0);
        }
    });
    paperBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            resultsTA.append("Player Chose Paper \n");
            runRound(1);
        }
    });
    scissorBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            resultsTA.append("Player Chose Scissors \n");
            runRound(2);
        }
    });
}

private void createStatsPnl(){
    playerLbl = new JLabel("Player Wins");
    playerTA = new JTextArea();
    playerTA.setText("0");

    compLbl = new JLabel("Computer Wins");
    compTA = new JTextArea();
    compTA.setText("0");

    tieLbl = new JLabel("Ties");
    tieTA = new JTextArea();
    tieTA.setText("0");

    statsPnl = new JPanel();
    statsPnl.setLayout(new GridLayout(2,3));

    statsPnl.add(playerLbl);
    statsPnl.add(compLbl);
    statsPnl.add(tieLbl);

    statsPnl.add(playerTA);
    statsPnl.add(compTA);
    statsPnl.add(tieTA);

    mainPnl.add(statsPnl);
    statsPnl.setVisible(true);
    add(statsPnl);

}

private void createControlPnl(){
        quitBtn = new JButton("Quit");
        scissorBtn = new JButton("Scissors");
        rockBtn = new JButton("Rock");
        paperBtn = new JButton("Paper");

        sIcon = new ImageIcon("scissors.PNG");
            sIconLbl= new JLabel(sIcon);
        rIcon = new ImageIcon("rock.PNG");
            rIconLbl= new JLabel(rIcon);
        pIcon = new ImageIcon("paper.PNG");
            pIconLbl= new JLabel(pIcon);

        controlPnl = new JPanel();
        controlPnl.setLayout(new GridBagLayout());
        GridBagConstraints cons = new GridBagConstraints();

        cons.gridx=0;
        cons.gridy=0;
        controlPnl.add(rIconLbl,cons);
    cons.gridx=1;
    cons.gridy=0;
        controlPnl.add(pIconLbl,cons);
    cons.gridx=2;
    cons.gridy=0;
        controlPnl.add(sIconLbl,cons);
    cons.gridx=0;
    cons.gridy=1;
        controlPnl.add(rockBtn,cons);
    cons.gridx=1;
    cons.gridy=1;
        controlPnl.add(paperBtn,cons);
    cons.gridx=2;
    cons.gridy=1;
        controlPnl.add(scissorBtn,cons);
    cons.gridx=1;
    cons.gridy=2;

        controlPnl.add(quitBtn,cons);

        controlPnl.setBorder(new MatteBorder(20,20,20,20,Color.BLACK));

        mainPnl.add(controlPnl);
        controlPnl.setVisible(true);
        add(controlPnl);



}

private void createResultsPnl(){
    resultsTA = new JTextArea(5,30);
    scroller = new JScrollPane(resultsTA);

    resultsPnl = new JPanel();
    resultsPnl.add(scroller);
    mainPnl.add(resultsPnl,BorderLayout.SOUTH);
    resultsPnl.setVisible(true);
    add(resultsPnl);
}

private void runRound(int playerChoice){

    /**
     * runRound generates the computers choice and prints the result of the game
     */
    // rock - 0
    // paper - 1
    //scissors - 2
    compChoice = rand.nextInt(3);

    if (compChoice == 0){
        resultsTA.append("Computer Chose Rock \n");
    } else if (compChoice == 1) {
        resultsTA.append("Computer Chose Paper \n");
    } else  {
        resultsTA.append("Computer Chose Scissors \n");
    }

    if(compChoice == playerChoice){
        //tie
        //code for printing and changing score
        scoreHolder = Integer.parseInt(tieTA.getText());
        scoreHolder++;
        tieTA.setText(Integer.toString(scoreHolder));
        resultsTA.append("!!!!!!!!!!!!!Tie!!!!!!!!!!!!! \n");

    } else if ((compChoice ==0 && playerChoice == 2)  || (compChoice== 1 && playerChoice == 0) || (compChoice==2 && playerChoice == 1)) {
        //comp wins
        //code for printing and changing score
        scoreHolder = Integer.parseInt(compTA.getText());
        scoreHolder++;
        compTA.setText(Integer.toString(scoreHolder));
        resultsTA.append("!!!!!!!!Computer Wins!!!!!!!! \n");
    }
    else{
        //player wins
        //code for
        scoreHolder = Integer.parseInt(playerTA.getText());
        scoreHolder++;
        playerTA.setText(Integer.toString(scoreHolder));
        resultsTA.append("!!!!!!!!!Player Wins!!!!!!!!!\n");
    }
}

}
