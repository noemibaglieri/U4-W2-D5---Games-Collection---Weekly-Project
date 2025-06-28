package noemibaglieri;

import noemibaglieri.entities.Boardgame;
import noemibaglieri.entities.Collection;
import noemibaglieri.entities.Game;
import noemibaglieri.entities.Videogame;
import noemibaglieri.enums.Genre;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Collection collection = new Collection();

        boolean running = true;

        while (running) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add game");
            System.out.println("2. Remove game");
            System.out.println("3. Search game by id");
            System.out.println("4. Search games based on price");
            System.out.println("5. Search boardgames for a specific number of players");
            System.out.println("6. Update game");
            System.out.println("7. Show stats");
            System.out.println("8. Show all games collection");
            System.out.println("0. Exit menu");
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Select type: Press 1 for Videogame, Press 2 for Boardgame: ");
                    int type = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Year of publication: ");
                    int year = scanner.nextInt();
                    System.out.print("Price: ");
                    double price = scanner.nextDouble();

                    if (type == 1) {
                        scanner.nextLine();
                        System.out.print("Platform: ");
                        String platform = scanner.nextLine();
                        System.out.print("Playing time in hours: ");
                        int time = scanner.nextInt();
                        System.out.print("Genere (MOBA, FPS, PLATFORM, ADVENTURE, PUZZLE, SURVIVAL): ");
                        scanner.nextLine();
                        String genreStr = scanner.nextLine().toUpperCase();
                        Genre genre = Genre.valueOf(genreStr);

                        collection.add(new Videogame(id, title, year, price, platform, time, genre));
                    } else if (type == 2) {
                        System.out.print("Number of players: ");
                        int players = scanner.nextInt();
                        System.out.print("Average playing time in minutes: ");
                        int duration = scanner.nextInt();

                        collection.add(new Boardgame(id, title, year, price, players, duration));
                    } else {
                        System.out.println("This type doesn't exist.");
                    }
                    break;

                case 2:
                    System.out.print("What game do you want to remove? Type in its id: ");
                    int idToRemove = scanner.nextInt();
                    collection.removeItemById(idToRemove);
                    break;

                case 3:
                    System.out.print("Search by game id: ");
                    int idToSearch = scanner.nextInt();
                    Optional<Game> found = collection.searchById(idToSearch);
                    found.ifPresent(System.out::println);
                    break;

                case 4:
                    System.out.print("Search by max price: ");
                    double maxPrice = scanner.nextDouble();
                    List<Game> cheapGames = collection.searchByPrice(maxPrice);
                    cheapGames.forEach(System.out::println);
                    break;

                case 5:
                    System.out.print("Search by number of players: ");
                    int numPlayers = scanner.nextInt();
                    List<Boardgame> matches = collection.searchByNumberOfPlayers(numPlayers);
                    matches.forEach(System.out::println);
                    break;

                case 6:
                    System.out.print("Update game by typing its id: ");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Year of publication: ");
                    int newYear = scanner.nextInt();
                    System.out.print("Price: ");
                    double newPrice = scanner.nextDouble();

                    scanner.nextLine();
                    System.out.print("Is this a videogame? Please, type yes or no");
                    String isVideo = scanner.nextLine();

                    Game updatedGame;
                    if (isVideo.equalsIgnoreCase("yes")) {
                        System.out.print("Platform: ");
                        String platform = scanner.nextLine();
                        System.out.print("Playing time in hours: ");
                        int time = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Genre (MOBA, FPS, PLATFORM, ADVENTURE, PUZZLE, SURVIVAL): ");
                        Genre genre = Genre.valueOf(scanner.nextLine().toUpperCase());

                        updatedGame = new Videogame(idToUpdate, newTitle, newYear, newPrice, platform, time, genre);
                    } else {
                        System.out.print("Number of players: ");
                        int players = scanner.nextInt();
                        System.out.print("Average playing time in minutes: ");
                        int duration = scanner.nextInt();

                        updatedGame = new Boardgame(idToUpdate, newTitle, newYear, newPrice, players, duration);
                    }

                    collection.updateById(idToUpdate, updatedGame);
                    break;

                case 7:
                    collection.printStatistics();
                    break;

                case 8:
                    System.out.println(collection);
                    break;

                case 0:
                    running = false;
                    break;

                default:
                    System.out.println("No menu item selected.");
            }


        }

        scanner.close();
    }
}
