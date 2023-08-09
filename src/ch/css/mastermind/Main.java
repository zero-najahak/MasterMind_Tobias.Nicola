package ch.css.mastermind;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("hallo");

        //variabeln definieren
        boolean run = false;
        boolean wait = true;
        int samecolour = 0;
        boolean numbergenerator = true;
        int richtigePosition = 0;

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


            if (random1 == random2){
                ++samecolour;
            }

            if (random1 == random3){
                ++samecolour;
            }
            if (random1 == random4){
                ++samecolour;
            }
            if (random2 == random3){
                ++samecolour;
            }
            if (random2 == random4){
                ++samecolour;
            }
            if (random3 == random4){
                ++samecolour;
            }
            if (samecolour<3){
                numbergenerator = true;

            }
            if (samecolour>2){
                numbergenerator = false;

            }



        }while(numbergenerator == false);








        // start i und s

        System.out.println("Drücke i für infos und s zum starten");

        Scanner input = new Scanner(System.in);


        String key = input.nextLine();


        while (wait) {

            if (key.equals("s")) {
                run = true;
                wait = false;

            }

            if (key.equals("i")) {
                System.out.println("Schreibe alles klein. Drücke s zum fortfahren ");



                }

            key = input.nextLine();
            if (key.equals("s")) {
                    run = true;
                    wait = false;

                }





            while (run) {


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



                if (Guess1 == random1){

                }




            }


        }






    }
}
