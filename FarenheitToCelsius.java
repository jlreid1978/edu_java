public class FarenheitToCelsius {
    public static void main(String[] args) {
        int saturdayFarenheit;
        int sundayFarenheit;
        saturdayFarenheit = 78;
        sundayFarenheit = 81;
        double saturdayCelsius = (5.0/9) * (saturdayFarenheit);
        double sundayCelsius = (5.0/9) * (sundayFarenheit);
        System.out.println("Weekend Averages");
        System.out.println("Saturday :" + saturdayCelsius);
        System.out.println("Sunday :" + sundayCelsius);
    }
}
