import vocabulary.masteredWords;
import vocabulary.newWords;
import vocabulary.practiceWords;
import vocabulary.word;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class worddatabase {
    protected ArrayList<word> newwordsArrayList = new ArrayList<>(Arrays.asList(
            new newWords("database", "die Datenbank"),
            new newWords("Loop","die Schleife"),
            new newWords("User", "der Benutzer"),
            new newWords("file", "die Datei"),
            new newWords("keyboard", "die Tastatur")
    ));

    protected ArrayList<word> practicewordsArrayList = new ArrayList<>();
    protected ArrayList<word> masteredwordsArrayList = new ArrayList<>();

    protected Scanner input = new Scanner(System.in);

    public void run(){
        while (true){
            System.out.println("----------------------------------------------------------------");
            System.out.println("1. learn new words. 2. review words. 3.see mastered words. 4.exit.");
            System.out.println("choose: ");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice){
                case 1 -> learn();
                case 2 -> review();
                case 3 -> showmastered();
                case 4 -> {
                    System.out.println("Bye!💕💕");
                    return;
                }
            }

        }
    }

    private void learn(){
        System.out.println("----------------------------------------------------------------");
        int n = newwordsArrayList.size();
        while (n>0){
//                System.out.println("English: "+newwordsArrayList.getFirst().getEnglish()+" Deutsch: "+newwordsArrayList.getFirst().getDeutsch());
                System.out.println(newwordsArrayList.getFirst());
                practicewordsArrayList.add(new practiceWords(newwordsArrayList.getFirst().getEnglish(),newwordsArrayList.getFirst().getDeutsch()));
                System.out.println("Please choose: 1.next.  2. exit");
                int choice = Integer.parseInt(input.nextLine());
                switch (choice){
                    case 1 -> {
                        newwordsArrayList.remove(0);
                        n--;
                    }
                    case 2 -> {
                        return;
                    }
                }

        }
    }

    private void review(){
        System.out.println("----------------------------------------------------------------");
        int n = practicewordsArrayList.size();
        if(n==0){
            System.out.println("You have nothing to review.");
            return;
        }
        while (n>0){
            System.out.println("English: "+practicewordsArrayList.getFirst().getEnglish());
            String answer = input.nextLine();
            if(answer.equals(practicewordsArrayList.getFirst().getDeutsch())){
                System.out.println("correct!");
                masteredwordsArrayList.add(new masteredWords(practicewordsArrayList.getFirst().getEnglish(),practicewordsArrayList.getFirst().getDeutsch()));
                practicewordsArrayList.remove(0);
                n--;
            }
            else{
                System.out.println("wrong!");
                practiceWords transfer = (practiceWords) practicewordsArrayList.get(0);
                practicewordsArrayList.remove(0);
                practicewordsArrayList.add(transfer);
            }
        }

    }

    private void showmastered(){
        System.out.println("----------------------------------------------------------------");
        int n = masteredwordsArrayList.size();
        System.out.println("You have accumulated "+n+" IT vocabulary.");
        for(word mw: masteredwordsArrayList){
            System.out.println(mw);
        }
    }


}
