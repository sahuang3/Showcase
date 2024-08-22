import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TicTacToe extends JFrame implements ActionListener {

    JPanel pane;
    JLabel label1;
    JLabel label2;
    JLabel label3;

    JButton button1; // top left
    JButton button2; // top middle
    JButton button3; // top right
    JButton button4; // middle left
    JButton button5; // middle
    JButton button6; // middle right
    JButton button7; // bottom left
    JButton button8; // bottom middle
    JButton button9; // bottom right

    private final char[][] board = new char[3][3];

    private int turn = 1;
    private char symbol = ' ';

    // Initialize the board with empty slots
    public void initializeBoard(){
        // Assigning default values for board 2D array
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                board[i][j] = '_';
            }
        }
    }

    // Check whose turn it is and change the symbol
    public void symbolCheck(){
        if(turn%2 != 0){
            symbol = 'X';
        } else{
            symbol = 'O';
        }
        turn++;
    }

    // Checking win conditions: row, column, diagonal
    public boolean checkRow(){
        for(int i=0; i<3; i++){
            if(board[i][0] == 'X' && board[i][1] == 'X' && board[i][2] == 'X'){
                return true;
            } else if(board[i][0] == 'O' && board[i][1] == 'O' && board[i][2] == 'O'){
                return true;
            }
        }
        return false;
    }

    public boolean checkColumn(){
        for(int i=0; i<3; i++){
            if(board[0][i] == 'X' && board[1][i] == 'X' && board[2][i] == 'X'){
                return true;
            } else if(board[0][i] == 'O' && board[1][i] == 'O' && board[2][i] == 'O'){
                return true;
            }
        }
        return false;
    }

    public boolean checkDiagonal(){
        for(int i=0; i<3; i++){
            // Diagonal starting from top left
            if(board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X'){
                return true;
            } else if(board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O'){
                return true;
                // Diagonal starting from top right
            } else if(board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X'){
                return true;
            } else if(board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O'){
                return true;
            }
        }
        return false;
    }

    // Final check for all 3 win conditions or if tied
    public void checkWinner(){
        if(checkRow() || checkColumn() || checkDiagonal()){
            // If there is a winner
            System.out.println("There is a winner! Restarting...");
            initializeBoard();
            boardDisplay();
            turn = 1;
            // If it's a tie game
        } else if(turn == 10 && !checkRow() && !checkColumn() && !checkDiagonal()){
            System.out.println("Tie game! Restarting...");
            initializeBoard();
            boardDisplay();
            turn = 1;
        }
    }

    // Displaying the board on label2
    public void boardDisplay(){
        String row1 = board[0][0] + " " + board[0][1] + " " + board[0][2];
        String row2 = board[1][0] + " " + board[1][1] + " " + board[1][2];
        String row3 = board[2][0] + " " + board[2][1] + " " + board[2][2];
        label2.setText("<html>"+ row1 + "<br>" + row2 + "<br>" + row3 +"</html>");
    }

    // Action after pressing buttons
    public void actionPerformed(ActionEvent e){

        // When the buttons are pressed: check if existing symbol is there, place a symbol, checking win conditions, display.
        if(e.getActionCommand().equals("button1_clicked")){
            if(board[0][0] == '_'){
                symbolCheck();
                board[0][0] = symbol;
                boardDisplay();
                checkWinner();
            }
        } else if(e.getActionCommand().equals("button2_clicked")){
            if (board[0][1] == '_'){
                symbolCheck();
                board[0][1] = symbol;
                boardDisplay();
                checkWinner();
            }
        } else if(e.getActionCommand().equals("button3_clicked")){
            if (board[0][2] == '_'){
                symbolCheck();
                board[0][2] = symbol;
                boardDisplay();
                checkWinner();
            }
        } else if(e.getActionCommand().equals("button4_clicked")){
            if (board[1][0] == '_'){
                symbolCheck();
                board[1][0] = symbol;
                boardDisplay();
                checkWinner();
            }
        } else if(e.getActionCommand().equals("button5_clicked")){
            if (board[1][1] == '_'){
                symbolCheck();
                board[1][1] = symbol;
                boardDisplay();
                checkWinner();
            }
        } else if(e.getActionCommand().equals("button6_clicked")){
            if (board[1][2] == '_'){
                symbolCheck();
                board[1][2] = symbol;
                boardDisplay();
                checkWinner();
            }
        } else if(e.getActionCommand().equals("button7_clicked")){
            if (board[2][0] == '_'){
                symbolCheck();
                board[2][0] = symbol;
                boardDisplay();
                checkWinner();
            }
        } else if(e.getActionCommand().equals("button8_clicked")){
            if (board[2][1] == '_'){
                symbolCheck();
                board[2][1] = symbol;
                boardDisplay();
                checkWinner();
            }
        } else if(e.getActionCommand().equals("button9_clicked")){
            if (board[2][2] == '_'){
                symbolCheck();
                board[2][2] = symbol;
                boardDisplay();
                checkWinner();
            }
        }
    }

    // Setting up GUI
    public TicTacToe(){
        super("Tic-Tac-Toe");
        this.setPreferredSize(new Dimension(500, 500));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Start the game with a fresh 3x3 board
        initializeBoard();

        // Setting up content pane
        pane = new JPanel();
        GridLayout layout = new GridLayout(4,3);
        pane.setLayout(layout);

        // 3 labels to take up a row on the grid
        label1 = new JLabel("");
        label2 = new JLabel(""); // This will be the main one to display with
        label3 = new JLabel("");

        // Setting up buttons
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");

        // Connect buttons
        button1.setActionCommand("button1_clicked");
        button1.addActionListener(this);

        button2.setActionCommand("button2_clicked");
        button2.addActionListener(this);

        button3.setActionCommand("button3_clicked");
        button3.addActionListener(this);

        button4.setActionCommand("button4_clicked");
        button4.addActionListener(this);

        button5.setActionCommand("button5_clicked");
        button5.addActionListener(this);

        button6.setActionCommand("button6_clicked");
        button6.addActionListener(this);

        button7.setActionCommand("button7_clicked");
        button7.addActionListener(this);

        button8.setActionCommand("button8_clicked");
        button8.addActionListener(this);

        button9.setActionCommand("button9_clicked");
        button9.addActionListener(this);

        // Adding components
        pane.add(label1);
        pane.add(label2);
        pane.add(label3);

        pane.add(button1);
        pane.add(button2);
        pane.add(button3);
        pane.add(button4);
        pane.add(button5);
        pane.add(button6);
        pane.add(button7);
        pane.add(button8);
        pane.add(button9);

        this.setContentPane(pane);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TicTacToe::new);
    }
}
