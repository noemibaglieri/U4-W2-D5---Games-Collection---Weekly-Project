package noemibaglieri.entities;
import java.util.*;
import java.util.stream.Collectors;

public class Collection {

    private List<Game> list;

    public Collection() {
        this.list = new ArrayList<>();
    }

    public void add(Game item) {

        final List<Game> gamesFound = list.stream().filter(game -> game.getId() == item.getId()).toList();

        if(gamesFound.isEmpty()) {
            list.add(item);
        } else {
            System.out.println("This item is already part of the collection");
        }

    }

    public Optional<Game> searchById (int id) {

        final List<Game> gamesFound = list.stream().filter(game -> game.getId() == id).toList();

        if(gamesFound.isEmpty()) {
            System.out.println("Item not available");
            return Optional.empty();
        } else {
            return Optional.of(gamesFound.getFirst());
        }

    }

     public List<Game> searchByPrice (double price) {
         return list.stream().filter(game -> game.getPrice() < price).toList();
    }

    public List<Boardgame> searchByNumberOfPlayers(int numberOfPlayers) {
        return list.stream()
                .filter(game -> game instanceof Boardgame)
                .map(game -> (Boardgame) game)
                .filter(boardgame -> boardgame.getNumberOfPlayers() == numberOfPlayers)
                .collect(Collectors.toList());
    }

    public void updateById(int id, Game updatedGame) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.set(i, updatedGame);
                System.out.println("Game updated successfully.");
                return;
            }
        }
        System.out.println("Game with ID " + id + " not found.");
    }

    public void removeItemById (int id) {

        Iterator<Game> iterator = list.iterator();
        while (iterator.hasNext()) {
            Game item = iterator.next();
            if (id == item.getId()) iterator.remove();

        }
    }

    public void printStatistics() {
        long numVideogames = list.stream()
                .filter(game -> game instanceof noemibaglieri.entities.Videogame)
                .count();

        long numBoardgames = list.stream()
                .filter(game -> game instanceof noemibaglieri.entities.Boardgame)
                .count();

        Optional<Game> mostExpensive = list.stream()
                .max(Comparator.comparingDouble(Game::getPrice));

        double averagePrice = list.stream()
                .mapToDouble(Game::getPrice)
                .average()
                .orElse(0.0);

        System.out.println("Collection stats:");
        System.out.println("All videogames: " + numVideogames);
        System.out.println("All boardgames " + numBoardgames);

        if (mostExpensive.isPresent()) {
            System.out.println("Highest price game: " + mostExpensive.get());
        } else {
            System.out.println("There are no games in this collection");
        }

        System.out.println("Average game price: " + averagePrice + "€");
    }




    @Override
    public String toString() {
        return "Collection{" + list +
                '}';
    }



}
