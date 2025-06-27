package noemibaglieri.entities;

public class Boardgame extends Game {
    private int numberOfPlayers;
    private int averagePlayTimeInMinutes;

    public Boardgame(int id, String title, int yearOfPublication, double price, int numberOfPlayers, int averagePlayTimeInMinutes) {
        super(id, title, yearOfPublication, price);
        this.numberOfPlayers = numberOfPlayers;
        this.averagePlayTimeInMinutes = averagePlayTimeInMinutes;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public int getAveragePlayTimeInMinutes() {
        return averagePlayTimeInMinutes;
    }

    @Override
    public String toString() {
        return "Boardgame{" +
                "title='" + title + '\'' +
                ", year of publication='" + yearOfPublication + '\'' +
                ", price=" + price +
                ", number of players='" + numberOfPlayers + '\'' +
                ", average playing time in minutes='" + averagePlayTimeInMinutes + '\'' +
                '}';
    }
}
