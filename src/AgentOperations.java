public class AgentOperations {
    Board nextMove;

    int minimax(Board node, boolean maximizingPlayer, boolean initial){
        if(node.filled() || node.win() != 0){
            return node.win();
        }
        int check, bestVal;
        node.genChildren(maximizingPlayer);
        if(maximizingPlayer){
            bestVal = Integer.MIN_VALUE;
            for(Board child : node.children){
                check = minimax(child, false, false);
                if(check > bestVal){
                    bestVal = check;
                    if(initial)
                        nextMove = child;
                }
            }
        } else {
            bestVal = Integer.MAX_VALUE;
            for(Board child : node.children){
                check = minimax(child, true, false);
                if(check < bestVal){
                    bestVal = check;
                    if(initial)
                        nextMove = child;
                }
            }
        }
        return bestVal;
    }
}
