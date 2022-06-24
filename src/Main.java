import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Integer total = main.romanToInt("IV");
        System.out.println(total);
    }
    public int romanToInt(String s) {

        Map<Character, Integer> romanMap = new HashMap<>();
        {
            romanMap.put('O', 0);
            romanMap.put('I', 1);
            romanMap.put('V', 5);
            romanMap.put('X', 10);
            romanMap.put('L', 50);
            romanMap.put('C', 100);
            romanMap.put('D', 500);
            romanMap.put('M', 1000);
        }

        char[] strArray = s.toCharArray();
        int total = 0;
        int last = 1;
        int secondLast = 2;
        int length = s.length();
        int combinedValue = 0;
        int singleTotal = 0;
        char secondLastValue = 0;

        while(last <= length) {

            char lastValue = strArray[strArray.length - last];

            try {
                if (secondLast <= strArray.length) {
                    secondLastValue = strArray[strArray.length - secondLast];
                } else {
                    secondLastValue = 'O';
                }
            }
            catch (Exception e) {
                throw new IndexOutOfBoundsException();
                }

            last = last + 1;
            secondLast = secondLast + 1;

            try {
                if (romanMap.get(lastValue) > romanMap.get(secondLastValue) && !(secondLastValue == 'O')) {
                    combinedValue = romanMap.get(lastValue) - romanMap.get(secondLastValue);
                    last = last + 1;
                    secondLast = secondLast + 1;
                } else
                    singleTotal = romanMap.get(lastValue);
            }
            catch (Exception e) {
                throw new NullPointerException();
            }

            total = singleTotal + combinedValue + total;
            combinedValue = 0;
            singleTotal = 0;
        }

        System.out.println(total);
        return total;
    }
}
