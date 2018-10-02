import org.junit.Test;

import java.util.Scanner;

public class testing {

    @Test
    public void boardTest(){
        Board board = new Board();
        board.init();
        board.printState();
        Board testboard = new Board();
        testboard.copyState(board.state);
        testboard.printState();
    }

    @Test
    public void checkValidMove(){
        Board board = new Board();
        board.init();
        board.printState();
        System.out.println(board.validMove('5'));
    }

    @Test
    public void nextMoveCheck(){
        Board board = new Board();
        board.init();

        Scanner in = new Scanner(System.in);
        System.out.println("Let's play tic tac toe. Where would you like to move");
        System.out.println("Press one of the numbers showing on the board and hit enter.");
        board.printState();
        char move = in.next().charAt(0);
        while(!board.validMove(move)){
            System.out.println("I'm sorry that move seems invalud try again");
            move = in.next().charAt(0);
        }
        board.playMove(move);
        board.printState();

        AgentOperations agent = new AgentOperations();
        agent.minimax(board, false, true);
        agent.nextMove.printState();
    }


}
