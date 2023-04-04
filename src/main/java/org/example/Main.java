package org.example;
import org.example.restaurant.Menu;
import org.example.restaurant.MenuItem;
import java.util.ArrayList;
import static org.example.restaurant.Menu.printMenu;

public class Main {
    public static ArrayList<MenuItem> menu = new ArrayList<>();
//    public ArrayList<MenuItem> newItems = new ArrayList<>();

    public static void main(String[] args) {
        menu.add(new MenuItem("Wings", "Fried Wings", 9.45, "Appetizer", false));
        menu.add(new MenuItem("Ribs", "Smoked BBQ Ribs", 12.45, "Appetizer", false));
        menu.add(new MenuItem("Ropa Vieja", "Braised Flank Steak", 17.55, "Main Course", false));
        menu.add(new MenuItem("Cuban Paella", "Seafood Rice Dish", 22.55, "Main Course", false));
        menu.add(new MenuItem("Bread Pudding", "Rum Caramel Sauce", 7.45, "Dessert", true));
//        addMenuItem("test", "test", 0.00, "test", true);
        printMenu(menu);
    }
}