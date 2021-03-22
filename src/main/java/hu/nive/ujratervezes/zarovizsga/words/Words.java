package hu.nive.ujratervezes.zarovizsga.words;

public class Words {

    public boolean hasMoreDigits(String s) {
        if (s == null) {
            throw new IllegalArgumentException("The word cannot be null");
        }
        int counter =0;
        for (char c : s.toCharArray()) {
            counter += Character.isDigit(c) ? 1 : -1;
        }
        return counter>0;
    }

}

//A Words osztálynak legyen egy boolean hasMoreDigits(String s) metódusa, mely visszaadja, hogy a szóvan több számjegy
// van-e, mint többi karakter. Azaz a aa111 szóban három számjegy van és kettő többi, azaz true értéket ad vissza.