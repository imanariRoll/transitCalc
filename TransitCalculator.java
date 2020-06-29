import java.lang.*;
import java.util.Arrays;

public class TransitCalculator {
    double numberOfDays = 0.0;
    double numberOfRides = 0.0;
    double pricePerRide = 2.75;
    double pricePerWeek = 33.00;
    double priceUnlimited = 127.00;
    double perRide = 0.00;


    public TransitCalculator(double days, double rides){
    numberOfDays = days;
    numberOfRides = rides;


    }

    public double unlimited7Price(){
        double numOfWeeks = Math.ceil(numberOfDays/7) ; // Math.ceil will return the largest integer that is divisble without a remainder //
        double totalPrice = numOfWeeks * pricePerWeek;
        return totalPrice / numberOfRides;


    }

    public double[] getRidePrices(){ // 28/06/2020 Sunday. Math is verified.
        double perRide = pricePerRide * numberOfRides / numberOfDays;
        double perWeek = unlimited7Price();
        double unlimited = priceUnlimited / numberOfRides;
        double ridePrices[]; // Declared Array //
        ridePrices = new double[] {perRide, perWeek, unlimited}; // New array, with added elements. Could be a mistake since I failed to declare elements//

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
        TransitCalculator test = new TransitCalculator(5, 12);

        System.out.println(test.getBestFare()); //

    }
}
