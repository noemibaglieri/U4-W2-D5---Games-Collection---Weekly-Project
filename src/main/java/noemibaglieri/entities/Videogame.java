package noemibaglieri.entities;

import noemibaglieri.enums.Genre;

public class Videogame extends Game {
    private String platform;
    private int playingTimeInHours;
    private Genre genre;

    public Videogame(int id, String title, int yearOfPublication, double price, String platform, int playingTimeInHours, Genre genre) {
        super(id, title, yearOfPublication, price);
        this.platform = platform;
        this.playingTimeInHours = playingTimeInHours;
        this.genre = genre;
    }


    @Override
    public String toString() {
        return "Videogame{" +
                "title='" + title + '\'' +
                ", year of publication='" + yearOfPublication + '\'' +
                ", price=" + price +
                ", platform='" + platform + '\'' +
                ", playing time='" + playingTimeInHours + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
