package in.baldui.shuffle;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class ShuffleCards {

    public static void main(String[] args) {
        List<Integer> deck = generateDeck();
        List<Integer> shuffled = new ArrayList<>();
        
        Random random = new Random();
        while(deck.size() > 0) {
            int pos = random.nextInt(deck.size());
            shuffled.add(deck.get(pos));
            deck.remove(pos);
        }

        System.out.println(shuffled);
    }

    private static List<Integer> generateDeck() {
        ArrayList<Integer> deck = new ArrayList<Integer>();
        for(int c = 0; c < 52; c++) {
            deck.add(c);
        }

        return deck;
    }
}
