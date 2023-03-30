package homework.Java;

import static org.codehaus.groovy.runtime.DefaultGroovyMethods.printf;

public class test01 {

    public static void main(String[] args) {

        //1 ile 10 arası sayıların toplanını bulunuz ?

        int sum = 0;

        //Code of Java for loop
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }

        System.out.println("sum = " + sum);

        System.out.println("************************************");

        //If we have a for loop inside the another loop, it is known as nested for loop. The inner loop executes completely whenever outer loop executes.


        for (int i = 1; i <= 3; i++) {
   //loop of j
            for (int j = 1; j <= 3; j++) {
                System.out.println(i + " " + j);
            }//end of i
        }//end of j

        System.out.println("***************************************");
        /*    şekili oluşturunuz ..
         *
         * *
         * * *
         * * * *
         * * * * *

         */

        for (int i = 1; i <=5 ; i++) {
            for (int j = 1; j <=i ; j++) {

                System.out.print("*");
            }
            System.out.println();
        }

        /*
         * * * * * *
         * * * * *
         * * * *
         * * *
         * *
         *

         */
        System.out.println("*********************");

        int term=6;
        for(int i=1;i<=term;i++){
            for(int j=term;j>=i;j--){
                System.out.print("*");
            }
            System.out.println();//new line
        }



        int boy=6;

        for (int i = 1; i <=boy ; i++) {
            for (int j = term; j>=i ; j++) {

                System.out.print("*");

            }
            System.out.println();
        }
        System.out.println("***************");



    }
}



