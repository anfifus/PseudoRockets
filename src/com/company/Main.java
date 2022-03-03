package com.company;

import java.util.Scanner;

public class Main {
    private static final int CONSTRUCT_ROCKET = 1;
    private static final int EXIT = 4;
    private static final int SHOW_LIST_ROCKETS = 2;
    public static void main(String[] args) {
        try {
            Hangar hangar = constructNewHangar();
            menuOfManagementOfRockets(hangar);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void menuOfManagementOfRockets(Hangar hangar) throws Exception {
        int option;
        do {
            option = giveOption();
            switch (option) {
                case CONSTRUCT_ROCKET -> createRockets(hangar);
                case SHOW_LIST_ROCKETS -> showAllRockets(hangar);
                case EXIT -> System.out.println("Exiting menu of rockets...");
                default -> giveOption();
            }
        }
        while (option != EXIT);

    }

    private static void showAllRockets(Hangar hangar) {
        System.out.println("This is the rockets in the hangar: \n"+hangar.showRockets());

    }

    private static void createRockets(Hangar hangar) throws Exception {
        String nameRocket = askNameOfTheRocket();
        hangar.createRocket(nameRocket);
    }

    private static String askNameOfTheRocket() {
        System.out.println("What name have the new rocket?");
        return new Scanner(System.in).nextLine();
    }

    private static int giveOption() {
        options();
        System.out.println("Write the option you want");
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();
        scan.nextLine();
        return option;
    }


    private static void options() {
        System.out.println(CONSTRUCT_ROCKET +" Create Rocket");
        System.out.println(SHOW_LIST_ROCKETS +" Show the list of rockets");
        System.out.println(EXIT +" exit of the menu");
    }

    private static Hangar constructNewHangar() throws Exception{
        String name = askNameOfTheNewHangar();
        return new Hangar(name);
    }

    private static String askNameOfTheNewHangar() {
        System.out.println("What name have the new hangar?");
        return new Scanner(System.in).nextLine();
    }
}
