package noemibaglieri;

import noemibaglieri.entities.Boardgame;
import noemibaglieri.entities.Collection;
import noemibaglieri.entities.Videogame;
import noemibaglieri.enums.Genre;

public class Application {

    public static void main(String[] args) {

        Collection listOfAllGames = new Collection();

        Videogame leagueOfLegends = new Videogame(2, "League of Legends", 2011, 30.99, "PC", 60, Genre.MOBA);
        Videogame overwatch = new Videogame(5,"Overwatch", 2011, 35.99, "PC", 60, Genre.FPS);
        Videogame callOfDuty = new Videogame(8, "Call of Duty", 2011, 32.99, "Playstation", 60, Genre.FPS);
        Videogame theLastOfUs = new Videogame(6,"The Last of Us", 2011, 39.99, "Playstation", 60, Genre.ADVENTURE);
        Videogame fantasyLife = new Videogame(89, "Fantasy Life", 2024, 60.99, "Nintendo Switch", 20, Genre.ADVENTURE);

        Boardgame monopoly = new Boardgame(39,"Monopoly",1890,21.99, 8, 190);

        listOfAllGames.add(leagueOfLegends);
        listOfAllGames.add(overwatch);
        listOfAllGames.add(callOfDuty);
        listOfAllGames.add(theLastOfUs);
        listOfAllGames.add(fantasyLife);

        listOfAllGames.add(monopoly);


        System.out.println(listOfAllGames);

        System.out.println(leagueOfLegends.getId());

        listOfAllGames.searchById(89);
        System.out.println(listOfAllGames.searchByPrice(39).size());
        listOfAllGames.removeItemById(2);
        System.out.println(listOfAllGames);
        listOfAllGames.removeItemById(32245342);
    }
}
