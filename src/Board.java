import java.util.ArrayList;

public class Board {
    Board parent = null;
    char[][] state = new char[3][3];
    ArrayList<Board> children;

    Board(){}
    Board(char[][] givenState){
        copyState(givenState);
    }
    Board(Board setParent, char[][] givenState){
        parent = setParent;
        copyState(givenState);
    }

    void copyState(char[][] setState){
        for(int i = 0; i < setState[0].length; i++){
            for(int j = 0; j < setState[i].length; j++){
                state[i][j] = setState[i][j];
            }
        }
    }

    void printState(){
        System.out.println(state[0][0]+" | "+state[0][1]+" | "+state[0][2]);
        System.out.println("---------");
        System.out.println(state[1][0]+" | "+state[1][1]+" | "+state[1][2]);
        System.out.println("---------");
        System.out.println(state[2][0]+" | "+state[2][1]+" | "+state[2][2]);
    }

    void init(){
        state[0][0] = '1'; state[0][1] = '2'; state[0][2] = '3';
        state[1][0] = '4'; state[1][1] = '5'; state[1][2] = '6';
        state[2][0] = '7'; state[2][1] = '8'; state[2][2] = '9';
    }

    int win(){
        if(     (state[0][0] == 'x' && state[0][1] == 'x' && state[0][2] == 'x') ||
                (state[1][0] == 'x' && state[1][1] == 'x' && state[1][2] == 'x') ||
                (state[2][0] == 'x' && state[2][1] == 'x' && state[2][2] == 'x') ||
                (state[0][0] == 'x' && state[1][0] == 'x' && state[2][0] == 'x') ||
                (state[0][1] == 'x' && state[1][1] == 'x' && state[2][1] == 'x') ||
                (state[0][2] == 'x' && state[1][2] == 'x' && state[2][2] == 'x') ||
                (state[0][0] == 'x' && state[1][1] == 'x' && state[2][2] == 'x') ||
                (state[2][0] == 'x' && state[1][1] == 'x' && state[0][2] == 'x')
        )
            return 1;
        if(     (state[0][0] == 'o' && state[0][1] == 'o' && state[0][2] == 'o') ||
                (state[1][0] == 'o' && state[1][1] == 'o' && state[1][2] == 'o') ||
                (state[2][0] == 'o' && state[2][1] == 'o' && state[2][2] == 'o') ||
                (state[0][0] == 'o' && state[1][0] == 'o' && state[2][0] == 'o') ||
                (state[0][1] == 'o' && state[1][1] == 'o' && state[2][1] == 'o') ||
                (state[0][2] == 'o' && state[1][2] == 'o' && state[2][2] == 'o') ||
                (state[0][0] == 'o' && state[1][1] == 'o' && state[2][2] == 'o') ||
                (state[2][0] == 'o' && state[1][1] == 'o' && state[0][2] == 'o')
        )
            return -1;

        return 0;

    }

    boolean filled(){
        for(int i = 0; i < state[0].length; i++){
            for(int j = 0; j < state[i].length; j++){
                if(state[i][j] != 'x' && state[i][j] != 'o')
                    return false;
            }
        }
        return true;
    }

    boolean validMove(char check){
        for(int i = 0; i < state[0].length; i++){
            for(int j = 0; j < state[i].length; j++){
                if(state[i][j] == check)
                    return true;
            }
        }
        return false;
    }

    void playMove(char location){
        for(int i = 0; i < state[0].length; i++){
            for(int j = 0; j < state[i].length; j++){
                if(state[i][j] == location)
                    state[i][j] = 'x';
            }
        }
    }

    void genChildren(boolean maxPlayer){
        children = new ArrayList<Board>();

        for(int i = 0; i < state[0].length; i++){
            for(int j = 0; j < state[i].length; j++){
                if(state[i][j] != 'o' && state[i][j] != 'x'){
                    Board child = new Board(this, this.state);
                    if(maxPlayer == true){
                        child.state[i][j] = 'x';
                    } else {
                        child.state[i][j] = 'o';
                    }
                    children.add(child);
                }
            }
        }
    }
}
