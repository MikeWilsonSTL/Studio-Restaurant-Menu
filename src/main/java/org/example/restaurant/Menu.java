package org.example.restaurant;

import java.util.ArrayList;
import java.util.Date;

public class Menu {
//    public static ArrayList<MenuItem> menu = new ArrayList<>();
//    public ArrayList<MenuItem> newItems = new ArrayList<>();
//    public boolean categoryIsValid(String userInput){
//        return userInput.equals("Appetizer") || userInput.equals("Main Course") || userInput.equals("Dessert");
//    }
    public static Date updatedDate = new Date();
    public static void printMenu(ArrayList<MenuItem> menu){
        System.out.println("=========================================");
        System.out.println("               APPETIZERS                ");
        System.out.println("=========================================");
        for (MenuItem menuItem : menu) {
            if (menuItem.getCategory().equals("Appetizer")) {
                if(menuItem.isNew()){
                    System.out.print("NEW!!! ");
                }
                System.out.println(menuItem.getName() + ": " + menuItem.getDescription() + "\n"
                        + "$" + menuItem.getPrice());
            }
        }

        System.out.println("=========================================");
        System.out.println("              MAIN COURSES               ");
        System.out.println("=========================================");
        for (MenuItem menuItem : menu) {
            if (menuItem.getCategory().equals("Main Course")) {
                if(menuItem.isNew()){
                    System.out.print("NEW!!! ");
                }
                System.out.println(menuItem.getName() + ": " + menuItem.getDescription() + "\n"
                        + "$" + menuItem.getPrice());
            }
        }

        System.out.println("=========================================");
        System.out.println("                DESSERTS                 ");
        System.out.println("=========================================");
        for (MenuItem menuItem : menu) {
            if (menuItem.getCategory().equals("Dessert")) {
                if(menuItem.isNew()){
                    System.out.print("NEW!!! ");
                }
                System.out.println(menuItem.getName() + ": " + menuItem.getDescription() + "\n"
                        + "$" + menuItem.getPrice());
            }
        }
        System.out.println("\nUpdated on: " + updatedDate);

    }
}
