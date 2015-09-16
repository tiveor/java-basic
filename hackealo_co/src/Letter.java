/**
 * User: tiveor
 * Date: 9/16/15
 * Time: 14:32
 */
public class Letter implements Comparable {

    private int count;
    private char character;

    public Letter(char character) {
        this.count = 0;
        this.character = character;
    }

    public void inc() {
        this.count++;
    }

    public int getValue() {
        return character;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String toString() {
        return this.character + " => " + this.count;
    }

    @Override
    public int compareTo(Object o) {
        Letter l = ((Letter) o);

        if (l.getCount() == this.getCount()) {
            return ((Integer) this.getValue()).compareTo((Integer) l.getValue());

        } else {
            return ((Integer) l.getCount()).compareTo((Integer) this.getCount());
        }
    }
}
