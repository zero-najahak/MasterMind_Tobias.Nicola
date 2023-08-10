package ch.css.mastermind;

import java.util.Objects;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("hallo");

        //variabeln definieren
        boolean run = true;
        boolean wait = true;
        int samecolour = 0;
        boolean numbergenerator = true;
        int richtigePosition = 0;
        int Farbe=0;
        int Rundenzaehler = 1;

        String position1 = "blau";
        String position2 = "blau";
        String position3 = "blau";
        String position4 = "blau";





        //farbzuweisung

        ArrayList<String> Colour = new ArrayList<String>();
        Colour.add("blau");
        Colour.add("gelb");
        Colour.add("rot");
        Colour.add("pink");
        Colour.add("gruen");
        Colour.add("violett");
        Colour.add("weiss");
        Colour.add("schwarz");


        int random1 = 0;
        int random2 = 0;
        int random3 = 0;
        int random4 = 0;

        //farbenkombination erstellen
        do {
            Random rand = new Random();
            // Setting the upper bound to generate the
            // random numbers in specific range
            int upperbound = 8;
            // Generating random values from 0 - 8
            // using nextInt()

            random1 = rand.nextInt(upperbound);
            random2 = rand.nextInt(upperbound);
            random3 = rand.nextInt(upperbound);
            random4 = rand.nextInt(upperbound);
            //random zahl

            System.out.println(random1);
            System.out.println(random2);
            System.out.println(random3);
            System.out.println(random4);


            //zahlen zu farben umwandeln
            System.out.println(Colour.get(random1));
            System.out.println(Colour.get(random2));
            System.out.println(Colour.get(random3));
            System.out.println(Colour.get(random4));

            position1 = (Colour.get(random1));
            position2 = (Colour.get(random2));
            position3 = (Colour.get(random3));
            position4 = (Colour.get(random4));





            if (random1 == random2) {
                ++samecolour;
            }

            if (random1 == random3) {
                ++samecolour;
            }
            if (random1 == random4) {
                ++samecolour;
            }
            if (random2 == random3) {
                ++samecolour;
            }
            if (random2 == random4) {
                ++samecolour;
            }
            if (random3 == random4) {
                ++samecolour;
            }
            if (samecolour < 3) {
                numbergenerator = true;

            }
            if (samecolour > 2) {
                numbergenerator = false;

            }


        } while (!numbergenerator);


        // start i und s
        System.out.println("Es werden 12 Spielrundenen gespielt, jede Runde hast du 4 guesses.");
        System.out.println("Du musst die richtige Farbe und die richtige Position erraten, wenn die Position stimmt wird die richtige Farbe nicht noch einmal angegeben.");
        System.out.println("Zu verfügung stehen die Farben: gelb, blau, pink, rot,schwarz, weiss, violett und gruen.");
        System.out.println("Der Code ist völlig Random und besteht aus Vier verschiedene Farben, es kannen auch eine Farbe doppelt vorkommen.");
        System.out.println("Mit s kannst du das Spiel starten.");

        Scanner input = new Scanner(System.in);












            while (run) {

                while (wait) {
                    String key = input.nextLine();
                    System.out.println(key);

                    if (key.equals("s")) {

                        wait = false;

                    }

                    if (key.equals("i")) {
                        System.out.println("Es werden 12 ");


                    }
                }

                String newposition1 = "nothing";
                String newposition2 = "nothing";
                String newposition3 = "nothing";
                String newposition4 = "nothing";


                System.out.println("1. Versuch");
                String Guess1 = input.nextLine();
                System.out.println(Guess1);

                System.out.println("2. Versuch");
                String Guess2 = input.nextLine();
                System.out.println(Guess2);

                System.out.println("3. Versuch");
                String Guess3 = input.nextLine();
                System.out.println(Guess3);

                System.out.println("4. Versuch");
                String Guess4 = input.nextLine();
                System.out.println(Guess4);


                //update zu urspünglichen farbe
                newposition1 = position1;
                newposition2 = position2;
                newposition3 = position3;
                newposition4 = position4;


                if (Guess1.equals(newposition1)) {
                    ++richtigePosition;
                    newposition1 = "nothing";
                }
                if (Guess2.equals(newposition2)) {
                    ++richtigePosition;
                    newposition2 = "nothing";
                }
                if (Guess3.equals(newposition3)) {
                    ++richtigePosition;
                    newposition3 = "nothing";
                }
                if (Guess4.equals(newposition4)) {
                    ++richtigePosition;
                    newposition4 = "nothing";
                }

                // Richtige Farben vergeichen


                int fall = 0;

                if (newposition2.equals(Guess1)) {
                    ++fall;
                    newposition2 = "nothing";
                }
                if (newposition3.equals(Guess1)) {
                    ++fall;
                    newposition3 = "nothing";

                }
                if (newposition1.equals(Guess1)) {
                    ++fall;
                    newposition1 = "nothing";


                }
                if (newposition4.equals(Guess1)) {
                    ++fall;
                    newposition4 = "nothing";

                }
                if (newposition1.equals(Guess2)) {
                    ++fall;
                    newposition1 = "nothing";

                }
                if (newposition2.equals(Guess2)) {
                    ++fall;
                    newposition2 = "nothing";

                }
                if (newposition3.equals(Guess2)) {
                    ++fall;
                    newposition3 = "nothing";

                }
                if (newposition4.equals(Guess2)) {
                    ++fall;
                    newposition4 = "nothing";

                }
                if (newposition1.equals(Guess3)) {
                    ++fall;
                    newposition1 = "nothing";

                }
                if (newposition2.equals(Guess3)) {
                    ++fall;
                    newposition2 = "nothing";

                }
                if (newposition3.equals(Guess3)) {
                    ++fall;
                    newposition3 = "nothing";

                }
                if (newposition4.equals(Guess3)) {
                    ++fall;
                    newposition4 = "nothing";

                }
                if (newposition1.equals(Guess4)) {
                    ++fall;
                    newposition1 = "nothing";

                }
                if (newposition2.equals(Guess4)) {
                    ++fall;
                    newposition2 = "nothing";

                }
                if (newposition3.equals(Guess4)) {
                    ++fall;
                    newposition3 = "nothing";

                }
                if (newposition4.equals(Guess4)) {
                    ++fall;
                    newposition4 = "nothing";

                }
















                System.out.println("Anzahl richtige Farben:" + (fall - richtigePosition));
                System.out.println("Anzahl richtige Positionen: " + richtigePosition);
                System.out.println("Anzahl Runden Gespielt: " + Rundenzaehler);
                ++Rundenzaehler;

                if (richtigePosition == 4) {
                    run = false;
                    System.out.println("Du hast Gewonnen, Glückwunsch");
                }

                if (Rundenzaehler == 13) {
                    run = false;
                    System.out.println("Du hast Verloren :(");
                }

                richtigePosition = 0;




            }
    }
}


