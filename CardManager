import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Card {
    private String symbol;
    private String value;

    public Card(String symbol, String value) {
        this.symbol = symbol;
        this.value = value;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return symbol + " of " + value;
    }
}

public class CardManager {
    private List<Card> cards = new ArrayList<>();

    public void addCard(String symbol, String value) {
        cards.add(new Card(symbol, value));
    }

    public void findCardsBySymbol(String symbol) {
        for (Card card : cards) {
            if (card.getSymbol().equalsIgnoreCase(symbol)) {
                System.out.println(card);
            }
        }
    }

    public static void main(String[] args) {
        CardManager manager = new CardManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Card");
            System.out.println("2. Find Cards by Symbol");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter card symbol: ");
                String symbol = scanner.nextLine();
                System.out.print("Enter card value: ");
                String value = scanner.nextLine();
                manager.addCard(symbol, value);
            } else if (choice == 2) {
                System.out.print("Enter symbol to search: ");
                String searchSymbol = scanner.nextLine();
                manager.findCardsBySymbol(searchSymbol);
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
