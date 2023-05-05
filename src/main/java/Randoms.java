import java.util.Iterator;
import java.util.Random;

public class Randoms implements Iterable<Integer> {
    protected Random random;
    protected int min;
    protected int max;

    public Randoms(int min, int max) {
        this.min = min;
        this.max = max;
        this.random = new Random();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<Integer> {

        @Override
        public boolean hasNext() {
            //так как нам необходим бесконечный поток рандомных чисел, пока сами не прекратим
            return true;
        }

        @Override
        public Integer next() {
            //e.g (100 - 90 + 1) -> рандомные числа от 0 до 11(не включая 11) ->
            // + 90 для того что бы получилось от 90 до 101(не включая 101)
            return random.nextInt(max - min + 1) + min;
        }
    }
}
