import java.util.Scanner;

public class Game {


    public static void main(String[] args){
        Board board = new Board();
        board.init();

        Scanner in = new Scanner(System.in);
        System.out.println("Let's play tic tac toe. Where would you like to move");
        System.out.println("Press one of the numbers showing on the board and hit enter.");
        board.printState();
        char move = in.next().charAt(0);
        while(!board.validMove(move)){
            System.out.println("I'm sorry that move seems invalid try again");
            move = in.next().charAt(0);
        }
        board.playMove(move);
        AgentOperations agent = new AgentOperations();
        agent.minimax(board, false, true);
        board = agent.nextMove;
        while(board.win() != 1 && board.win() != -1 && !(board.win() == 0 && board.filled()) ){
            board.printState();
            System.out.println("Play another move:");
            move = in.next().charAt(0);
            while(!board.validMove(move)){
                System.out.println("I'm sorry that move seems invalid try again");
                move = in.next().charAt(0);
            }
            board.playMove(move);
            agent.minimax(board, false, true);
            board = agent.nextMove;
        }
        System.out.println("\nThe final state is!");
        board.printState();
        if(board.win() == 1)
            System.out.println("You Won!"); //This will never happen HAHAHA!!!
        else if(board.win() == -1)
            System.out.println("You Lost....");
        else
            System.out.println("No one won.");
    }
}
