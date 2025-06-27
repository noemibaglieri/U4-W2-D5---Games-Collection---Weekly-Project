package noemibaglieri;

import noemibaglieri.entities.Boardgame;
import noemibaglieri.entities.Collection;
import noemibaglieri.entities.Videogame;
import noemibaglieri.enums.Genre;

public class Application {

    public static void main(String[] args) {

        Collection listOfAllGames = new Collection();

        Videogame leagueOfLegends = new Videogame(2, "League of Legends", 2009, 50.00, "PC", 999, Genre.MOBA);
        Videogame overwatch = new Videogame(5, "Overwatch", 2016, 39.99, "PC", 300, Genre.FPS);
        Videogame callOfDuty = new Videogame(8, "Call of Duty: Modern Warfare III", 2023, 69.99, "PlayStation", 120, Genre.FPS);
        Videogame theLastOfUs = new Videogame(6, "The Last of Us Part I", 2013, 49.99, "PlayStation", 25, Genre.ADVENTURE);
        Videogame fantasyLife = new Videogame(89, "Fantasy Life i: The Girl Who Steals Time", 2024, 59.99, "Nintendo Switch", 40, Genre.ADVENTURE);

        Boardgame monopoly = new Boardgame(39, "Monopoly", 1935, 19.99, 2, 90);
        Boardgame risiko = new Boardgame(48, "Risk", 1957, 29.99, 6, 120);
        Boardgame uno = new Boardgame(49, "UNO", 1971, 9.99, 4, 20);
        Boardgame cluedo = new Boardgame(50, "Cluedo", 1949, 24.99, 6, 45);
        Boardgame scarabeo = new Boardgame(51, "Scrabble", 1938, 19.99, 4, 60);

        // adding videogames
        listOfAllGames.add(leagueOfLegends);
        listOfAllGames.add(overwatch);
        listOfAllGames.add(callOfDuty);
        listOfAllGames.add(theLastOfUs);
        listOfAllGames.add(fantasyLife);

        // adding boardgames
        listOfAllGames.add(monopoly);
        listOfAllGames.add(risiko);
        listOfAllGames.add(uno);
        listOfAllGames.add(cluedo);
        listOfAllGames.add(scarabeo);

        System.out.println(listOfAllGames);

        listOfAllGames.searchById(89);
        System.out.println("Items found: " + listOfAllGames.searchByPrice(39));
        listOfAllGames.removeItemById(2);
        System.out.println(listOfAllGames);
        listOfAllGames.removeItemById(32245342);

        listOfAllGames.printStatistics();
    }
}
