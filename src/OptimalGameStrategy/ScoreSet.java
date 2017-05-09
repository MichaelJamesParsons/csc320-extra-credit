package OptimalGameStrategy;

public class ScoreSet {
    private int firstMove;
    private int secondMove;

    public ScoreSet(int f, int s) {
        firstMove = f;
        secondMove = s;
    }

    public int getFirstMove() {
        return firstMove;
    }

    public void setFirstMove(int firstMove) {
        this.firstMove = firstMove;
    }

    public int getSecondMove() {
        return secondMove;
    }

    public void setSecondMove(int secondMove) {
        this.secondMove = secondMove;
    }
}
