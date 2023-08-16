package ch.css.mastermind;

import java.util.Objects;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        boolean wiederholen;
        boolean run;
        boolean wait;
        int samecolour;
        boolean numbergenerator;
        boolean korrekteeingabe;
        int richtigePosition = 0;
        int Rundenzaehler = 1;
        boolean kompletterunde = false;


        do {

            ArrayList<String> Position = new ArrayList<>();


            ArrayList<String> Colour = new ArrayList<>();
            Colour.add("blau");
            Colour.add("gelb");
            Colour.add("rot");
            Colour.add("pink");
            Colour.add("grün");
            Colour.add("violett");
            Colour.add("weiss");
            Colour.add("schwarz");

            ArrayList<String> NewPosition;
            ArrayList<String> Guess = new ArrayList<>();
            wiederholen = false;
            wait = true;
            numbergenerator = true;
            do {
                Random rand = new Random();
                int upperbound = 8;

                ArrayList<Integer> random = new ArrayList<>();


                for (int i = 0; i < 4; i++) {
                    int randomNumber = rand.nextInt(upperbound);
                    samecolour = (int) random.stream()
                            .filter(number -> number == randomNumber)
                            .count();
                    if ( samecolour>= 2){
                        i--;
                        continue;
                    }
                    random.add(randomNumber);
                }

                for (int i = 0; i < 4; i++) {
                    Position.add(Colour.get(random.get(i)));
                }
                if (Position.size() == 4) {
                    numbergenerator = false;
                }

            } while (numbergenerator);


            // start i und s

            Scanner input = new Scanner(System.in);

            if (Rundenzaehler < 2 && !kompletterunde){
                System.out.println("Drücke s für Start ");
                System.out.println("Drücke i für Info");
            }
            System.out.println(Position);

            run = true;
            wait = true;


            while (run) {

                while (wait && Rundenzaehler < 2 && !kompletterunde) {

                    String key = input.nextLine();

                    if (key.equals("s")) {

                        wait = false;

                    }else if (key.equals("i")) {
                        System.out.println("Drücke i für infos und s zum starten");
                        System.out.println("Es werden 12 Spielrundenen gespielt, jede Runde hast du 4 Versuche.");
                        System.out.println("Du musst die richtige Farbe und die richtige Position erraten, wenn die Position stimmt wird die richtige Farbe nicht noch einmal angegeben.");
                        System.out.println("Zu verfügung stehen die Farben: gelb, blau, pink, rot, schwarz, weiss, violett und grün.");
                        System.out.println("Der Code ist völlig Random und besteht aus vier verschiedene Farben, es kannen auch eine Farbe doppelt vorkommen.");
                        System.out.println("Mit s kannst du das Spiel starten.");


                    }else{
                        System.out.println("Diese taste hat keine Funktion");
                        System.out.println("Drüche s für Start ");
                        System.out.println("Drücke i für Info");
                    }
                }

                for (int i = 0; i < 4; i++) {
                    korrekteeingabe = false;
                    while (!korrekteeingabe) {
                        System.out.println(i + 1 + ". Versuch");
                        String in = input.nextLine().trim().toLowerCase();
                        if (Colour.contains(in)) {
                            korrekteeingabe = true;
                            Guess.add(in);
                            System.out.println("Bekannte farbe");
                        } else {
                            System.out.println("falsche Eingabe");
                            korrekteeingabe = false;
                        }

                    }
                }

                NewPosition = new ArrayList<>(Position);


                for (int i = 0; i < 4; i++) {
                    if (Guess.get(i).equals(NewPosition.get(i))) {
                        ++richtigePosition;
                        NewPosition.set(i, "nothing");
                    }
                }
                int fall = 0;


                for (int i = 0; i < 4; ++i) {
                    for (int d = 0; d < 4; ++d) {
                        if (Guess.get(i).equals(NewPosition.get(d))) {
                            ++fall;
                            NewPosition.set(d, "no");
                        }
                    }
                }


                System.out.println("Anzahl richtige Farben:" + (fall));
                System.out.println("Anzahl richtige Positionen: " + richtigePosition);
                System.out.println("Anzahl Runden Gespielt: " + Rundenzaehler);
                ++Rundenzaehler;

                while(Guess.size() > 0) {
                    Guess.remove(0);
                }
                wait = false;

                if (richtigePosition == 4) {
                    System.out.println("Du hast Gewonnen, Glückwunsch :)");
                    wait = true;
                }

                if (Rundenzaehler == 13) {
                    System.out.println("Du hast Verloren :(");
                    wait = true;
                }

                while (wait) {
                    System.out.println("drücke n für noch eine Runde und e zum beenden");
                    String key = input.nextLine().trim().toLowerCase();;

                    if (key.equals("e")) {
                        run = false;
                        wait = false;
                        wiederholen = false;

                    }else if (key.equals("n")) {

                        run = false;
                        wait = false;;
                        wiederholen = true;
                        Rundenzaehler = 1;
                        kompletterunde=true;
                    }else {
                        System.out.println("Diese Taste hat keine Funktion");
                    }
                }
                richtigePosition = 0;
            }


        } while (wiederholen);

    }
}
