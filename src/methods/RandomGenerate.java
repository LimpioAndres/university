package methods;

public class RandomGenerate {

    public static int generateNumberRandom(int min, int max) {

        int number = (int)Math.floor(Math.random()*(min-(max+1))+(max+1));
        return number;

    }
}
