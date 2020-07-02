import java.lang.*;
import java.util.Arrays;

public class TransitCalculator {
    double numberOfDays = 0.0;
    double numberOfRides = 0.0;
    double pricePerRide = 2.75;
    double pricePerWeek = 33.00;
    double priceUnlimited = 127.00;
    double perRide = 0.00;
    double unlimited = 0.00;

    boolean disable = false;
    int passAge = 0;


    public TransitCalculator(double days, double rides, boolean disability, int age){
    numberOfDays = days;
    numberOfRides = rides;
    disable = disability;
    passAge = age;



    }

    public double unlimited7Price() {


        if (passAge >= 65 || disable == true) {
            double numOfWeeks = Math.ceil(numberOfDays / 7);
            double totalPrice = numOfWeeks * (pricePerWeek / 2);
            return totalPrice / numberOfRides;
        } else {

            double numOfWeeks = Math.ceil(numberOfDays / 7); // Math.ceil will return the largest integer that is divisble without a remainder //
            double totalPrice = numOfWeeks * pricePerWeek;
            return totalPrice / numberOfRides;

        }
    }

        public double[] getRidePrices() { // 28/06/2020 Sunday. Math is verified.

            if(disable == true || passAge >= 65){
                 perRide = (pricePerRide-1.4) * numberOfRides / numberOfDays;
            }
            else {
                perRide = pricePerRide * numberOfRides / numberOfDays;
            }

        double perWeek = unlimited7Price();

            if(disable == true || passAge >= 65){
                unlimited = (priceUnlimited/2) / numberOfRides;
            }
            else{

                unlimited = priceUnlimited / numberOfRides;
            }


        double ridePrices[]; // Declared Array //
        ridePrices = new double[] {perRide, perWeek, unlimited};

        return ridePrices;
        }



    public String getBestFare(){  // Error in the iteration and lowest value find! //

        double lowestPriceRide[];
        lowestPriceRide = getRidePrices();
        double lowestPrice = lowestPriceRide[0];


        for(int i = 1; i< lowestPriceRide.length; i++) {
            if (lowestPrice > lowestPriceRide[i]) {
                lowestPrice = lowestPriceRide[i];

            }

        }

        if(lowestPrice == lowestPriceRide[0]){
            System.out.println("You should take the 'Pay per Ride' option in our NYC transit");
        }
        else if(lowestPrice == lowestPriceRide[1]){
             System.out.println("You should take the 'Weekly Unlimited' plan in our NYC Transit");
        }
        else if(lowestPrice == lowestPriceRide[2]){
             System.out.println("You should take the Unlimited ride plan in our NYC Transit");
        }

        return "at " + lowestPrice + "$ per Ride";

    }

    public static void main(String[] args){
        TransitCalculator test = new TransitCalculator(26, 54, false, 20);

        System.out.println(test.getBestFare()); //

    }
}
