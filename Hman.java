package hman;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Random;

public class Hman {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        String[] guesses = {"petar", "isusovci", "miskovic", "krofnica"};

        boolean igram = true;
        while (igram) {
            System.out.println("Dobrodosli");
            char[] randomWordToGuess = guesses[random.nextInt(guesses.length)].toCharArray();
            int amountOfMisses = randomWordToGuess.length;
            char[] playerGuess = new char[randomWordToGuess.length];

            for (int i = 0; i < playerGuess.length; i++) {
                playerGuess[i] = '_';
            }
            boolean wordIsGuessed = false;
            int tries = 0;

            while (!wordIsGuessed && tries != amountOfMisses) {
                System.out.println("Current guesses: ");
                printArray(playerGuess);
               
                    System.out.printf("You have %d tries left.\n", amountOfMisses-tries);
                
                System.out.println("Enter a single character");
                char input = scan.nextLine().charAt(0);
                tries++;

                if (input == '-') {
                    igram = false;
                    wordIsGuessed = true;
                } else {
                    boolean potrefio = false;
                    for (int i = 0; i < randomWordToGuess.length; i++) {
                        if (randomWordToGuess[i] == input) {
                            potrefio = true;
                            playerGuess[i] = input;
                        }
                    }
                    if (isTheWordGuessed(playerGuess)) {
                        wordIsGuessed = true;
                        System.out.println("Pobijedili ste !!!");
                    }
                    if(potrefio){
                        tries--;
                    }
                } 
                
            }
            
            if(!wordIsGuessed){
                    System.out.println("Potrosili ste sve pokusaje !!!");
                    System.out.println("Hocete li da pokusate ponovo? (da/ne)");
                    String anotherGame = scan.nextLine();
                    if(anotherGame.equals("no")){
                        igram = false;
                    }
                    System.out.println("GAME OVER");
                }
        }
    }

    public static void printArray(char[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf(array[i] + " ");
        }
        System.out.println();
    }
    
    public static boolean isTheWordGuessed(char[] array){
        for(int i = 0;i<array.length;i++){
            if(array[i]=='_'){
                return false;
            }
        }
        return true;
}    
}


