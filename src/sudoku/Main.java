package sudoku;

public class Main {
    public static void main(String[] args) {

        Sudoku s = new Sudoku();

        Board evilBoard = BoardExamples.evil();
        Board emptyBoard = BoardExamples.empty();
        Board unsolveable = BoardExamples.unsolvable1();

        Board chosenBoard = unsolveable;

        s.printBoard(chosenBoard);

        if(s.solve(chosenBoard)){
            s.printBoard(chosenBoard);
        }else{
            System.out.println("NONE!");
        }
    }
}
