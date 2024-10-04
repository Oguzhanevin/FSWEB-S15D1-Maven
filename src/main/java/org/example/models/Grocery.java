package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {
    public static List<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose an option: 0 - Quit, 1 - Add items, 2 - Remove items");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 0:
                    System.out.println("Exiting application...");
                    return;
                case 1:
                    System.out.println("Enter items to add (comma-separated or single): ");
                    String addInput = scanner.nextLine();
                    addItems(addInput);
                    break;
                case 2:
                    System.out.println("Enter items to remove (comma-separated or single): ");
                    String removeInput = scanner.nextLine();
                    removeItems(removeInput);
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
            printSorted();
        }
    }

    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            item = item.trim(); // Remove extra spaces
            if (!checkItemIsInList(item)) {
                groceryList.add(item);
            } else {
                System.out.println(item + " is already in the list.");
            }
        }
        sortAndRemoveDuplicates();
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            item = item.trim(); // Remove extra spaces
            if (checkItemIsInList(item)) {
                groceryList.remove(item);
            } else {
                System.out.println(item + " is not in the list.");
            }
        }
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        System.out.println("Current sorted grocery list: " + groceryList);
    }

    private static void sortAndRemoveDuplicates() {
        // Sort the list in case-insensitive order
        groceryList.sort(String.CASE_INSENSITIVE_ORDER);

        // Remove duplicates
        List<String> uniqueList = new ArrayList<>();
        for (String item : groceryList) {
            if (!uniqueList.contains(item)) {
                uniqueList.add(item);
            }
        }

        groceryList.clear();
        groceryList.addAll(uniqueList);
    }
}
