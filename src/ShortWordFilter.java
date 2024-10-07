public class ShortWordFilter implements Filter<String> {

    @Override
    public boolean accept(String word) {
        return word.length() < 5;
    }
}
