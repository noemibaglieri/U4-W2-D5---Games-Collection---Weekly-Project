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

    public void removeItemById (int id) {

        Iterator<Game> iterator = list.iterator();
        while (iterator.hasNext()) {
            Game item = iterator.next();
            if (id == item.getId()) iterator.remove();

        }
    }

    

    @Override
    public String toString() {
        return "Collection{" + list +
                '}';
    }



}
