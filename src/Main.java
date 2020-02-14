import java.util.Random;

public class Main {


    public static void main(String[] args) {

        int a = 10; //do podawania liczby osobnikow

        double[] tab = new double[a];
        Random r = new Random();

//pętla przypisania losowych wartości do tablicy
        System.out.println("1. Losowe wartości w tablicy: ");
        for(int i = 0; i<tab.length; i++){
            tab[i] = r.nextInt(255)+1;
            System.out.println(i + " " + tab[i]);
        }
        System.out.println();

        //funkcja przystosowania
        double suma = 0;
        double[] tab2 = new double[a];
        //wycinki kola ruletki w %
        double suma2 = 0;
        double[] tab3 = new double[a];
        double[] tab4 = new double[a];
        //losowanie 10 nowych chromosomow
        int[] tab5 = new int[a];
        //
        int[] tab6 = new int[a];
        //krzyzowanie
        int krzyz = 75;
        int[] tab7 = new int[a];
        //po krzyzowaniu
        int[] tab8 = new int[a];
        //mutacja!
        int mutacja = 10;
        int[] tab9 = new int[a];
        //funkcja przystosowania nowej populacji
        double suma3 = 0;
        double[] tab10 = new double[a];



        //
        // rozpoczecie petli
        //
        for(int q=0; q<5; q++) {


//pętla obliczenia funkcji przystosowania
            System.out.println("2. Funkcja przystosowania populacjji:");
            for (int i = 0; i < tab2.length; i++) {
                tab2[i] = (6 * Math.sin(tab[i])) + (2 * Math.log(tab[i])) + 5 * Math.cos(tab[i]);
                if (tab2[i] < 0) {
                    tab2[i] = tab2[i] * (-1);
                }
                System.out.println(i + " " + tab2[i]);
                suma += tab2[i];

            }
            System.out.println("Suma: " + suma);
            System.out.println();


//wycinki koła ruletki w procentach

            System.out.println("3. Wycinki koła ruletki w %:");

            for (int i = 0; i < tab3.length; i++) {
                tab3[i] = tab2[i] / suma * 100;
                suma2 += tab3[i];
                System.out.println((i + 1) + " " + tab3[i] + " %");
                if (i != 0) {
                    tab4[i] = tab3[i] + tab4[i - 1];
                } else tab4[i] = tab3[i];

                //Suma koła ruletki
                //System.out.println("Tab " + i + " " + tab4[i] + "%");

            }
            //System.out.println("suma2: " + suma2);

//losowanie 10 nowych chromosomow i przypisanie do odpowiedniej tablicy


            for (int i = 0; i < tab5.length; i++) {
                tab5[i] = r.nextInt(100) + 1;
            }

            System.out.println("4. 10 nowych chromosomów:");

            for (int i = 0; i < tab6.length; i++) {

                for (int x = 0, j = 1; x < tab6.length; x++) {
                    if (j == tab6.length) {
                        tab6[i] = 10;
                    } else {
                        if (tab5[i] <= tab4[j]) {
                            tab6[i] = j;
                            break;
                        } else j++;
                    }

                }
                System.out.println(tab5[i] + " = " + " " + tab6[i]);
            }
            System.out.println();


            //krzyzowanie
            for (int i = 0, j = 0, l = 1; i < tab7.length; i++, j += 2, l += 2) {
                if (j <= 8)
                    tab7[j] = r.nextInt(100) + 1;
                if (l <= 9)
                    tab7[l] = tab7[j];
                System.out.println(tab7[i] + " " + (j + l));
            }
            System.out.println("Po krzyżowaniu: ");
            for (int i = 0, j = 0, l = 1; i < tab7.length; i++, j += 2, l += 2) {
                if (tab7[i] <= krzyz) {
                    if (j <= 8)
                        tab8[j] = tab5[j] ^ tab5[l];
                    if (l <= 9)
                        tab8[l] = tab5[l] | tab5[j];
                }
                System.out.println(tab8[i]);
            }
            System.out.println();

//mutacja
            System.out.println(" Mutacja: ");
            for (int i = 0; i < tab9.length; i++) {
                tab9[i] = r.nextInt(100) + 1;
                System.out.println(i + " " + tab9[i]);
            }
            System.out.println("Nowa mutacja: ");
            for (int i = 0; i < tab9.length; i++) {
                if (tab9[i] < mutacja) {
                    tab9[i] = tab9[i] << 1;
                }
                System.out.println(tab9[i]);
            }
            System.out.println("Funkcja przystosowania nowej populacji: ");

            suma3 = 0;
            for (int i = 0; i < tab.length; i++) {
                tab[i] = (6 * Math.sin(tab9[i])) + (2 * Math.log(tab9[i])) + 5 * Math.cos(tab9[i]);
                suma3 += tab[i];
                if (tab[i] < 0) {
                    tab[i] = tab[i] * (-1);
                }
                System.out.println(tab[i]);
            }


            //
            //koniec petli
            //
        }

        System.out.println("Wycinki koła ruletki ostatecznej populacji w %:");
        double suma4 = 0;
        double[] tab11 = new double[a];
        double[] tab12 = new double[a];
        for (int i = 0; i<tab.length; i++) {
            tab11[i] = tab[i] / suma3 * 100;
            suma4 += tab11[i];
            System.out.println((i + 1) + " " + tab11[i] + " %");
            if (i != 0) {
                tab12[i] = tab[i] + tab12[i - 1];
            } else tab12[i] = tab[i];
        }
        double ost = 0;
        for(int i=0; i<tab.length; i++ ){
            if (tab[i]>ost){
                ost = tab[i];
            }
        }
        System.out.println("ostateczny: " + ost);





    }
}
