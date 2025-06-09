import vocabulary.masteredWords;
import vocabulary.newWords;
import vocabulary.practiceWords;
import vocabulary.word;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class worddatabase {
    protected ArrayList<word> newwordsArrayList = new ArrayList<>(Arrays.asList(
            new newWords("database", "die Datenbank"),
            new newWords("Loop","die Schleife"),
            new newWords("User", "der Benutzer"),
            new newWords("file", "die Datei"),
            new newWords("keyboard", "die Tastatur")
    ));

    protected ArrayList<practiceWords> practicewordsArrayList = new ArrayList<>();
    protected ArrayList<word> masteredwordsArrayList = new ArrayList<>();

    protected Scanner input = new Scanner(System.in);

    public void run(){
        while (true){
            System.out.println("----------------------------------------------------------------");
            System.out.println("1. learn new words. 2. review words. 3. show current learning words. 4.see mastered words. 5.exit.");
            System.out.println("choose: ");
            int choice = parseInt(input.nextLine());
            switch (choice){
                case 1 -> learn();
                case 2 -> review();
                case 3 -> showcurrentlearningwords();
                case 4 -> showmastered();
                case 5 -> {
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
                practicewordsArrayList.add(new practiceWords(newwordsArrayList.getFirst().getEnglish(),newwordsArrayList.getFirst().getDeutsch(),0));
                System.out.println("Please choose: 1.next.  2. exit");
                int choice = parseInt(input.nextLine());
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
            System.out.println("English: "+practicewordsArrayList.getFirst().getEnglish()+"  0 for exit");
            String answer = input.nextLine();
            if(answer.equals("0")){
                return;
            }
            if(answer.equals(practicewordsArrayList.getFirst().getDeutsch())){
                System.out.println("correct!");
                practiceWords w = (practiceWords) practicewordsArrayList.getFirst();
                w.increaseCorrectTimes(1);
                if(w.getCorrectTimes()>3){
                    practicewordsArrayList.remove(0);
                    masteredwordsArrayList.add(new masteredWords(w.getEnglish(), w.getDeutsch()));
                    n--;
                }
                practicewordsArrayList.add(w);
                practicewordsArrayList.remove(0);
            }
            else{
                System.out.println("wrong! -->"+practicewordsArrayList.getFirst().getDeutsch());
                practiceWords transfer = (practiceWords) practicewordsArrayList.get(0);
                practicewordsArrayList.remove(0);
                practicewordsArrayList.add(transfer);
            }
        }

    }

    private void showcurrentlearningwords(){
        System.out.println("----------------------------------------------------------------");
        System.out.println("1.sort by proficiency. 2.sort by length");
        int choice = parseInt(input.nextLine());
        switch (choice){
            case 1 -> {
                practicewordsArrayList.sort((w1,w2)->Integer.compare(w1.getCorrectTimes(), w2.getCorrectTimes()));
                for(practiceWords pw: practicewordsArrayList){
                    System.out.println(pw);
                }

            }
            case 2 ->{
                practicewordsArrayList.sort((w1,w2)->Integer.compare(w1.getDeutsch().length(), w2.getDeutsch().length()));
                for(practiceWords pw: practicewordsArrayList){
                    System.out.println(pw);
                }
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
