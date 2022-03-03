package com.company;

import java.util.Scanner;

public class Main {
    private static final int CONSTRUCT_ROCKET = 1;
    private static final int SHOW_LIST_ROCKETS = 2;
    private static final int ASSIGN_ROCKET = 3;
    private static final int ADD_TAKEOFF_PLATFORM_TO_HANGAR = 4;
    private static final int EXIT = 5;

    public static void main(String[] args) {
        try {
            Hangar hangar = constructNewHangar();
            TakeoffPlatform takeoffPlatform = constructNewTakeoffPlatform();
            menuOfManagementOfRockets(hangar,takeoffPlatform);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static TakeoffPlatform constructNewTakeoffPlatform() {
        String name = askNameOfTheNewTakeoffPlatform();
        return new TakeoffPlatform(name);
    }

    private static String askNameOfTheNewTakeoffPlatform() {
        System.out.println("What name have the new takeoff platform?");
        return new Scanner(System.in).nextLine();
    }

    private static void menuOfManagementOfRockets(Hangar hangar,TakeoffPlatform takeoffPlatform) throws Exception {
        int option;
        do {
            option = giveOption();
            switch (option) {
                case CONSTRUCT_ROCKET -> createRockets(hangar);
                case SHOW_LIST_ROCKETS -> showAllRockets(hangar);
                case ASSIGN_ROCKET -> asociateHangarToTakeOffPlatform(hangar,takeoffPlatform) ;
                case EXIT -> System.out.println("Exiting menu of rockets...");
                default -> System.out.println("Incorrect option");
            }
        }
        while (option != EXIT);

    }

    private static void asociateHangarToTakeOffPlatform(Hangar hangar, TakeoffPlatform takeoffPlatform) {
        hangar.addTakeOffPlatform(takeoffPlatform);
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
        return new Scanner(System.in).nextInt();
    }


    private static void options() {
        System.out.println(CONSTRUCT_ROCKET +" Create Rocket");
        System.out.println(SHOW_LIST_ROCKETS +" Show the list of rockets");
        System.out.println(ASSIGN_ROCKET +"Assign rocket to take off");
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
