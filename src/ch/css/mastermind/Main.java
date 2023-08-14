package ch.css.mastermind;

import java.util.Objects;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //variabeln definieren
        boolean run = true;
        boolean wait = true;
        int samecolour = 0;
        boolean numbergenerator = true;
        boolean korrekteeingabe = false;
        boolean wiederholen = true;
        int richtigePosition = 0;
        int Rundenzaehler = 1;


        ArrayList<String> Position = new ArrayList<>();

        //farbzuweisung

        ArrayList<String> Colour = new ArrayList<>();
        Colour.add("blau");
        Colour.add("gelb");
        Colour.add("rot");
        Colour.add("pink");
        Colour.add("gruen");
        Colour.add("violett");
        Colour.add("weiss");
        Colour.add("schwarz");

        ArrayList<String> NewPosition = new ArrayList<>();
        ArrayList<String> Guess = new ArrayList<>();


        //farbenkombination erstellen
        do {
            wiederholen = false;
            wait = true;
            do {
                Random rand = new Random();
                // Setting the upper bound to generate the
                // random numbers in specific range
                int upperbound = 8;
                // Generating random values from 0 - 8
                // using nextInt()

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

                //random zahl
                for (int i = 0; i < 4; i++) {
                    System.out.println(random.get(i));
                }


                //zahlen zu farben umwandeln
                for (int i = 0; i < 4; i++) {
                    System.out.println(Colour.get(random.get(i)));
                }
                for (int i = 0; i < 4; i++) {
                    Position.add(Colour.get(random.get(i)));
                }
                if (Position.size() == 4) {
                    numbergenerator = false;
                }

                System.out.println(Position);

            } while (numbergenerator);


            // start i und s

            Scanner input = new Scanner(System.in);

            System.out.println("Drüche s für Start ");
            System.out.println("Drücke i für Info");
            run = true;
            wait = true;


            while (run) {

                while (wait) {

                    String key = input.nextLine();
                    System.out.println(key);

                    if (key.equals("s")) {

                        wait = false;

                    }

                    if (key.equals("i")) {
                        System.out.println("Drücke i für infos und s zum starten");
                        System.out.println("Es werden 12 Spielrundenen gespielt, jede Runde hast du 4 guesses.");
                        System.out.println("Du musst die richtige Farbe und die richtige Position erraten, wenn die Position stimmt wird die richtige Farbe nicht noch einmal angegeben.");
                        System.out.println("Zu verfügung stehen die Farben: gelb, blau, pink, rot,schwarz, weiss, violett und gruen.");
                        System.out.println("Der Code ist völlig Random und besteht aus Vier verschiedene Farben, es kannen auch eine Farbe doppelt vorkommen.");
                        System.out.println("Mit s kannst du das Spiel starten.");
                        System.out.println("Du darfts kein Leerschlag bei der Eingabe machen.");


                    }
                }

                for (int i = 0; i < 4; i++) {
                    korrekteeingabe = false;
                    while (!korrekteeingabe) {
                        System.out.println(i + 1 + ". Versuch");
                        String in = input.nextLine();
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











                    //update zu urspünglichen farbe
                    NewPosition = new ArrayList<>(Position);


                    for (int i = 0; i < 4; i++) {
                        System.out.println(NewPosition);
                        if (Guess.get(i).equals(NewPosition.get(i))) {
                            ++richtigePosition;
                            NewPosition.set(i, "nothing");
                        }

                    }
                    int fall = 0;
                    System.out.println("guess");
                    System.out.println(Guess);

                    for (int i = 0; i < 4; ++i) {
                        for (int d = 0; d < 4; ++d) {
                            if (Guess.get(i).equals(NewPosition.get(d))) {
                                ++fall;
                                System.out.println(richtigePosition);
                                NewPosition.set(d, "no");
                            }
                        }
                    }


                    // Richtige Farben vergeichen


                    System.out.println("Anzahl richtige Farben:" + ((fall) - (richtigePosition)));
                    System.out.println("Anzahl richtige Positionen: " + richtigePosition);
                    System.out.println("Anzahl Runden Gespielt: " + Rundenzaehler);
                    ++Rundenzaehler;

                    while(Guess.size() > 0) {
                    Guess.remove(0);
                    }

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
                    String key = input.nextLine();

                    if (key.equals("e")) {
                        run = false;
                        wait = false;
                        wiederholen = false;

                    }

                    if (key.equals("n")) {
                        wait = false;
                        Rundenzaehler = 1;
                        wiederholen = true;
                        run = false;
                        samecolour = 0;
                        numbergenerator = true;
                        korrekteeingabe = false;
                        richtigePosition = 0;
                        Rundenzaehler = 1;
                    }
                }
                richtigePosition = 0;
            }


        } while (wiederholen);

    }
}
