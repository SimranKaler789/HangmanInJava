package HangmanInJava;

import java.io.*;
import java.util.*;
public class hangman {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList words = new ArrayList<String>();
        // Reading the words from file
        File myfile = new File("file.txt");
        Scanner kb = new Scanner(myfile);
        Scanner sb = new Scanner(System.in);

        // Storing the words from file into arraylist
        while (kb.hasNextLine()) {
            String data = kb.nextLine().toUpperCase();
            words.add(data);
        }

        // Randomly take a word from the list
        String randomWord = getRandomWord(words);
        System.out.println(randomWord);

        //initaializing the array of type char for the random word 
        char[] ch = new char[randomWord.length()];
        
        System.out.println("******Welcome to HANGMAN******");
      
        // Asigning the even indeces to "_" & odd showing the letters
        int sizeOfWord = randomWord.length();
        for (int i = 0; i < sizeOfWord; i++) {
            char c = randomWord.charAt(i);
            if (i % 2 == 1) {
                 ch[i] = c;
            }
            else {
                 ch[i] ='_';
            }

        }
        
        // Printing the half of the word to guess which we stored in an array
        for ( char var : ch) 
            { 
               System.out.print(var);
            }

        
        // Ask the user to write guess letters &give him the same chance as that of the length of the Word tp guess using while loop
        int chances = randomWord.length();
        int correctGuess=0;
        int l=ch.length-(ch.length/2);
       
        while (chances > 0) {
            
            System.out.println("");
            System.out.println("Chances: " + chances);
            System.out.println("Enter letter to guess: ");
            char s = sb.next().charAt(0);
        if(correctGuess!=l){
            for (int j = 0; j < sizeOfWord; j++) {
                char ca = randomWord.charAt(j);
                if (j % 2 == 0) {
                    if (s == ca) {
                     //correctGuess++;
                     ch[j]=s;
                     for ( char var2 : ch) 
                     { 
                         System.out.print(var2);
                     }
                     //correctGuess++;
                    }
                    correctGuess++;
                }
            }
                chances--;
              

            
        } 
            else{
                chances=0;
                for ( char var2 : ch) 
                { 
                    System.out.print(var2);
                }
                System.out.println("");
                System.out.println("Yeah! You Win!!!");
            }  
            
        }
    }
    public static String getRandomWord(ArrayList<String> words) {
        Random rand = new Random();
        String ranWord = words.get(rand.nextInt(words.size()));
        return ranWord;
    }
}
