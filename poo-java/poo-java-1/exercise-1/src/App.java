public class App {

    public static void main(String[] args) {
        String[] cities = { "London", "Madrid", "New York", "Buenos Aires", "Asunción", "São Paulo", "Lima",
                "Santiago de Chile", "Lisbon", "Tokio" };
        int[][] temperatures = { { -2, 33 }, { -3, 32 }, { -8, 27 }, { 4, 37 }, { 6, 42 }, { 5, 43 }, { 0, 39 },
                { -7, 26 }, { -1, 31 }, { -10, 35 } };

        String coldestCity = cities[0];
        String hottestCity = cities[0];
        int minTemp = temperatures[0][0];
        int maxTemp = temperatures[0][1];

        for (int i = 0; i < temperatures.length; i++) {
            if (temperatures[i][0] < minTemp) {
                minTemp = temperatures[i][0];
                coldestCity = cities[i];
            }
            if (temperatures[i][1] > maxTemp) {
                maxTemp = temperatures[i][1];
                hottestCity = cities[i];
            }
        }

        System.out.println("Coldest city: " + coldestCity + " - " + minTemp + "°C");
        System.out.println("Hottest city: " + hottestCity + " - " + maxTemp + "°C");
    }

}
